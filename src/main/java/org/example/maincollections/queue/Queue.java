package org.example.maincollections.queue;

public interface Queue<E> {
    void add(E e);

    /**
     * The main difference between poll() and remove() is:
     * if the queue is empty, remove throws NoSuchElementException while pool returns null.
     */

    E poll();

    E remove();

    /**
     * The main difference between element() and peek() is:
     * if the queue is empty, element throws NoSuchElementException while peek returns null.
     */
    E element();

    E peek();
}
