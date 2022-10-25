package org.example.shop.product;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Smartphone extends AbstractProduct {
    private String model;
    private int memoryCapacity;

    @Builder
    public Smartphone(String name, double price, boolean isEdible, String model, int memoryCapacity) {
        super(name, price, isEdible);
        this.model = model;
        this.memoryCapacity = memoryCapacity;
    }

    @Override
    public String toString() {
        return "Smartphone{" +
                "model='" + model + '\'' +
                ", memoryCapacity=" + memoryCapacity +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", isEdible=" + isEdible +
                '}';
    }
}
