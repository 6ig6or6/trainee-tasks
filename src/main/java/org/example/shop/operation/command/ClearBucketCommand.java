package org.example.shop.operation.command;

import org.example.shop.user.Bucket;

public class ClearBucketCommand implements Command {
    private final Bucket bucket;

    public ClearBucketCommand(Bucket bucket) {
        this.bucket = bucket;
    }

    @Override
    public void execute() {
        bucket.clear();
    }
}
