package org.example.maincollections.list;

import java.util.NoSuchElementException;

public class LinkedList<E> implements List<E> {
    private int size;
    private Node<E> firstNode, lastNode;

    @Override
    public boolean contains(E e) {
        Node<E> currentNode = firstNode;
        while (currentNode != null) {
            if (currentNode.element.equals(e)) {
                return true;
            } else {
                currentNode = currentNode.next;
            }
        }
        return false;
    }

    @Override
    public E get(int index) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        return iterateToPosAndGetNode(index).element;
    }

    @Override
    public int indexOf(E e) {
        if (firstNode == null) {
            throw new NoSuchElementException();
        }
        int pos = 0;
        Node<E> currentNode = firstNode;
        while (currentNode != null) {
            if (currentNode.element.equals(e)) {
                return pos;
            } else {
                currentNode = currentNode.next;
                pos++;
            }
        }
        return -1;
    }

    @Override
    public E remove(int index) {
        Node<E> currentNode = iterateToPosAndGetNode(index);
        relinkNodes(currentNode);
        return currentNode.element;
    }

    private void relinkNodes(Node<E> currentNode) {
        final Node<E> next = currentNode.next;
        final Node<E> prev = currentNode.previous;

        if (prev == null) {
            firstNode = next;
        } else {
            prev.next = next;
            currentNode.previous = null;
        }

        if (next == null) {
            lastNode = prev;
        } else {
            next.previous = prev;
            currentNode.next = null;
        }
        currentNode.element = null;
        size--;
    }

    @Override
    public boolean removeFirstOccurrence(E e) {
        Node<E> currentNode = firstNode;
        while (currentNode != null) {
            if (currentNode.element.equals(e)) {
                relinkNodes(currentNode);
                return true;
            } else {
                currentNode = currentNode.next;
            }
        }
        return false;
    }

    public void removeAllOccurrences(E e) {
        boolean allNonDeleted = true;
        while (allNonDeleted) {
            allNonDeleted = removeFirstOccurrence(e);
        }
    }

    public E getFirst() {
        if (firstNode == null) {
            throw new NoSuchElementException();
        }
        return firstNode.element;
    }

    public E getLast() {
        if (firstNode == null) {
            throw new NoSuchElementException();
        }
        return lastNode.element;
    }

    public void addFirst(E e) {
        if (size == 0) {
            firstNode = new Node<>(e, null, null);
            lastNode = firstNode;
            size = 1;
        } else {
            Node<E> node = new Node<>(e, firstNode, null);
            firstNode.previous = node;
            firstNode = node;
            size++;
        }
    }

    public void addLast(E e) {
        if (size == 0) {
            firstNode = new Node<>(e, null, null);
            lastNode = firstNode;
            size = 1;
        } else {
            Node<E> node = new Node<>(e, null, lastNode);
            lastNode.next = node;
            lastNode = node;
            size++;
        }
    }

    public int size() {
        return size;
    }

    @Override
    public void add(E e) {
        addLast(e);
    }

    @Override
    public void add(int index, E e) {
        Node<E> newPreviousNode = iterateToPosAndGetNode(index - 1);
        Node<E> newNextNode = newPreviousNode.next;
        Node<E> nodeToAdd = new Node<>(e, newNextNode, newPreviousNode);
        newPreviousNode.next = nodeToAdd;
        newNextNode.previous = nodeToAdd;
    }

    @Override
    public String toString() {
        if (firstNode == null) {
            return "LinkedList{}";
        }
        Node<E> currentNode = firstNode;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("LinkedList {");
        while (currentNode != null) {
            stringBuilder.append(currentNode.element).append(", ");
            currentNode = currentNode.next;
        }
        stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    private Node<E> iterateToPosAndGetNode(int pos) {
        Node<E> currentNode = firstNode;
        for (int i = 0; i < pos; i++) {
            currentNode = currentNode.next;
        }
        return currentNode;
    }

    private static class Node<E> {
        E element;
        Node<E> next;
        Node<E> previous;

        public Node(E element, Node<E> next, Node<E> previous) {
            this.element = element;
            this.next = next;
            this.previous = previous;
        }
    }

}
