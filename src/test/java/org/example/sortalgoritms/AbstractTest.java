package org.example.sortalgoritms;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public abstract class AbstractTest {
    static final Integer[] SORTED_INT_ARRAY = {0, 1, 2, 5, 7, 9, 14, 200, 100000};
    static final String[] SORTED_STRING_ARRAY = {"a", "abc", "b", "c", "ccc"};
    ArraySorter<Integer> integerArraySorter;
    ArraySorter<String> stringArraySorter;
    Integer[] unsortedIntArray;
    String[] unsortedStringArray;

    @BeforeEach
    void initArrays() {
        unsortedIntArray = new Integer[]{9, 7, 5, 200, 1, 0, 14, 100000, 2};
        unsortedStringArray = new String[]{"abc", "ccc", "a", "b", "c"};
    }

    @Test
    void whenSortIntArrayThenCorrectArrSequence() {
        integerArraySorter.sort(unsortedIntArray);
        assertArrayEquals(unsortedIntArray, SORTED_INT_ARRAY);
    }

    @Test
    void whenSortStringArrThenCorrectArrSequence() {
        stringArraySorter.sort(unsortedStringArray);
        assertArrayEquals(unsortedStringArray, SORTED_STRING_ARRAY);
    }

    @Test
    void whenSortSortedArrThenArrHasSameSequence() {
        Integer[] arr = SORTED_INT_ARRAY;
        arr = integerArraySorter.sort(arr);
        assertArrayEquals(arr, SORTED_INT_ARRAY);
    }
}
