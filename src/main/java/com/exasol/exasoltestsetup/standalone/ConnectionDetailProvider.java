package com.exasol.exasoltestsetup.standalone;

/**
 * This interface provides connection details for running Exasol database.
 */
interface ConnectionDetailProvider {

    /**
     * Get the IP address / host name of the management node.
     * 
     * @return ip address
     */
    public String getManagementNodeAddress();

    /**
     * Get the ip address / host name of a data node.
     * 
     * @return ip address
     */
    public String getDataNodeAddress();

    /**
     * Get credentials for the database.
     * 
     * @return credentials
     */
    public Credentials getDatabaseCredentials();

    /**
     * Get admin credentials for EXAOperation.
     * 
     * @return credentials
     */
    public Credentials getAdminCredentials();

    /**
     * Get the SSH port of the database.
     * 
     * @return ssh port number
     */
    public int getSshPort();
}
