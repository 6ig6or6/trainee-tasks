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
public class Milk extends AbstractProduct {
    private float fatContent;

    @Builder
    public Milk(String name, double price, float fatContent, int numberOfStorageDays) {
        super(name, price, Currency.UAH);
        this.fatContent = fatContent;
        this.numberOfStorageDays = numberOfStorageDays;
    }

    @Override
    public String toString() {
        return "Milk{" +
                "fatContent=" + fatContent +
                ", expirationDate=" + expirationDate +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", purchasingCurrency=" + purchasingCurrency +
                '}';
    }
}
