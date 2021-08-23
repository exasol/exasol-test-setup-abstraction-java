package com.exasol.exasoltestsetup;

import java.util.concurrent.TimeUnit;
import java.util.function.BooleanSupplier;

import com.exasol.errorreporting.ExaError;

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
     * @param predicate       function that tells if waiting should be over
     * @param timeoutAfterSec maximum number of seconds to wait
     * @param jobDescription  name of the condition to wait on. Used in the timeout exception.
     */
    public static void waitUntil(final BooleanSupplier predicate, final int timeoutAfterSec,
            final String jobDescription) {
        final long start = System.currentTimeMillis();
        while (!predicate.getAsBoolean()) {
            final long elapsed = System.currentTimeMillis() - start;
            if (TimeUnit.MILLISECONDS.toSeconds(elapsed) > timeoutAfterSec) {
                throw new IllegalStateException(ExaError.messageBuilder("E-ETAJ-31")
                        .message("Timeout waiting for {{jobDescription|uq}}.", jobDescription).toString());
            }
            waitFor(200);
        }
    }
}
