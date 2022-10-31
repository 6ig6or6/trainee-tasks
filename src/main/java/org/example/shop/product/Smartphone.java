package org.example.shop.product;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.example.shop.product.currency.Currency;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class Smartphone extends AbstractProduct {
    private String model;
    private int memoryCapacity;

    @Builder
    public Smartphone(String name, double price, String model, int memoryCapacity) {
        super(name, price, Currency.UAH);
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
                ", purchasingCurrency=" + purchasingCurrency +
                '}';
    }
}
