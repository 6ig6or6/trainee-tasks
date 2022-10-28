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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Juice juice = (Juice) o;
        return getId() != null && Objects.equals(getId(), juice.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
