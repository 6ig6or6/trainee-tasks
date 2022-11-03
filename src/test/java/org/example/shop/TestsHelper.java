package org.example.shop;

import org.example.shop.product.Product;
import org.example.shop.product.currency.Currency;

public class TestsHelper {
    public static Product createJuice() {
        return Product.builder()
                .name("Orange juice")
                .price(20)
                .description("Super cheap")
                .purchasingCurrency(Currency.EUR)
                .numberOfStorageDays(30)
                .build();
    }

    public static Product createChocolate() {
        return Product.builder()
                .name("Milka")
                .price(25)
                .description("Milk chocolate")
                .purchasingCurrency(Currency.USD)
                .numberOfStorageDays(120)
                .build();
    }

    public static Product createScrewdriver() {
        return Product.builder()
                .name("Wooden screwdriver")
                .price(5)
                .description("With furniture")
                .purchasingCurrency(Currency.UAH)
                .build();
    }

    public static Product createSmartphone() {
        return Product.builder()
                .name("Smartphone Google")
                .price(1000)
                .description("pixel 6")
                .purchasingCurrency(Currency.PLN)
                .build();
    }
}
