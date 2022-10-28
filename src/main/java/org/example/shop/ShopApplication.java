package org.example.shop;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ShopApplication implements CommandLineRunner {
    private final OnlineShop onlineShop;

    public ShopApplication(OnlineShop onlineShop) {
        this.onlineShop = onlineShop;
    }

    public static void main(String[] args) {
        SpringApplication.run(ShopApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        onlineShop.start();
    }
}
