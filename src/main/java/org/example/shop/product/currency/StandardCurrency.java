package org.example.shop.product.currency;

import org.example.shop.product.Product;

public class StandardCurrency implements CurrencyStrategy {
    private static final double COEFFICIENT = 0.2;
    @Override
    public Product recountPrice(Product product) {
        double price = product.getPrice();
        product.setPrice(price + (price * COEFFICIENT));
        return product;
    }
}
