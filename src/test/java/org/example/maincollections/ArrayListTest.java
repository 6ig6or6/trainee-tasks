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
    void add() {
        list.add(100);
        list.add(153);
        assertEquals(2, list.size());
    }
    @Test
    void get() {
        list.add(100);
        list.add(153);
        list.add(9090);
        Integer integer = (Integer) list.get(2);
        assertEquals(9090, integer);
    }
    @Test
    void indexOf() {
        addStrings(list);
        assertEquals(0, list.indexOf("String 1"));
        assertEquals(2, list.indexOf("String 6"));
    }
    @Test
    void remove() {
        addStrings(list);
        list.remove(0);
        list.remove(0);
        assertEquals(1, list.size());
        assertEquals("String 6", list.get(0));
    }
    private void addStrings(ArrayList<Object> list) {
        list.add("String 1");
        list.add("String 5");
        list.add("String 6");
    }

}