package com.exasol.exasoltestsetup.standalone;

import com.exasol.bucketfs.BucketAccessException;
import com.exasol.bucketfs.ReadOnlyBucket;
import com.exasol.bucketfs.monitor.BucketFsMonitor;

/**
 * This simple {@link BucketFsMonitor} waits for one second and hopes that the contents will be synchronized.
 * <p>
 * In the future this class should be replaced by a proper implementation (see
 * https://github.com/exasol/exasol-test-setup-abstraction-java/issues/5).
 * </p>
 */
class WaitBucketFsMonitor implements BucketFsMonitor {
    @Override
    public boolean isObjectSynchronized(final ReadOnlyBucket bucket, final String pathInBucket, final State state)
            throws BucketAccessException {
        try {
            Thread.sleep(1000);
        } catch (final InterruptedException exception) {
            Thread.currentThread().interrupt();
        }
        return true;
    }
}
