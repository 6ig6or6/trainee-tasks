package org.example.shop.operation;

import org.example.shop.Bucket;
import org.example.shop.Storage;
import org.example.shop.product.AbstractProduct;
import org.example.shop.util.ConsoleHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class OperationProcessor {
    private static final Logger logger = LoggerFactory.getLogger(OperationProcessor.class);
    private Bucket bucket;

    public OperationProcessor(Bucket bucket) {
        this.bucket = bucket;
    }

    public void getInput() {
        String input;
        while (true) {
            printAllOperations();
            input = ConsoleHelper.readLine();
            if ("exit".equals(input) || "finish".equals(input)) {
                break;
            }
            chooseOperation(input);
        }
    }
    public void chooseOperation(String operation) {
        Operation currentOperation;
        switch (operation) {
            case "1" -> currentOperation = Operation.SHOW_PRODUCT_LIST;
            case "2" -> currentOperation = Operation.ADD_PRODUCT;
            case "3" -> currentOperation = Operation.SHOW_BUCKET;
            case "4" -> currentOperation = Operation.DELETE_PRODUCT;
            case "5" -> currentOperation = Operation.CLEAR_BUCKET;
            default -> currentOperation = Operation.UNKNOWN_OPERATION;
        }
        processOperation(currentOperation);
    }

    private void printAllOperations() {
        ConsoleHelper.printLine("Choose needed operation or press exit:\n" +
                "1. Show product list.\n" +
                "2. Add chosen product to the bucket\n" +
                "3. Show products in the bucket\n" +
                "4. Delete(particular) product from the bucket\n" +
                "5. Clear the bucket\n" +
                "Enter number of the needed operation:");
    }

    private void processOperation(Operation operation) {
        switch (operation) {
            case SHOW_PRODUCT_LIST -> showProductList();
            case ADD_PRODUCT -> addProductToBucket();
            case SHOW_BUCKET -> showProductsInBucket();
            case CLEAR_BUCKET -> clearBucket();
            case DELETE_PRODUCT -> deleteProductInBucket();
            case UNKNOWN_OPERATION -> processUnknownOperation();
        }
    }

    private void showProductList() {
        ConsoleHelper.printLine("All available products are:");
        AtomicInteger position = new AtomicInteger();
        Storage.getAllProducts()
                .forEach(x -> ConsoleHelper.printLine(position.incrementAndGet() + " " + x));
    }

    private void addProductToBucket() {
        ConsoleHelper.printLine("Adding product to the bucket");
        int productNumber;
        try {
            productNumber = getProductNumber(Storage.getAllProducts());
        } catch (IllegalArgumentException e) {
            ConsoleHelper.printLine("Wrong number entered");
            logger.warn("Wrong symbol entered", e);
            return;
        }
        bucket.addProduct(Storage.getAllProducts().get(productNumber));
    }

    private void showProductsInBucket() {
        ConsoleHelper.printLine("The bucket contains:");
        bucket.printBucketContent();
    }

    private void deleteProductInBucket() {
        ConsoleHelper.printLine("Deleting product from the bucket");
        int productNumber;
        try {
            productNumber = getProductNumber(bucket.getProductsInBucket());
        } catch (IllegalArgumentException e) {
            ConsoleHelper.printLine("Wrong number entered");
            logger.warn("Wrong symbol entered", e);
            return;
        }
        bucket.deleteProduct(productNumber);
    }

    private void clearBucket() {
        bucket.clear();
        ConsoleHelper.printLine("The bucket is empty now");
    }

    private void processUnknownOperation() {
        ConsoleHelper.printLine("Wrong operation number!");
        logger.info("A user chose wrong operation type");
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
