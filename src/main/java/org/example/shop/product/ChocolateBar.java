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
public class ChocolateBar extends AbstractProduct {
    private boolean isMilkChocolate;

    @Builder
    public ChocolateBar(String name, double price, boolean isMilkChocolate,
                        int numberOfStorageDays) {
        super(name, price, Currency.UAH);
        this.isMilkChocolate = isMilkChocolate;
        this.numberOfStorageDays = numberOfStorageDays;
    }

    @Override
    public String toString() {
        return "ChocolateBar{" +
                "isMilkChocolate=" + isMilkChocolate +
                ", expirationDate=" + expirationDate +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", purchasingCurrency=" + purchasingCurrency +
                '}';
    }
}
