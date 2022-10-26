package org.example.shop;

import org.example.shop.product.*;
import org.example.shop.product.currency.Currency;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Warehouse {
    private static final Map<AbstractProduct, Integer> quantityByProduct = new HashMap<>();

    static {
        Juice juice = Juice.builder()
                .name("Orange juice")
                .price(20)
                .volume(0.9)
                .numberOfStorageDays(30)
                .build();
        juice.setPurchasingCurrency(Currency.EUR);
        ChocolateBar chocolateBar = ChocolateBar.builder()
                .name("Milka")
                .price(25)
                .isMilkChocolate(true)
                .numberOfStorageDays(120)
                .build();
        Screwdriver screwdriver = Screwdriver.builder()
                .name("Wooden screwdriver")
                .price(5)
                .material("wood")
                .build();
        Smartphone smartphone = Smartphone.builder()
                .name("Smartphone Google")
                .price(1000)
                .model("pixel 6")
                .memoryCapacity(128)
                .build();
        Milk milk = Milk.builder()
                .fatContent(3.2f)
                .price(2)
                .name("Fresh milk")
                .numberOfStorageDays(10)
                .build();
        milk.setPurchasingCurrency(Currency.USD);
        addProduct(juice);
        addProduct(chocolateBar);
        addProduct(chocolateBar);
        addProduct(screwdriver);
        addProduct(smartphone);
        addProduct(milk);
    }

    public static List<AbstractProduct> getAllProducts() {
        return quantityByProduct.keySet().stream().toList();
    }

    public static void addProduct(AbstractProduct abstractProduct) {
        ensureStorageTime(abstractProduct);
        if (quantityByProduct.containsKey(abstractProduct)) {
            quantityByProduct.put(abstractProduct, quantityByProduct.get(abstractProduct) + 1);
        } else {
            quantityByProduct.put(abstractProduct, 1);
        }
    }
    public static int getProductQuantity(AbstractProduct product) {
        return quantityByProduct.get(product);
    }

    private static void ensureStorageTime(AbstractProduct product) {
        if (isEdible(product)) {
            setExpiryDate(product);
        }
    }

    private static boolean isEdible(AbstractProduct product) {
        return product
                .getClass()
                .isAnnotationPresent(Edible.class);
    }

    private static void setExpiryDate(AbstractProduct product) {
        product.setExpirationDate(LocalDate.now()
                .plusDays(product.getNumberOfStorageDays()));
    }
}
