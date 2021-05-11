package com.exasol.exasoltestsetup;

import static com.exasol.exasoltestsetup.ConditionalWait.waitFor;
import static com.exasol.exasoltestsetup.ConditionalWait.waitUntil;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import javax.net.ssl.*;

import org.apache.commons.compress.utils.IOUtils;
import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.*;

import com.exasol.errorreporting.ExaError;

class ExaOperationInterface {
    private static final Logger LOGGER = Logger.getLogger(ExaOperationInterface.class.getName());
    private final XmlRpcClient client;

    public ExaOperationInterface(final String exasolIpAddress, final String adminUser, final String adminPass) {
        try {
            final XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
            config.setServerURL(new URL("https://" + exasolIpAddress + "/cluster1"));
            config.setBasicUserName(adminUser);
            config.setBasicPassword(adminPass);
            this.client = new XmlRpcClient();
            this.client.setConfig(config);
            setTrustAllCerts();
        } catch (final NoSuchAlgorithmException | KeyManagementException | MalformedURLException exception) {
            throw new IllegalStateException(ExaError.messageBuilder("E-ETAJ-1")
                    .message("Failed to connect to the ExaOperation XML-RPC interface.").toString(), exception);
        }
    }

    public void startStorageServiceIfNotRunning() {
        if (!isStorageServiceRunning()) {
            startStorageService();
        }
    }

    private void startStorageService() {
        try {
            LOGGER.info("Starting exasol storage service via ExaOperation.");
            this.client.execute("storage.startEXAStorage", new Object[] {});
            waitUntil(this::isStorageServiceRunning);
        } catch (final XmlRpcException exception) {
            throw new IllegalStateException(
                    ExaError.messageBuilder("E-ETAJ-7").message("Failed to start exasol storage service.").toString(),
                    exception);
        }
    }

    private boolean isStorageServiceRunning() {
        try {
            return (boolean) this.client.execute("storage.serviceIsOnline", new Object[] {});
        } catch (final XmlRpcException exception) {
            throw new IllegalStateException(ExaError.messageBuilder("E-ETAJ-14")
                    .message("Failed to test if exasol storage service is running.").toString(), exception);
        }
    }

    public void startAllDatabases() {
        listDatabases().forEach(this::startDatabaseIfNotRunning);
    }

    public List<String> listDatabases() {
        try {
            final Object[] result = (Object[]) this.client.execute("getDatabaseList", new Object[] {});
            return Arrays.stream(result).map(String.class::cast).collect(Collectors.toList());
        } catch (final XmlRpcException exception) {
            throw new IllegalStateException(
                    ExaError.messageBuilder("E-ETAJ-8").message("Failed list exasol databases.").toString(), exception);
        }
    }

    public void startDatabaseIfNotRunning(final String databaseName) {
        if (!isDatabaseRunning(databaseName)) {
            startDatabase(databaseName);
        }
    }

    private void startDatabase(final String databaseName) {
        try {
            LOGGER.log(Level.INFO, "Starting exasol database {} via ExaOperation.", databaseName);
            this.client.execute("db_" + databaseName + ".startDatabase", new Object[] {});
            waitUntil(() -> isDatabaseRunning(databaseName));
            waitFor(1000);// it needs some time until it's really available
        } catch (final XmlRpcClientException exception) {
            // response parse fails, but start works anyway
        } catch (final XmlRpcException exception) {
            throw new IllegalStateException(
                    ExaError.messageBuilder("E-ETAJ-9").message("Failed to start exasol databases.").toString(),
                    exception);
        }
    }

    private boolean isDatabaseRunning(final String databaseName) {
        try {
            return (boolean) this.client.execute("db_" + databaseName + ".runningDatabase", new Object[] {});
        } catch (final XmlRpcException exception) {
            throw new IllegalStateException(
                    ExaError.messageBuilder("E-ETAJ-10").message("Failed to test if database is running.").toString(),
                    exception);
        }
    }

    public void setBucketfsPort(final int port) {
        try {
            this.client.execute("bfsdefault.editBucketFS", new Object[] { Map.of("http_port", port) });
        } catch (final XmlRpcException exception) {
            throw new IllegalStateException(ExaError.messageBuilder("E-ETAJ-2")
                    .message("Failed to set BucketFS port in ExaOperation.").toString(), exception);
        }
    }

    public void setBucketPasswords(final String readPassword, final String writePassword) {
        try {
            this.client.execute("bfsdefault.default.editBucketFSBucket",
                    new Object[] { Map.of("read_password", readPassword, "write_password", writePassword) });
        } catch (final XmlRpcException exception) {
            throw new IllegalStateException(ExaError.messageBuilder("E-ETAJ-3")
                    .message("Failed to set BucketFS password in ExaOperation.").toString(), exception);
        }
    }

    public void createAndUploadJdbcDriver(final String name, final String jdbcMainClass, final String prefix,
            final boolean disableSecurityManager, final File driverJar) throws IOException {
        final String driverId = addJdbcDriver(name, jdbcMainClass, prefix, disableSecurityManager);
        uploadJdbcDriver(driverId, driverJar);
    }

    private String addJdbcDriver(final String name, final String jdbcMainClass, final String prefix,
            final boolean disableSecurityManager) {
        try {
            return (String) this.client.execute("addJDBCDriver", new Object[] { Map.of("jdbc_main", jdbcMainClass,
                    "jdbc_name", name, "jdbc_prefix", prefix, "disable_security_manager", disableSecurityManager) });
        } catch (final XmlRpcException exception) {
            throw new IllegalStateException(ExaError.messageBuilder("E-ETAJ-4")
                    .message("Failed to add JDBC driver using ExaOperation.").toString(), exception);
        }
    }

    private void uploadJdbcDriver(final String jdbcDriverId, final File file) throws IOException {
        try (final InputStream inputStream = new FileInputStream(file)) {
            final byte[] driverBytes = IOUtils.toByteArray(inputStream);
            this.client.execute(jdbcDriverId + ".uploadFile", new Object[] { driverBytes, file.getName() });
        } catch (final XmlRpcClientException exception) {
            // This exception happens always. I don't know why but it still works...
        } catch (final XmlRpcException exception) {
            throw new IllegalStateException(ExaError.messageBuilder("E-ETAJ-5")
                    .message("Failed to upload JDBC driver using ExaOperation.").toString(), exception);
        }
    }

    public void setTrustAllCerts() throws NoSuchAlgorithmException, KeyManagementException {
        try {
            // Create a trust manager that does not validate certificate chains
            final TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
                public X509Certificate[] getAcceptedIssuers() {
                    return null;
                }

                public void checkClientTrusted(final X509Certificate[] certs, final String authType) {
                }

                public void checkServerTrusted(final X509Certificate[] certs, final String authType) {
                }
            } };

            // Install the all-trusting trust manager
            final SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, trustAllCerts, new java.security.SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

            // Create all-trusting host name verifier
            final HostnameVerifier allHostsValid = new HostnameVerifier() {
                public boolean verify(final String hostname, final SSLSession session) {
                    return true;
                }
            };

            // Install the all-trusting host verifier
            HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
        } catch (final NoSuchAlgorithmException | KeyManagementException e) {
            throw new IllegalStateException(ExaError.messageBuilder("E-ETAJ-6")
                    .message("Failed to configure Java to trust all certificates.").toString());
        }
    }
}