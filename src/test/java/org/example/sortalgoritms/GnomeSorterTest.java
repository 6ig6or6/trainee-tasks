package org.example.sortalgoritms;

import org.junit.jupiter.api.BeforeEach;

class GnomeSorterTest extends AbstractTest {
    @BeforeEach
    void initSorters() {
        integerArraySorter = new GnomeSorter<>();
        stringArraySorter = new GnomeSorter<>();
    }
}