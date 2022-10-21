package org.example.sortalgoritms;

import org.junit.jupiter.api.BeforeEach;

class SelectionSorterTest extends AbstractTest {
    @BeforeEach
    void initSorters() {
        integerArraySorter = new SelectionSorter<>();
        stringArraySorter = new SelectionSorter<>();
    }
}