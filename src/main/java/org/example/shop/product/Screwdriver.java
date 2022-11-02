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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Screwdriver that = (Screwdriver) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
