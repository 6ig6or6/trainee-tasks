package org.example.maincollections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {
    Queue<Object> queue;

    @BeforeEach
    void init() {
        queue = new Queue<>();
    }

    @Test
    void add() {
        queue.add(new Object());
        queue.add(new Object());
        assertEquals(2, queue.size());
    }

    @Test
    void poll() throws Exception {
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
    void peek() throws Exception {
        queue.add("new string 3");
        queue.add("new string 2");
        queue.add("new string 1");
        queue.peek();
        assertEquals(3, queue.size());
    }
    @Test
    void pollOnEmptyQueue() {
        assertThrows(Exception.class, () -> queue.poll());
        assertThrows(Exception.class, () -> queue.peek());
    }
    @Test
    void size() throws Exception {
        queue.add(1);
        queue.add(36);
        queue.poll();
        queue.peek();
        queue.add(90);
        assertEquals(2, queue.size());
    }

}