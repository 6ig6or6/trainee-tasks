package org.example.shop.util;


import org.example.shop.dto.ProductDTO;
import org.example.shop.product.Product;


public class Mapper {
    public static Product mapProductFromDTO(ProductDTO productDTO) {
        return Product.builder()
                .name(productDTO.getName())
                .description(productDTO.getDescription())
                .price(productDTO.getPrice())
                .purchasingCurrency(productDTO.getPurchasingCurrency())
                .numberOfStorageDays(productDTO.getNumberOfStorageDays())
                .build();
    }
}
