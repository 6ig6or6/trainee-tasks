package org.example.shop.dto;

import lombok.Getter;
import lombok.Setter;
import org.example.shop.product.currency.Currency;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Setter
@Getter
public class ProductDTO {
    @NotBlank(message = "Product name cannot be blank")
    private String name;
    private String description;
    @DecimalMin("0.1")
    private Double price;
    private Currency purchasingCurrency;
    private LocalDate expirationDate;
    private Integer numberOfStorageDays;
    private Boolean isOrdered;
}
