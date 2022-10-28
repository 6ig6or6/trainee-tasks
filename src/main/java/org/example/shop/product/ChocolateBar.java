package org.example.shop.product;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.shop.product.currency.Currency;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import java.util.Objects;

@Setter
@Getter
@Edible
@NoArgsConstructor
@Entity
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ChocolateBar that = (ChocolateBar) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
