package org.example.shop.util;

import org.example.shop.product.AbstractProduct;
import org.example.shop.product.currency.Currency;
import org.example.shop.product.currency.CurrencyStrategy;
import org.example.shop.product.currency.ForeignCurrency;
import org.example.shop.product.currency.StandardCurrency;

public class PriceCounter {
    public static void recountPrice(AbstractProduct abstractProduct) {
        CurrencyStrategy currencyStrategy;
        if (abstractProduct.getPurchasingCurrency() != Currency.UAH) {
            currencyStrategy = new ForeignCurrency();
        } else {
            currencyStrategy = new StandardCurrency();
        }
        abstractProduct = currencyStrategy.recountPrice(abstractProduct);
        abstractProduct.setPrice(round(abstractProduct.getPrice()));
    }

    private static double round(double price) {
        return (double) Math.round(price * 100) / 100;
    }
}
