package org.example.sortalgoritms;

public class ShellSorter<T extends Comparable<T>> implements ArraySorter<T> {
    @Override
    public T[] sort(T[] arr) {
        shellSort(arr);
        return arr;
    }

    private void shellSort(T[] array) {
        for (int gap = array.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < array.length; i++) {
                T key = array[i];
                int j = i;
                while (j >= gap && array[j - gap].compareTo(key) > 0) {
                    array[j] = array[j - gap];
                    j -= gap;
                }
                array[j] = key;
            }
        }
    }

}
