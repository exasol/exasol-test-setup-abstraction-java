package com.exasol.exasoltestsetup.standalone;

import org.junit.jupiter.api.Test;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

class ConnectionDetailsTest {
    @Test
    void testEqualsContract() {
        EqualsVerifier.forClass(ConnectionDetails.class).suppress(Warning.STRICT_INHERITANCE).verify();
    }
}
