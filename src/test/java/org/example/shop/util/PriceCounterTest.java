package org.example.shop.util;

import org.example.shop.TestsHelper;
import org.example.shop.product.Juice;
import org.example.shop.product.Smartphone;
import org.example.shop.product.currency.Currency;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PriceCounterTest {
    @Test
    void whenProductHasStandardCurrencyThenCorrectPrice() {
        Juice juice = TestsHelper.createJuice();
        PriceCounter.recountPrice(juice);
        assertEquals(24.0, juice.getPrice());
    }
    @Test
    void whenProductHasEURCurrencyThenCorrectPrice() {
        Smartphone smartphone = TestsHelper.createSmartphone();
        smartphone.setPurchasingCurrency(Currency.EUR);
        PriceCounter.recountPrice(smartphone);
        assertEquals(45289.86, smartphone.getPrice());
    }

}