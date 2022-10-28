package org.example.shop.product;

import lombok.*;
import org.example.shop.product.currency.Currency;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "products")
public abstract class AbstractProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    protected String name;
    @NonNull
    protected double price;
    @NonNull
    @Enumerated(EnumType.STRING)
    protected Currency purchasingCurrency;
    protected LocalDate expirationDate;
    protected int numberOfStorageDays;
    protected boolean isOrdered;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        AbstractProduct product = (AbstractProduct) o;
        return id != null && Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
