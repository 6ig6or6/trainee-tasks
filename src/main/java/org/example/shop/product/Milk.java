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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Milk milk = (Milk) o;
        return getId() != null && Objects.equals(getId(), milk.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
