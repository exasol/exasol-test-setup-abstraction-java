package com.exasol.exasoltestsetup.standalone;

import static com.exasol.exasoltestsetup.WaitHelper.waitFor;
import static com.exasol.exasoltestsetup.WaitHelper.waitUntil;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.apache.commons.io.IOUtils;

import com.exasol.errorreporting.ExaError;

import de.timroes.axmlrpc.XMLRPCClient;
import de.timroes.axmlrpc.XMLRPCException;

/**
 * This class wraps the ExaOperation XML-RPC API of an Exasol cluster with Java methods.
 */
class ExaOperationGateway {
    private static final Logger LOGGER = Logger.getLogger(ExaOperationGateway.class.getName());
    private final XMLRPCClient client;

    /**
     * Create a new instance of {@link ExaOperationGateway}.
     * 
     * @param exasolIpAddress ip address of the management node
     * @param credentials     credentials for EXAOperation
     */
    public ExaOperationGateway(final String exasolIpAddress, final Credentials credentials) {
        try {
            final URL serverUrl = new URL("https://" + exasolIpAddress + "/cluster1");
            // No validation is intended. A better approach is planned:
            // https://github.com/exasol/exasol-test-setup-abstraction-java/issues/25
            this.client = new XMLRPCClient(serverUrl,
                    XMLRPCClient.FLAGS_SSL_IGNORE_INVALID_CERT | XMLRPCClient.FLAGS_SSL_IGNORE_INVALID_HOST);
            this.client.setLoginData(credentials.getUsername(), credentials.getPassword());
        } catch (final MalformedURLException exception) {
            throw new IllegalStateException(ExaError.messageBuilder("E-ETAJ-1")
                    .message("Failed to connect to the ExaOperation XML-RPC interface.").toString(), exception);
        }
    }

    /**
     * Start the Exasol storage service if it is not already running.
     */
    public void startStorageServiceIfNotRunning() {
        if (!isStorageServiceRunning()) {
            startStorageService();
        }
    }

    private void startStorageService() {
        try {
            LOGGER.info("Starting exasol storage service via ExaOperation.");
            this.client.call("storage.startEXAStorage");
            waitUntil(this::isStorageServiceRunning, 60, "starting storage service");
        } catch (final XMLRPCException exception) {
            throw new IllegalStateException(
                    ExaError.messageBuilder("E-ETAJ-7").message("Failed to start exasol storage service.").toString(),
                    exception);
        }
    }

    private boolean isStorageServiceRunning() {
        try {
            final Object[] args = new Object[] {};
            return (boolean) this.client.call("storage.serviceIsOnline", args);
        } catch (final XMLRPCException exception) {
            throw new IllegalStateException(ExaError.messageBuilder("E-ETAJ-14")
                    .message("Failed to test if exasol storage service is running.").toString(), exception);
        }
    }

    /**
     * Start all databases if they are not already running.
     */
    public void startAllDatabases() {
        listDatabases().forEach(this::startDatabaseIfNotRunning);
    }

    /**
     * List all databases.
     * 
     * @return list of databases
     */
    public List<String> listDatabases() {
        try {
            final Object[] result = (Object[]) this.client.call("getDatabaseList");
            return Arrays.stream(result).map(String.class::cast).collect(Collectors.toList());
        } catch (final XMLRPCException exception) {
            throw new IllegalStateException(
                    ExaError.messageBuilder("E-ETAJ-8").message("Failed list exasol databases.").toString(), exception);
        }
    }

    /**
     * Start an Exasol database if it is not already running.
     * 
     * @param databaseName name of the database
     */
    public void startDatabaseIfNotRunning(final String databaseName) {
        if (!isDatabaseRunning(databaseName)) {
            startDatabase(databaseName);
        }
    }

    private void startDatabase(final String databaseName) {
        try {
            LOGGER.log(Level.INFO, "Starting exasol database {0} via ExaOperation.", databaseName);
            this.client.call("db_" + databaseName + ".startDatabase");
            waitUntil(() -> isDatabaseRunning(databaseName), 60, "starting database");
            waitFor(1000); // it needs some time until it's really available
        } catch (final XMLRPCException exception) {
            throw new IllegalStateException(
                    ExaError.messageBuilder("E-ETAJ-9").message("Failed to start exasol databases.").toString(),
                    exception);
        }
    }

    private boolean isDatabaseRunning(final String databaseName) {
        try {
            return (boolean) this.client.call("db_" + databaseName + ".runningDatabase");
        } catch (final XMLRPCException exception) {
            throw new IllegalStateException(
                    ExaError.messageBuilder("E-ETAJ-10").message("Failed to test if database is running.").toString(),
                    exception);
        }
    }

    /**
     * Set the port of a BucketFs service.
     * 
     * @param bucketFsName BucketFs name
     * @param port         port
     */
    public void setBucketFsPort(final String bucketFsName, final int port) {
        try {
            this.client.call(bucketFsName + ".editBucketFS", Map.of("http_port", port));
        } catch (final XMLRPCException exception) {
            throw new IllegalStateException(ExaError.messageBuilder("E-ETAJ-2")
                    .message("Failed to set BucketFS port in ExaOperation.").toString(), exception);
        }
    }

    /**
     * Set the read and write password of a BucketFs Bucket.
     * 
     * @param readPassword  read password
     * @param writePassword write password
     */
    public void setBucketPasswords(final String readPassword, final String writePassword) {
        try {
            this.client.call("bfsdefault.default.editBucketFSBucket",
                    Map.of("read_password", readPassword, "write_password", writePassword));
        } catch (final XMLRPCException exception) {
            throw new IllegalStateException(ExaError.messageBuilder("E-ETAJ-3")
                    .message("Failed to set BucketFS password in ExaOperation.").toString(), exception);
        }
    }

    /**
     * Install a JDBC driver.
     * 
     * @param name                   driver name
     * @param jdbcMainClass          driver class
     * @param prefix                 driver prefix
     * @param disableSecurityManager flag to disable security manager
     * @param driverJar              driver jar file
     * @throws IOException if upload failed
     */
    public void createAndUploadJdbcDriver(final String name, final String jdbcMainClass, final String prefix,
            final boolean disableSecurityManager, final File driverJar) throws IOException {
        final String driverId = addJdbcDriver(name, jdbcMainClass, prefix, disableSecurityManager);
        uploadJdbcDriver(driverId, driverJar);
    }

    private String addJdbcDriver(final String name, final String jdbcMainClass, final String prefix,
            final boolean disableSecurityManager) {
        try {
            return (String) this.client.call("addJDBCDriver", Map.of("jdbc_main", jdbcMainClass, "jdbc_name", name,
                    "jdbc_prefix", prefix, "disable_security_manager", disableSecurityManager));
        } catch (final XMLRPCException exception) {
            throw new IllegalStateException(ExaError.messageBuilder("E-ETAJ-4")
                    .message("Failed to add JDBC driver using ExaOperation.").toString(), exception);
        }
    }

    private void uploadJdbcDriver(final String jdbcDriverId, final File file) throws IOException {
        try (final InputStream inputStream = new FileInputStream(file)) {
            final byte[] driverBytes = IOUtils.toByteArray(inputStream);
            this.client.call(jdbcDriverId + ".uploadFile", driverBytes, file.getName());
        } catch (final XMLRPCException exception) {
            throw new IllegalStateException(ExaError.messageBuilder("E-ETAJ-5")
                    .message("Failed to upload JDBC driver using ExaOperation.").toString(), exception);
        }
    }
}
