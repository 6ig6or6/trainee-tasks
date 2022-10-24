package org.example.maincollections;

import org.example.maincollections.list.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayListTest {
    ArrayList<Object> list;

    @BeforeEach
    void init() {
        list = new ArrayList<>();
    }

    @Test
    void whenSizeOnMapWhichContains2ObjectsThenCorrectSize() {
        list.add(100);
        list.add(153);
        assertEquals(2, list.size());
    }

    @Test
    void whenAddingValueByIndexThenCorrectArraySequence() {
        addIntegers(list);
        list.add(4, 100);
        assertEquals(100, list.get(4));
        assertEquals(11, list.size());
    }

    @Test
    void whenAddingObjectsThenCorrectValuesOnNeededPositions() {
        list.add(100);
        list.add(153);
        list.add(9090);
        Integer integer = (Integer) list.get(2);
        assertEquals(9090, integer);
    }

    @Test
    void whenGettingObjectsByIndexesThenCorrectValues() {
        addStrings(list);
        assertEquals(0, list.indexOf("String 1"));
        assertEquals(2, list.indexOf("String 6"));
    }

    @Test
    void whenRemovingObjectsThenCorrectArraySize() {
        addStrings(list);
        list.remove(0);
        list.remove(0);
        assertEquals(1, list.size());
        assertEquals("String 6", list.get(0));
    }

    @Test
    void whenListContainsProvidedObjectThenTrue() {
        addStrings(list);
        assertTrue(list.contains("String 5"));
        assertFalse(list.contains("wrong string"));
    }

    @Test
    void whenRemovingFirstOccurrenceListContainsSecondSameObject() {
        addStrings(list);
        list.add("String 1");
        list.removeFirstOccurrence("String 1");
        assertEquals(3, list.size());
        assertEquals("String 5", list.get(0));
    }

    private void addStrings(ArrayList<Object> list) {
        list.add("String 1");
        list.add("String 5");
        list.add("String 6");
    }

    private void addIntegers(ArrayList<Object> list) {
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);
    }

}