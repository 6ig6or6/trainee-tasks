package org.example.shop;

import org.example.shop.product.AbstractProduct;
import org.example.shop.util.ConsoleHelper;
import org.example.shop.util.PriceCounter;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Bucket implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private final List<AbstractProduct> products;

    public Bucket() {
        this.products = new ArrayList<>();
    }

    public void printContent() {
        if (products.isEmpty()) {
            ConsoleHelper.printLine("The bucket is empty");
        } else {
            ConsoleHelper.printLine("The bucket contains:");
            AtomicInteger position = new AtomicInteger();
            products
                    .forEach(x -> ConsoleHelper.printLine(position.incrementAndGet() + " " + x));
        }
    }

   public void deleteProduct(int pos) {
        AbstractProduct product = products.get(pos);
        if (!products.remove(product)) {
            ConsoleHelper.printLine("Bucket doesn't contain this product");
        } else {
            ConsoleHelper.printLine("Product was successfully removed");
        }
    }

    public void addProduct(AbstractProduct abstractProduct) {
        PriceCounter.recountPrice(abstractProduct);
        products.add(abstractProduct);
        ConsoleHelper.printLine("Product was successfully added");
    }

    public void clear() {
        products.clear();
        ConsoleHelper.printLine("The bucket is empty now");
    }

    public double getTotalSum() {
        return products
                .stream()
                .mapToDouble(AbstractProduct::getPrice)
                .sum();
    }

    public List<AbstractProduct> getProducts() {
        return products;
    }
}
