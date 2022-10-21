package org.example.maincollections;

import org.example.maincollections.map.TreeMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class TreeMapTest {
    TreeMap<String, Integer> map;

    @BeforeEach
    void init() {
        map = new TreeMap<>();
    }

    @Test
    void get() {
        map.put("Line", 2);
        map.put("Second Line", 3);
        assertEquals(2, map.get("Line"));
    }

    @Test
    void size() {
        assertEquals(0, map.size());
        map.put("Line", 2);
        map.put("Line", 3);
        map.put("Second Line", 3);
        assertEquals(2, map.size());
    }

    @Test
    void put() {
        map.put("Line", 1);
        map.put("Line", 2);
        map.put("Line", 3);
        map.put("Line", 4);
        assertEquals(4, map.get("Line"));
    }

    @Test
    void remove() {
        assertNull(map.remove("String"));
        map.put("New String", 1000);
        assertEquals(1000, map.remove("New String"));
    }

    @Test
    void contains() {
        map.put("First String", 1);
        map.put("Second String", 1);
        assertTrue(map.contains("First String"));
        assertFalse(map.contains("Third string"));
    }
    @Test
    void isEmpty() {
        assertTrue(map.isEmpty());
        map.put("String", 1);
        assertFalse(map.isEmpty());
    }

}