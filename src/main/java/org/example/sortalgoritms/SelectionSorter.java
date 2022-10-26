package org.example.sortalgoritms;

public class SelectionSorter<T extends Comparable<T>> implements ArraySorter<T> {
    @Override
    public T[] sort(T[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j].compareTo(arr[min]) < 0) {
                    min = j;
                }
            }
            swap(arr, i, min);
        }
        return arr;
    }

    private void swap(T[] arr, int index, int min) {
        T temp = arr[index];
        arr[index] = arr[min];
        arr[min] = temp;
    }
}
