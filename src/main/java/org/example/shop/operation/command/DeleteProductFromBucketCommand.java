package org.example.shop.operation.command;

import org.example.shop.product.AbstractProduct;
import org.example.shop.user.Bucket;
import org.example.shop.util.ConsoleHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class DeleteProductFromBucketCommand implements Command {
    private static final Logger logger = LoggerFactory.getLogger(DeleteProductFromBucketCommand.class);
    private final Bucket bucket;

    public DeleteProductFromBucketCommand(Bucket bucket) {
        this.bucket = bucket;
    }

    @Override
    public void execute() {
        ConsoleHelper.printLine("Deleting product from the bucket");
        int productNumber;
        try {
            productNumber = getProductNumber(bucket.getProducts());
        } catch (IllegalArgumentException e) {
            ConsoleHelper.printLine("Wrong number entered");
            logger.warn("Wrong symbol entered", e);
            return;
        }
        bucket.deleteProduct(productNumber);
    }

    private int getProductNumber(List<AbstractProduct> source) {
        ConsoleHelper.printLine("Please provide product number");
        int number = Integer.parseInt(ConsoleHelper.readLine());
        if (number > source.size()) {
            throw new IllegalArgumentException();
        }
        return --number;
    }
}
