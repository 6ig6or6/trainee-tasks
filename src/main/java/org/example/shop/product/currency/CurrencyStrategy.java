package org.example.shop.product.currency;

import org.example.shop.product.Product;

public interface CurrencyStrategy {
    Product recountPrice(Product product);
}
