package org.example.shop.product.currency;

import org.example.shop.product.AbstractProduct;

public class ForeignCurrency implements CurrencyStrategy {
    private static final double COEFFICIENT = 0.25;
    @Override
    public AbstractProduct recountPrice(AbstractProduct abstractProduct) {
        double price = abstractProduct.getPrice();
        price = price / abstractProduct.getPurchasingCurrency().getCourse();
        abstractProduct.setPrice(price + (price * COEFFICIENT));
        abstractProduct.setPurchasingCurrency(Currency.UAH);
        return abstractProduct;
    }
}
