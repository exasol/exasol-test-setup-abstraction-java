package com.exasol.exasoltestsetup;

import java.time.Instant;

import com.exasol.bucketfs.*;

class WaitBucketfsMonitor implements BucketFsMonitor {
    @Override
    public boolean isObjectSynchronized(final ReadOnlyBucket bucket, final String pathInBucket, final Instant afterUTC)
            throws InterruptedException, BucketAccessException {
        Thread.sleep(1000);
        return true;
    }
}
