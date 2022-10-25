package org.example.shop;

import org.example.shop.product.*;

import java.util.ArrayList;
import java.util.List;

public class Storage {
    private static List<AbstractProduct> allProducts = new ArrayList<>();
    static {
        Juice juice = Juice.builder()
                .name("Orange juice")
                .isEdible(true)
                .price(20)
                .volume(0.9).build();
        ChocolateBar chocolateBar = ChocolateBar.builder()
                .name("Milka")
                .isEdible(true)
                .price(25)
                .isMilkChocolate(true)
                .build();
        Screwdriver screwdriver = Screwdriver.builder()
                .name("Wooden screwdriver")
                .isEdible(false)
                .price(5)
                .material("wood")
                .build();
        Smartphone smartphone = Smartphone.builder()
                .name("Smartphone Google")
                .isEdible(false)
                .price(1000)
                .model("pixel 6")
                .memoryCapacity(128)
                .build();
        allProducts.add(juice);
        allProducts.add(chocolateBar);
        allProducts.add(screwdriver);
        allProducts.add(smartphone);
    }

    public static List<AbstractProduct> getAllProducts() {
        return allProducts;
    }
}
