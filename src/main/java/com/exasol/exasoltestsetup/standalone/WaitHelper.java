package com.exasol.exasoltestsetup.standalone;

import java.util.function.BooleanSupplier;

/**
 * Helper class for waiting.
 */
public class WaitHelper {
    private WaitHelper() {
        // empty on purpose
    }

    /**
     * Wait until a given time.
     * 
     * @param milliSeconds time in milliseconds
     */
    public static void waitFor(final long milliSeconds) {
        try {
            Thread.sleep(milliSeconds);
        } catch (final InterruptedException exception) {
            Thread.currentThread().interrupt();
        }
    }

    /**
     * Wait until the given supplier gives {@code true}.
     * <p>
     * This method checks the predicate every 200 ms.
     * </p>
     * 
     * @param predicate function that tells if waiting should be over
     */
    public static void waitUntil(final BooleanSupplier predicate) {
        while (!predicate.getAsBoolean()) {
            waitFor(200);
        }
    }
}
