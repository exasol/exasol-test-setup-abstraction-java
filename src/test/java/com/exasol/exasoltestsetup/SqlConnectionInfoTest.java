package com.exasol.exasoltestsetup;

import org.junit.jupiter.api.Test;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

class SqlConnectionInfoTest {
    @Test
    void testEqualsContract() {
        EqualsVerifier.forClass(SqlConnectionInfo.class).suppress(Warning.STRICT_INHERITANCE).verify();
    }
}
