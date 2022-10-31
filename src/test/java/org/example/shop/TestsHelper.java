package org.example.shop;

import org.example.shop.product.ChocolateBar;
import org.example.shop.product.Juice;
import org.example.shop.product.Screwdriver;
import org.example.shop.product.Smartphone;

public class TestsHelper {
    public static Juice createJuice() {
        return Juice.builder()
                .name("Orange juice")
                .price(20)
                .volume(0.9).build();
    }

    public static ChocolateBar createChocolate() {
        return ChocolateBar.builder()
                .name("Milka")
                .price(25)
                .isMilkChocolate(true)
                .build();
    }

    public static Screwdriver createScrewdriver() {
        return Screwdriver.builder()
                .name("Wooden screwdriver")
                .price(5)
                .material("wood")
                .build();
    }

    public static Smartphone createSmartphone() {
        return Smartphone.builder()
                .name("Smartphone Google")
                .price(1000)
                .model("pixel 6")
                .memoryCapacity(128)
                .build();
    }
}
