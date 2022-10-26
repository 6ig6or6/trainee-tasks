package org.example.sortalgoritms;

import org.junit.jupiter.api.BeforeEach;

class BubbleSorterTest extends AbstractTest {
    @BeforeEach
    void initSorters() {
        integerArraySorter = new BubbleSorter<>();
        stringArraySorter = new BubbleSorter<>();
    }
}