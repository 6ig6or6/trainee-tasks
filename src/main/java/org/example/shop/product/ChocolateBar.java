package org.example.shop.product;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ChocolateBar extends AbstractProduct {
    private boolean isMilkChocolate;
    @Builder
    public ChocolateBar(String name, double price, boolean isEdible, boolean isMilkChocolate) {
        super(name, price, isEdible);
        this.isMilkChocolate = isMilkChocolate;
    }

    @Override
    public String toString() {
        return "ChocolateBar{" +
                "isMilkChocolate=" + isMilkChocolate +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", isEdible=" + isEdible +
                '}';
    }
}
