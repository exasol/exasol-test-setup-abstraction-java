package com.exasol.exasoltestsetup.standalone;

/**
 * This interface provides connection details for running Exasol database.
 */
interface ConnectionDetailProvider {

    /**
     * Get the IP address of the management node.
     * 
     * @return ip address
     */
    public String getManagementNodeIp();

    /**
     * Get the ip address of a data node.
     * 
     * @return ip address
     */
    public String getDataNodeIp();

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
