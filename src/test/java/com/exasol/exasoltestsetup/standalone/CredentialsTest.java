package com.exasol.exasoltestsetup.standalone;

import org.junit.jupiter.api.Test;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

class CredentialsTest {
    @Test
    void testEqualsContract() {
        EqualsVerifier.forClass(Credentials.class).suppress(Warning.STRICT_INHERITANCE).verify();
    }
}
