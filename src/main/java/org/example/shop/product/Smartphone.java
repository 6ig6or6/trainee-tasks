package org.example.shop.product;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.shop.product.currency.Currency;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@Entity
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Smartphone that = (Smartphone) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
