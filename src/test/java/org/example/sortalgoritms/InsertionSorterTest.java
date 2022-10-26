package org.example.sortalgoritms;

import org.junit.jupiter.api.BeforeEach;

class InsertionSorterTest extends AbstractTest {
    @BeforeEach
    void initSorters() {
        integerArraySorter = new InsertionSorter<>();
        stringArraySorter = new InsertionSorter<>();
    }
}