package org.example.maincollections;

import org.example.maincollections.map.Map;
import org.example.maincollections.map.TreeMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class TreeMapTest {
    Map<String, Integer> map;

    @BeforeEach
    void initialize() {
        map = new TreeMap<>();
    }

    @Test
    void whenGetWithContainingObjectThenSuccess() {
        map.put("Line", 2);
        map.put("Second Line", 3);
        assertEquals(2, map.get("Line"));
    }

    @Test
    void whenSizeAfterTwoUniqueInsertionsOnEmptyMapThenCorrectSize() {
        assertEquals(0, map.size());
        map.put("Line", 2);
        map.put("Line", 3);
        map.put("Second Line", 3);
        assertEquals(2, map.size());
    }

    @Test
    void whenGetAfterPutting4SameObjectThenCorrectValue() {
        map.put("Line", 1);
        map.put("Line", 2);
        map.put("Line", 3);
        map.put("Line", 5);
        assertEquals(5, map.get("Line"));
    }

    @Test
    void whenRemovingOnEmptyMapThenNull() {
        assertNull(map.remove("String"));
    }
    @Test
    void whenRemovingElementWhichMapContainsThenCorrectValue() {
        map.put("New String", 1000);
        assertEquals(1000, map.remove("New String"));
    }

    @Test
    void whenMapContainsNeededKeyThenTrue() {
        map.put("First String", 1);
        map.put("Second String", 1);
        assertTrue(map.contains("First String"));

    }
    @Test
    void whenMapDoesntContainNeededKeyThenFalse() {
        map.put("First String", 1);
        map.put("Second String", 1);
        assertFalse(map.contains("Third string"));
    }
    @Test
    void whenEmptyMapSizeIsZeroThenTrue() {
        assertTrue(map.isEmpty());
        map.put("String", 1);
        assertFalse(map.isEmpty());
    }

}