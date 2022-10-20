package src.test.java.org.example.maincollections;

import org.example.gofpatterns.src.main.java.org.example.maincollections.LinkedList;
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
    void contains() {
        list.addLast(100);
        list.addLast(200);
        list.addFirst(100000);
        list.addLast(500);
        assertTrue(list.contains(200));
        assertTrue(list.contains(100));
        assertTrue(list.contains(500));
    }

    @Test
    void getFirst() {
        list.addFirst(10);
        list.addLast(100);
        list.addFirst(1);
        assertEquals(1, list.getFirst());
    }

    @Test
    void getLast() {
        list.addLast(5);
        list.addLast(128);
        assertEquals(128, list.getLast());
    }

    @Test
    void addLast() {
        list.addLast(5);
        list.addLast(7);
        assertEquals(list.getLast(), 7);
        assertEquals(list.size(), 2);
    }

    @Test
    void addFirst() {
        list.addFirst(5);
        list.addLast(7);
        list.addFirst(1);
        assertEquals(list.getLast(), 7);
        assertEquals(list.size(), 3);
        assertEquals(1, list.getFirst());
    }

    @Test
    void removeFirstOccurrence() {
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
    void removeAll() {
        list.addLast("object 1");
        list.addFirst("object 1");
        list.addLast("object 2");
        list.addLast("object 1");
        list.removeAllOccurrences("object 1");
        assertEquals(1, list.size());
    }
    @Test
    void removeAllOnEmptyList() {
        list.removeAllOccurrences("object");
        assertEquals(0, list.size());
    }

    @Test
    void size() {
        list.addLast("object 1");
        list.addLast("object 2");
        list.addFirst("object 3");
        list.addLast("object 4");
        assertEquals(4, list.size());
        list.removeFirstOccurrence("object 1");
        assertEquals(3, list.size());
    }

    @Test
    void sizeOfEmptyList() {
        assertEquals(0, list.size());
    }

    @Test
    void listToString() {
        list.addLast(3);
        list.addLast(4);
        list.addFirst(1);
        list.addLast(5);
        assertEquals("LinkedList {1, 3, 4, 5}", list.toString());
    }
}