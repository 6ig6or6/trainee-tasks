package org.example.shop.util;

import org.example.shop.product.Product;
import org.example.shop.product.currency.Currency;
import org.example.shop.product.currency.CurrencyStrategy;
import org.example.shop.product.currency.ForeignCurrency;
import org.example.shop.product.currency.StandardCurrency;

public class PriceCounter {
    public static void recountPrice(Product product) {
        CurrencyStrategy currencyStrategy = Currency.UAH != product.getPurchasingCurrency() ?
                new ForeignCurrency() : new StandardCurrency();
        product = currencyStrategy.recountPrice(product);
        product.setPrice(round(product.getPrice()));
    }

    private static double round(double price) {
        return (double) Math.round(price * 100) / 100;
    }
}
