package com.exasol.exasoltestsetup.standalone;

import java.time.Instant;

import com.exasol.bucketfs.BucketFsMonitor;
import com.exasol.bucketfs.ReadOnlyBucket;

/**
 * This simple {@link BucketFsMonitor} waits for one second and hopes that the contents will be synchronized.
 * <p>
 * In the future this class should be replaced by a proper implementation (see
 * https://github.com/exasol/exasol-test-setup-abstraction-java/issues/5).
 * </p>
 */
class WaitBucketFsMonitor implements BucketFsMonitor {
    @Override
    public boolean isObjectSynchronized(final ReadOnlyBucket bucket, final String pathInBucket, final Instant afterUTC)
            throws InterruptedException {
        Thread.sleep(1000);
        return true;
    }
}
