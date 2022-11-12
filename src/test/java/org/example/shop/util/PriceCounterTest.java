package org.example.shop.util;

import org.example.shop.TestsHelper;
import org.example.shop.product.Product;
import org.example.shop.product.currency.Currency;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PriceCounterTest {
    @Test
    void whenProductHasStandardCurrencyThenCorrectPrice() {
        Product juice = TestsHelper.createJuice();
        PriceCounter.recountPrice(juice);
        assertEquals(905.8, juice.getPrice());
    }

    @Test
    void whenProductHasEURCurrencyThenCorrectPrice() {
        Product smartphone = TestsHelper.createSmartphone();
        smartphone.setPurchasingCurrency(Currency.EUR);
        PriceCounter.recountPrice(smartphone);
        assertEquals(45289.86, smartphone.getPrice());
    }

}