package org.example.shop.product;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.example.shop.product.currency.Currency;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class Screwdriver extends AbstractProduct {
    private String material;

    @Builder
    public Screwdriver(String name, double price, String material) {
        super(name, price, Currency.UAH);
        this.material = material;
    }

    @Override
    public String toString() {
        return "Screwdriver{" +
                "material='" + material + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", purchasingCurrency=" + purchasingCurrency +
                '}';
    }
}
