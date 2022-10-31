package org.example.shop.product.currency;

import org.example.shop.product.AbstractProduct;

public class StandardCurrency implements CurrencyStrategy {
    private static final double COEFFICIENT = 0.2;
    @Override
    public AbstractProduct recountPrice(AbstractProduct abstractProduct) {
        double price = abstractProduct.getPrice();
        abstractProduct.setPrice(price + (price * COEFFICIENT));
        return abstractProduct;
    }
}
