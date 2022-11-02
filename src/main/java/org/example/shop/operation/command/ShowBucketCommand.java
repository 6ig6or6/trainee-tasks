package org.example.shop.operation.command;

import org.example.shop.user.Bucket;

public class ShowBucketCommand implements Command {
    private final Bucket bucket;

    public ShowBucketCommand(Bucket bucket) {
        this.bucket = bucket;
    }

    @Override
    public void execute() {
        bucket.printContent();
    }
}
