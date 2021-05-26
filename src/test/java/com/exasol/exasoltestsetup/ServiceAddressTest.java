package com.exasol.exasoltestsetup;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import nl.jqno.equalsverifier.EqualsVerifier;

class ServiceAddressTest {
    @Test
    void testParseValid() {
        final ServiceAddress address = ServiceAddress.parse("localhost:123");
        assertAll(//
                () -> assertThat(address.getHostName(), equalTo("localhost")), //
                () -> assertThat(address.getPort(), equalTo(123))//
        );
    }

    @Test
    void testParseInvalid() {
        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> ServiceAddress.parse("localhost"));
        assertThat(exception.getMessage(),
                equalTo("E-ETAJ-18: Invalid service address 'localhost'. The address must have the format host:port."));
    }

    @Test
    void testToString() {
        assertThat(new ServiceAddress("10.2.0.1", 123).toString(), equalTo("10.2.0.1:123"));
    }

    @Test
    void testEquals() {
        EqualsVerifier.simple().forClass(ServiceAddress.class).verify();
    }

    @ParameterizedTest
    @CsvSource({ //
            "localhost, true", //
            "127.0.0.1, true", //
            "exasol.com, false",//
    })
    void testIsLocal(final String host, final boolean expectedResult) {
        assertThat(new ServiceAddress(host, 123).isLocal(), equalTo(expectedResult));
    }
}