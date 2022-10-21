package org.example.maincollections.list;

import java.util.Arrays;

public class ArrayList<T> implements List<T> {
    private final static int DEFAULT_CAPACITY = 10;
    private final static int INCREASE_COEFFICIENT = 2;
    private Object[] array;
    private int size;

    public ArrayList() {
        array = new Object[DEFAULT_CAPACITY];
    }

    public ArrayList(int initialCapacity) {
        array = new Object[initialCapacity];
    }

    public int size() {
        return size;
    }

    public void add(T t) {
        if (size == array.length) {
            ensureCapacity();
        }
        array[size++] = t;
    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size "
                    + index);
        }
        return (T) array[index];
    }

    public int indexOf(T t) {
        Object[] es = array;
        if (t == null) {
            for (int i = 0; i < size; i++) {
                if (es[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (t.equals(es[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    @SuppressWarnings("unchecked")
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size "
                    + index);
        }
        T removedElement = (T) array[index];
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;

        return removedElement;
    }

    private void ensureCapacity() {
        int newIncreasedCapacity = array.length * INCREASE_COEFFICIENT;
        array = Arrays.copyOf(array, newIncreasedCapacity);
    }


}
