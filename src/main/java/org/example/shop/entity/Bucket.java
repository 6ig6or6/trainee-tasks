package org.example.shop.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.shop.product.Product;
import org.example.shop.util.PriceCounter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Embeddable
@NoArgsConstructor
@Getter
@Setter
public class Bucket {
    private static final Logger logger = LoggerFactory.getLogger(Bucket.class);
    @JoinColumn(name = "user_id")
    @OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private final List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        PriceCounter.recountPrice(product);
        products.add(product);
        logger.debug("Product {} was added to user's bucket", product);
    }

    public void addAllProducts(List<Product> productsToAdd) {
        products.addAll(productsToAdd);
        logger.debug("{} products were added to user's bucket", productsToAdd.size());
    }

    public void clear() {
        products.clear();
        logger.debug("The bucket was cleared");
    }

    public double getTotalSum() {
        return products
                .stream()
                .mapToDouble(Product::getPrice)
                .sum();
    }

    public List<Product> getProducts() {
        return products;
    }
}
