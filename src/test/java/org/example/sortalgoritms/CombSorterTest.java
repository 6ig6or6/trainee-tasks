package org.example.sortalgoritms;

import org.junit.jupiter.api.BeforeEach;

class CombSorterTest extends AbstractTest {
    @BeforeEach
    void initSorters() {
        integerArraySorter = new CombSorter<>();
        stringArraySorter = new CombSorter<>();
    }
}