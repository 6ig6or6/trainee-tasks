package org.example.shop.operation.command;

import org.example.shop.user.Bucket;
import org.example.shop.util.ConsoleHelper;

public class SeeCurrentBucketAmountCommand implements Command {
    private final Bucket bucket;

    public SeeCurrentBucketAmountCommand(Bucket bucket) {
        this.bucket = bucket;
    }

    @Override
    public void execute() {
        ConsoleHelper.printLine("Current bucket amount is: " + bucket.getTotalSum());
    }
}
