package org.example.maincollections;

import org.example.maincollections.list.LinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {
    LinkedList<Object> list;
    @BeforeEach
    void init() {
        list = new LinkedList<>();
    }
    @Test
    void whenListContainsProvidedObjectsThenTrue() {
        list.addLast(100);
        list.addLast(200);
        list.addFirst(100000);
        list.addLast(500);
        assertTrue(list.contains(200));
        assertTrue(list.contains(100));
        assertTrue(list.contains(500));
    }

    @Test
    void whenGettingFirstObjectThenCorrectValue() {
        list.addFirst(10);
        list.addLast(100);
        list.addFirst(1);
        assertEquals(1, list.getFirst());
    }

    @Test
    void whenGettingLastObjectThenCorrectValue() {
        list.addLast(5);
        list.addLast(128);
        assertEquals(128, list.getLast());
    }
    @Test
    void whenGettingObjectByIndexThenCorrectObject() {
       addStrings();
       assertEquals("object 3", list.get(2));
    }

    @Test
    void whenAdding2ObjectsToEndThenCorrectObjectInTheEnd() {
        list.addLast(5);
        list.addLast(7);
        assertEquals(list.getLast(), 7);
        assertEquals(list.size(), 2);
    }

    @Test
    void whenAdding2ObjectsToBeginningThenCorrectObjectInTheBeginning() {
        list.addFirst(5);
        list.addLast(7);
        list.addFirst(1);
        assertEquals(list.getLast(), 7);
        assertEquals(list.size(), 3);
        assertEquals(1, list.getFirst());
    }
    @Test
    void whenAddingObjectByIndexThenCorrectListSequence() {
        addStrings();
        list.add(1, "new String");
        assertEquals("new String", list.get(1));
    }

    @Test
    void whenRemovingFirstOccurrenceWhenListContainsValueThenTrue() {
        list.addLast(100);
        list.addFirst(900);
        list.addLast(898990);
        list.addLast(0);
        list.removeFirstOccurrence(900);
        list.addLast(900);
        list.removeFirstOccurrence(900);
        assertEquals(3, list.size());
        assertTrue(list.removeFirstOccurrence(100));
        assertFalse(list.removeFirstOccurrence(100000000));
    }

    @Test
    void whenRemovingAllOccurrencesThenCorrectListSequence() {
        list.addLast("object 1");
        list.addFirst("object 1");
        list.addLast("object 2");
        list.addLast("object 1");
        list.removeAllOccurrences("object 1");
        assertEquals(1, list.size());
    }
    @Test
    void whenRemovingByIndexThenCorrectListSize() {
        addStrings();
        list.remove(1);
        assertEquals(2, list.size());
    }

    @Test
    void whenRemovingAllOnEmptyListThenCorrectListSize() {
        list.removeAllOccurrences("object");
        assertEquals(0, list.size());
    }

    @Test
    void whenAddingAndRemovingObjectsThenCorrectListSize() {
        list.addLast("object 1");
        list.addLast("object 2");
        list.addFirst("object 3");
        list.addLast("object 4");
        assertEquals(4, list.size());
        list.removeFirstOccurrence("object 1");
        assertEquals(3, list.size());
    }

    @Test
    void whenSizeOnEmptyListThenCorrectSize() {
        assertEquals(0, list.size());
    }
    @Test
    void whenIndexOfProvidedObjectThenCorrectIndex() {
        addStrings();
        assertEquals(0, list.indexOf("object 1"));
        assertEquals(2, list.indexOf("object 3"));
        assertEquals(-1, list.indexOf("non-existing object"));
    }

    @Test
    void whenListToStringThenCorrectString() {
        list.addLast(3);
        list.addLast(4);
        list.addFirst(1);
        list.addLast(5);
        assertEquals("LinkedList {1, 3, 4, 5}", list.toString());
    }
    private void addStrings() {
        list.add("object 1");
        list.add("object 2");
        list.add("object 3");
    }
}