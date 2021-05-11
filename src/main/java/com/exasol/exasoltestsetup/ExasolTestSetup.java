package com.exasol.exasoltestsetup;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.exasol.bucketfs.Bucket;

public interface ExasolTestSetup {

    Connection createConnection() throws SQLException;

    public Bucket getDefaultBucket();

    public void teardown();

    /**
     * Make a service running on the test host available from within the exasol database.
     * 
     * @param hostPort port of the host
     * @return host or ip address under which the service is available from within the exasol database
     */
    public String makeLocalServiceAvailableInDatabase(int hostPort);

    /**
     * Make the port of a database node available from localhost.
     * 
     * @param databasePort database port
     * @return local port number
     */
    public int makeDatabaseServiceAvailableAtLocalhost(int databasePort);

    /**
     * If the given address string has a format like localhost:port or 127.0.0.1:port this method replace it by a an
     * access string by which this service is available from inside the exasol database.
     * <p>
     * Else this method returns the string unchanged
     * </p>
     * 
     * @param address address to check
     * @return modified address in the format host:port
     */
    public default String makeHostPortAvailableInDatabaseIfRequired(final String address) {
        final Pattern localhostPattern = Pattern.compile("(?:127\\.0\\.0\\.1|localhost):(\\d+)");
        final Matcher matcher = localhostPattern.matcher(address);
        if (matcher.matches()) {
            final int port = Integer.parseInt(matcher.group(1));
            final String newHost = this.makeLocalServiceAvailableInDatabase(port);
            return newHost + ":" + port;
        } else {
            return address;
        }
    }
}
