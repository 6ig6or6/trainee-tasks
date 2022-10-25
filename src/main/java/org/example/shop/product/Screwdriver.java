package org.example.shop.product;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Screwdriver extends AbstractProduct {
    private String material;

    @Builder
    public Screwdriver(String name, double price, boolean isEdible, String material) {
        super(name, price, isEdible);
        this.material = material;
    }

    @Override
    public String toString() {
        return "Screwdriver{" +
                "material='" + material + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", isEdible=" + isEdible +
                '}';
    }
}
