package org.example.shop;

import org.example.shop.util.TestsHelper;
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
        assertEquals(3, bucket.getProductsInBucket().size());
    }
    @Test
    void whenAddingAndDeletingProductsThenCorrectBucketSize() {
        addProducts();
        bucket.deleteProduct(1);
        assertEquals(2, bucket.getProductsInBucket().size());
    }
    @Test
    void whenClearBucketThenBucketIsEmpty() {
        addProducts();
        bucket.clear();
        assertTrue(bucket.getProductsInBucket().isEmpty());
    }
    @Test
    void whenDeletingProductThenCorrectProductIsDeleted() {
        addProducts();
        bucket.deleteProduct(0);
        assertEquals(2, bucket.getProductsInBucket().size());
        assertFalse(bucket.getProductsInBucket().contains(TestsHelper.createChocolate()));
    }
    private void addProducts() {
        bucket.addProduct(TestsHelper.createChocolate());
        bucket.addProduct(TestsHelper.createJuice());
        bucket.addProduct(TestsHelper.createJuice());
    }
}