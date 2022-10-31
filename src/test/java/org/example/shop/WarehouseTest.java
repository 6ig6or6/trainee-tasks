package org.example.shop;

import org.example.shop.product.Screwdriver;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WarehouseTest {
    @Test
    void whenAppStartedWarehouseHasCorrectContent() {
        assertEquals(5, Warehouse.getAllProducts().size());
    }

    @Test
    void whenAddingProductsThenMapContainsCorrectValueForSameObjects() {
        Screwdriver screwdriver = TestsHelper.createScrewdriver();
        Warehouse.addProduct(screwdriver);
        Warehouse.addProduct(screwdriver);
        assertEquals(3, Warehouse.getProductQuantity(screwdriver));
    }
}