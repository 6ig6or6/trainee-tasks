package org.example.shop.product.currency;

import org.example.shop.product.AbstractProduct;

public interface CurrencyStrategy {
    AbstractProduct recountPrice(AbstractProduct abstractProduct);
}
