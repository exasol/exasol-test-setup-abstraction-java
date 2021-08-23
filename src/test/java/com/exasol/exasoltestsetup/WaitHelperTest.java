package com.exasol.exasoltestsetup;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class WaitHelperTest {

    @Test
    void testWaitUntil() {
        final long start = System.currentTimeMillis();
        WaitHelper.waitUntil(() -> System.currentTimeMillis() - start > 500, 10, "");
        assertThat(System.currentTimeMillis(), Matchers.greaterThan(start + 500));
    }

    @Test
    void testWaitTimeout() {
        final IllegalStateException exception = assertThrows(IllegalStateException.class,
                () -> WaitHelper.waitUntil(() -> false, 1, "demo task"));
        assertThat(exception.getMessage(), equalTo("E-ETAJ-31: Timeout waiting for demo task."));
    }
}