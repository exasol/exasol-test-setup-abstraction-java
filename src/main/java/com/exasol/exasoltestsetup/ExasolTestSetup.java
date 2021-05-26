package com.exasol.exasoltestsetup;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

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
     * Make a local TCP service available from within the Exasol database.
     * <p>
     * You can use this method for example for accessing a local s3 bucket implementation from inside the Exasol
     * database. Another example is to connect from UDFs to a debugger running on the test PC.
     * </p>
     * 
     * @param localPort port of the service @ localhost
     * @return address under which the service is available from within the exasol database (same port)
     */
    public ServiceAddress makeLocalTcpServiceAccessibleFromDatabase(int localPort);

    /**
     * Make the port of a database node available from localhost. If the target is a cluster, this methods sets up a
     * redirect for each node and returns multiple local port numbers.
     * <p>
     * You can use this method for example to connect from your test PC to a profiling agent that listens on a TCP
     * socket in an UDF.
     * </p>
     * 
     * @param databasePort database port
     * @return list of local port numbers. One entry per cluster node.
     */
    public List<Integer> makeDatabaseTcpServiceAccessibleFromLocalhost(int databasePort);

    /**
     * Make a given TCP service available inside of the Exasol database.
     * 
     * @param serviceAddress service address in the format host:port
     * @return modified service address
     */
    public default ServiceAddress makeTcpServiceAccessibleFromDatabase(final ServiceAddress serviceAddress) {
        if (serviceAddress.isLocal()) {
            return this.makeLocalTcpServiceAccessibleFromDatabase(serviceAddress.getPort());
        } else {
            return serviceAddress;
        }
    }
}
