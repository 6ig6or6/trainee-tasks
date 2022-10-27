package org.example.shop;

import org.example.shop.product.AbstractProduct;
import org.example.shop.util.ConsoleHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Bucket {
    private final List<AbstractProduct> productsInBucket;

    public Bucket() {
        this.productsInBucket = new ArrayList<>();
    }

    public void printBucketContent() {
        if (productsInBucket.isEmpty()) {
            ConsoleHelper.printLine("The bucket is empty");
        } else {
            AtomicInteger position = new AtomicInteger();
            productsInBucket
                    .forEach(x -> ConsoleHelper.printLine(position.incrementAndGet() + " " + x));
        }
    }

    public void deleteProduct(int pos) {
        AbstractProduct abstractProduct = productsInBucket.get(pos);
        if (!productsInBucket.remove(abstractProduct)) {
            ConsoleHelper.printLine("Bucket doesn't contain this product");
        } else {
            ConsoleHelper.printLine("Product was successfully removed");
        }
    }

    public void addProduct(AbstractProduct abstractProduct) {
        productsInBucket.add(abstractProduct);
        ConsoleHelper.printLine("Product was successfully added");
    }

    public void clear() {
        productsInBucket.clear();
    }

    public List<AbstractProduct> getProductsInBucket() {
        return productsInBucket;
    }
}
