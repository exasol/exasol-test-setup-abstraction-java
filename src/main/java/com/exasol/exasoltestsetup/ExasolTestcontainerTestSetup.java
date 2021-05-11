package com.exasol.exasoltestsetup;

import java.sql.Connection;
import java.sql.SQLException;

import com.exasol.bucketfs.Bucket;
import com.exasol.containers.ExasolContainer;

public class ExasolTestcontainerTestSetup implements ExasolTestSetup {
    private final ExasolContainer<? extends ExasolContainer<?>> exasolContainer = new ExasolContainer<>()
            .withReuse(true);

    public ExasolTestcontainerTestSetup() {
        this.exasolContainer.addExposedPort(9100);
        this.exasolContainer.start();
    }

    @Override
    public Connection createConnection() throws SQLException {
        return this.exasolContainer.createConnection();
    }

    @Override
    public Bucket getDefaultBucket() {
        return this.exasolContainer.getDefaultBucket();
    }

    @Override
    public void teardown() {
        this.exasolContainer.stop();
    }

    @Override
    public String makeLocalServiceAvailableInDatabase(final int hostPort) {
        return this.exasolContainer.getHostIp();
    }

    @Override
    public int makeDatabaseServiceAvailableAtLocalhost(final int databasePort) {
        this.exasolContainer.addExposedPort(databasePort);
        return databasePort;
    }
}
