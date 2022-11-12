package org.example.shop;


import org.example.shop.entity.Bucket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class BucketTest {
    Bucket bucket;

    @BeforeEach
    void init() {
        bucket = new Bucket();
    }

    @Test
    void whenAddingProductsThenCorrectBucketSize() {
        addProducts();
        assertEquals(3, bucket.getProducts().size());
    }

    @Test
    void whenClearBucketThenBucketIsEmpty() {
        addProducts();
        bucket.clear();
        assertTrue(bucket.getProducts().isEmpty());
    }

    @Test
    void whenAddingProductsThenCorrectBucketTotalSumAfterRecounting() {
        addProducts();
        assertEquals(10679.32, bucket.getTotalSum());
    }

    private void addProducts() {
        bucket.addProduct(TestsHelper.createChocolate());
        bucket.addProduct(TestsHelper.createScrewdriver());
        bucket.addProduct(TestsHelper.createSmartphone());

    }
}