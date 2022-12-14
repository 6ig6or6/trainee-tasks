package org.example.maincollections;

import org.example.maincollections.set.Set;
import org.example.maincollections.set.TreeSet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TreeSetTest {
    Set<Integer> set;

    @BeforeEach
    void init() {
        set = new TreeSet<>();
    }

    @Test
    void whenAddingFewSameObjectsThenCorrectSize() {
        set.add(100);
        set.add(200);
        set.add(100);
        assertEquals(2, set.size());
    }

    @Test
    void whenEmptySetSizeIsZeroThenTrue() {
        assertTrue(set.isEmpty());
        set.add(10);
        assertFalse(set.isEmpty());
    }

    @Test
    void whenSetContainsNeededValueThenTrue() {
        set.add(10000);
        set.add(0);
        assertTrue(set.contains(10000));
        assertFalse(set.contains(2));
    }

    @Test
    void whenValueWasRemovedThenFalseAfterContains() {
        set.add(1);
        set.add(20);
        set.add(900);
        set.remove(1);
        assertFalse(set.contains(1));
    }

}