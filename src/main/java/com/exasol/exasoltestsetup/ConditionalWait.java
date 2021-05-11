package com.exasol.exasoltestsetup;

import java.util.function.Supplier;

class ConditionalWait {
    static void waitFor(final long milliSeconds) {
        try {
            Thread.sleep(milliSeconds);
        } catch (final InterruptedException exception) {
            Thread.currentThread().interrupt();
        }
    }

    static void waitUntil(final Supplier<Boolean> predicate) {
        while (!predicate.get()) {
            waitFor(200);
        }
    }
}
