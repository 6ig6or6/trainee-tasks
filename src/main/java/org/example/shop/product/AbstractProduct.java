package org.example.shop.product;

import lombok.*;
import org.example.shop.product.currency.Currency;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode
public abstract class AbstractProduct implements Serializable {
    @NonNull
    protected String name;
    @NonNull
    protected double price;
    @NonNull
    protected Currency purchasingCurrency;
    protected LocalDate expirationDate;
    protected int numberOfStorageDays;
}
