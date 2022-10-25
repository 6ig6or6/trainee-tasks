package org.example.shop.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public abstract class AbstractProduct {
    protected String name;
    protected double price;
    protected boolean isEdible;

}
