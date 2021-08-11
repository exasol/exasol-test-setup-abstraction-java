package com.exasol.exasoltestsetup;

import static org.hamcrest.MatcherAssert.assertThat;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class WaitHelperTest {

    @Test
    void testWaitUntil() {
        final long start = System.currentTimeMillis();
        WaitHelper.waitUntil(() -> System.currentTimeMillis() - start > 500);
        assertThat(System.currentTimeMillis(), Matchers.greaterThan(start + 500));
    }
}