package org.example.shop.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.shop.product.AbstractProduct;
import org.example.shop.util.ConsoleHelper;
import org.example.shop.util.PriceCounter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Embeddable
@NoArgsConstructor
@Getter
@Setter
public class Bucket {
    @JoinColumn(name = "user_id")
    @OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private final List<AbstractProduct> products = new ArrayList<>();

    public void printContent() {
        if (products.isEmpty()) {
            ConsoleHelper.printLine("The bucket is empty");
        } else {
            ConsoleHelper.printLine("The bucket contains:");
            AtomicInteger position = new AtomicInteger();
            products.forEach(x -> ConsoleHelper.printLine(position.incrementAndGet() + " " + x));
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
