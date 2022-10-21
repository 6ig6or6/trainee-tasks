package org.example.maincollections.list;


import java.util.Arrays;
import java.util.stream.Stream;

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

    @Override
    public void add(int index, T t) {
        checkRangeForAdd(index);
        Object[] leftArrayPart = Arrays.copyOfRange(array, 0, index);
        Object[] rightArrayPart = Arrays.copyOfRange(array, index, array.length);
        Object[] newObjectArray = {t};
        array = concatArrays(leftArrayPart, newObjectArray, rightArrayPart);
        size++;
    }

    private void checkRangeForAdd(int pos) {
        if (pos > size || pos < 0) {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public boolean contains(T t) {
        long count = Arrays.stream(array)
                .filter(t::equals)
                .count();
        return count > 0;
    }

    @Override
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

    @Override
    public boolean removeFirstOccurrence(T t) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(t)) {
                Object[] leftArrayPart = Arrays.copyOfRange(array, 0, i);
                Object[] rightArrayPart = Arrays.copyOfRange(array, i + 1, array.length);
                array = concatWithArrayCopy(leftArrayPart, rightArrayPart);
                size--;
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        if (size == 0) {
            return "ArrayList{}";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ArrayList {");
        for (int i = 0; i < size; i++) {
            stringBuilder.append(array[i]).append(", ");
        }
        stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    private Object[] concatWithArrayCopy(Object[] array1, Object[] array2) {
        int currentCapacity = array.length;
        Object[] result = Arrays.copyOf(array1, currentCapacity);
        System.arraycopy(array2, 0, result, array1.length, array2.length);
        return result;
    }

    private Object[] concatArrays(Object[]... arrays) {
        int currentCapacity = array.length + 1;
        return Stream.of(arrays)
                .flatMap(Stream::of)
                .toArray(x -> new Object[currentCapacity]);
    }

    private void ensureCapacity() {
        int newIncreasedCapacity = array.length * INCREASE_COEFFICIENT;
        array = Arrays.copyOf(array, newIncreasedCapacity);
    }


}
