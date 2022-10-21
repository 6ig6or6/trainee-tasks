package org.example.maincollections;

import org.example.maincollections.queue.QueueImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class QueueImplTest {
    QueueImpl<Object> queue;

    @BeforeEach
    void init() {
        queue = new QueueImpl<>();
    }

    @Test
    void add() {
        queue.add(new Object());
        queue.add(new Object());
        assertEquals(2, queue.size());
    }

    @Test
    void poll() {
        queue.add(1);
        queue.add(2);
        queue.add(9002);
        queue.add(232);
        queue.add(2547);
        queue.poll();
        queue.add(9124);
        queue.poll();
        assertEquals(4, queue.size());
    }

    @Test
    void peek() {
        queue.add("new string 3");
        queue.add("new string 2");
        queue.add("new string 1");
        queue.peek();
        assertEquals(3, queue.size());
        String s = (String) queue.peek();
        assertEquals("new string 3", s);
    }

    @Test
    void pollOnEmptyQueue() {
        assertNull(queue.poll());
    }

    @Test
    void peekOnEmptyQueue() {
        assertNull(queue.peek());
    }

    @Test
    void size() {
        queue.add(1);
        queue.add(36);
        queue.poll();
        queue.peek();
        queue.add(90);
        assertEquals(2, queue.size());
    }

    @Test
    void remove() {
        queue.add(1);
        queue.add(2);
        Integer val = (Integer) queue.remove();
        assertEquals(1, val);
        assertEquals(1, queue.size());
    }

    @Test
    void element() {
        queue.add(900);
        queue.add(1000);
        Integer head = (Integer) queue.element();
        assertEquals(900, head);
        assertEquals(2, queue.size());
    }

    @Test
    void removeOnEmptyQueue() {
        assertThrows(NoSuchElementException.class, () -> queue.remove());
    }

    @Test
    void elementOmEmptyQueue() {
        assertThrows(NoSuchElementException.class, () -> queue.element());
    }

    @Test
    void toStringTest() {
        queue.add(1);
        queue.add(36);
        queue.poll();
        queue.peek();
        queue.add(90);
        assertEquals("Queue {36, 90}", queue.toString());
    }

}