package org.example.maincollections.queue;

import java.util.NoSuchElementException;

public class QueueImpl<E> implements Queue<E> {
    private int size;
    private Node<E> first, last;

    @Override
    public void add(E e) {
        Node<E> node = new Node<>(e);
        if (size == 0) {
            first = node;
        } else {
            last.setNextNode(node);
        }
        last = node;
        size++;
    }

    @Override
    public E poll() {
        if (size == 0) {
            return null;
        }
        return removeAndReturnHead();
    }

    @Override
    public E remove() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        return removeAndReturnHead();
    }

    private E removeAndReturnHead() {
        E result = first.getElement();
        first = first.getNextNode();
        size--;
        if (size == 0) {
            last = null;
        }
        return result;
    }

    @Override
    public E element() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        return first.getElement();
    }

    @Override
    public E peek() {
        if (size == 0) {
            return null;
        }
        return first.getElement();
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        if (first == null) {
            return "Queue {}";
        }
        Node<E> currentNode = first;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Queue {");
        while (currentNode != null) {
            stringBuilder.append(currentNode.element).append(", ");
            currentNode = currentNode.nextNode;
        }
        stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    private static class Node<E> {
        private E element;
        private Node<E> nextNode;

        public Node(E element) {
            this.element = element;
        }

        public E getElement() {
            return element;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public Node<E> getNextNode() {
            return nextNode;
        }

        public void setNextNode(Node<E> nextNode) {
            this.nextNode = nextNode;
        }
    }
}
