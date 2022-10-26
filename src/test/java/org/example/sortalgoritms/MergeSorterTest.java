package org.example.sortalgoritms;

import org.junit.jupiter.api.BeforeEach;

class MergeSorterTest extends AbstractTest {
    @BeforeEach
    void initSorters() {
        integerArraySorter = new MergeSorter<>();
        stringArraySorter = new MergeSorter<>();
    }
}