package org.example.maincollections;

public class Queue<E> {
    private int size;
    private Node<E> first, last;

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

    public E poll() throws Exception {
        if (size == 0) {
            throw new Exception("Empty queue");
        }
        E result = first.getElement();
        first = first.getNextNode();
        size--;
        if (size == 0) {
            last = null;
        }
        return result;
    }

    public E peek() throws Exception {
        if (size == 0) {
            throw new Exception("Empty queue");
        }
        return first.getElement();
    }


    public int size() {
        return size;
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
