package org.example.shop.operation;

import org.example.shop.user.Bucket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertThrows;

class OperationProcessorTest {
    private OperationProcessor operationProcessor;
    private Bucket bucket;

    @BeforeEach
    void init() {
        bucket = Mockito.mock(Bucket.class);
        operationProcessor = new OperationProcessor(null, null, null);
        operationProcessor.bucket = bucket;
    }

    @Test
    void whenShowProductsInBucketOperationThenCorrectMethodInvocation() {
        operationProcessor.chooseCommand("3");
        Mockito.verify(bucket, Mockito.times(1)).printContent();
    }

    @Test
    void whenClearBucketOperationThenCorrectMethodInvocation() {
        operationProcessor.chooseCommand("5");
        Mockito.verify(bucket, Mockito.times(1)).clear();
    }

    @Test
    void whenChoosingUnknownCommandThenThrows() {
        assertThrows(IllegalArgumentException.class, () -> operationProcessor.chooseCommand("unknown command"));
    }
}