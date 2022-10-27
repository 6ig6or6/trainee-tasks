package org.example.shop.product;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Juice extends AbstractProduct {
    private double volume;

    @Builder
    public Juice(String name, double price, boolean isEdible, double volume) {
        super(name, price, isEdible);
        this.volume = volume;
    }

    @Override
    public String toString() {
        return "Juice{" +
                "volume=" + volume +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", isEdible=" + isEdible +
                '}';
    }
}
