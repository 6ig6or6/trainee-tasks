package org.example.sortalgoritms;

import org.junit.jupiter.api.BeforeEach;

class CocktailSorterTest extends AbstractTest{
    @BeforeEach
    void initSorters() {
        integerArraySorter = new CocktailSorter<>();
        stringArraySorter = new CocktailSorter<>();
    }
}