package org.example.shop.operation;

import org.example.shop.Bucket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


class OperationProcessorTest {
    private OperationProcessor operationProcessor;
    private Bucket bucket;

    @BeforeEach
    void init() {
        bucket = Mockito.mock(Bucket.class);
        operationProcessor = new OperationProcessor(bucket);
    }

    @Test
    void whenShowProductsInBucketOperationThenCorrectMethodInvocation() {
        operationProcessor.chooseOperation("3");
        Mockito.verify(bucket, Mockito.times(1)).printBucketContent();
    }

    @Test
    void whenClearBucketOperationThenCorrectMethodInvocation() {
        operationProcessor.chooseOperation("5");
        Mockito.verify(bucket, Mockito.times(1)).clear();
    }
}