package org.example.sortalgoritms;

import org.junit.jupiter.api.BeforeEach;


class QuickSorterTest extends AbstractTest {
    @BeforeEach
    void initSorters() {
        integerArraySorter = new QuickSorter<>();
        stringArraySorter = new QuickSorter<>();
    }

}