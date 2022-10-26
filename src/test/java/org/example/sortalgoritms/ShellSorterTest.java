package org.example.sortalgoritms;

import org.junit.jupiter.api.BeforeEach;

class ShellSorterTest extends AbstractTest {
    @BeforeEach
    void initSorters() {
        integerArraySorter = new ShellSorter<>();
        stringArraySorter = new ShellSorter<>();
    }
}