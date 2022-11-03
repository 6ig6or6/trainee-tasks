package org.example.shop.product.currency;

import org.example.shop.product.Product;

public class ForeignCurrency implements CurrencyStrategy {
    private static final double COEFFICIENT = 0.25;
    @Override
    public Product recountPrice(Product product) {
        double price = product.getPrice();
        price = price / product.getPurchasingCurrency().getCourse();
        product.setPrice(price + (price * COEFFICIENT));
        product.setPurchasingCurrency(Currency.UAH);
        return product;
    }
}
