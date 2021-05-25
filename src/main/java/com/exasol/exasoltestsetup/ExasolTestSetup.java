package com.exasol.exasoltestsetup;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.exasol.bucketfs.Bucket;

/**
 * This is an interface for accessing a running Exasol database for testing. It abstracts over the type of installation
 * (cloud / docker, cluster / single-node).
 */
public interface ExasolTestSetup extends AutoCloseable {

    /**
     * Create a connection to the Exasol database with default credentials.
     * 
     * @return SQL connection
     * @throws SQLException if something went wrong
     */
    public Connection createConnection() throws SQLException;

    /**
     * Get an API object for the default BucketFS bucket.
     * 
     * @return API object for the default BucketFS bucket
     */
    public Bucket getDefaultBucket();

    /**
     * Make a local service available from within the Exasol database.
     * 
     * @param localPort port of the service @ localhost
     * @return host or ip address under which the service is available from within the exasol database (same port)
     */
    public String makeLocalServiceAvailableInDatabase(int localPort);

    /**
     * Make the port of a database node available from localhost. If the target is a cluster, this methods sets up a
     * redirect for each node and returns multiple local port numbers.
     * 
     * @param databasePort database port
     * @return list of local port numbers. One entry per cluster node.
     */
    public List<Integer> makeDatabaseServiceAvailableAtLocalhost(int databasePort);

    /**
     * Make a given service available inside of the Exasol database.
     * 
     * @param serviceAddress service address in the format host:port
     * @return modified address in the format host:port
     */
    public default String makeServiceAvailableInDatabase(final String serviceAddress) {
        final Pattern localhostPattern = Pattern.compile("(?:127\\.0\\.0\\.1|localhost):(\\d+)");
        final Matcher matcher = localhostPattern.matcher(serviceAddress);
        if (matcher.matches()) {
            final int port = Integer.parseInt(matcher.group(1));
            final String newHost = this.makeLocalServiceAvailableInDatabase(port);
            return newHost + ":" + port;
        } else {
            return serviceAddress;
        }
    }
}
