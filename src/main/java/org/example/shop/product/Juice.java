package org.example.shop.product;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.example.shop.product.currency.Currency;

@Setter
@Getter
@EqualsAndHashCode(callSuper = true)
@Edible
public class Juice extends AbstractProduct {
    private double volume;

    @Builder
    public Juice(String name, double price, double volume, int numberOfStorageDays) {
        super(name, price, Currency.UAH);
        this.volume = volume;
        this.numberOfStorageDays = numberOfStorageDays;
    }

    @Override
    public String toString() {
        return "Juice{" +
                "volume=" + volume +
                ", expirationDate=" + expirationDate +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", purchasingCurrency=" + purchasingCurrency +
                '}';
    }
}
