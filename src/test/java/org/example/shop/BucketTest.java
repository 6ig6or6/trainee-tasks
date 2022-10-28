package org.example.shop;

import org.example.shop.user.Bucket;
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
    void whenAddingAndDeletingProductsThenCorrectBucketSize() {
        addProducts();
        bucket.deleteProduct(1);
        assertEquals(2, bucket.getProducts().size());
    }
    @Test
    void whenClearBucketThenBucketIsEmpty() {
        addProducts();
        bucket.clear();
        assertTrue(bucket.getProducts().isEmpty());
    }
    @Test
    void whenDeletingProductThenCorrectProductIsDeleted() {
        addProducts();
        bucket.deleteProduct(0);
        assertEquals(2, bucket.getProducts().size());
        assertFalse(bucket.getProducts().contains(TestsHelper.createChocolate()));
    }
    @Test
    void whenAddingProductsThenCorrectBucketTotalSumAfterRecounting() {
        addProducts();
        assertEquals(78, bucket.getTotalSum());
    }
    private void addProducts() {
        bucket.addProduct(TestsHelper.createChocolate());
        bucket.addProduct(TestsHelper.createJuice());
        bucket.addProduct(TestsHelper.createJuice());
    }
}