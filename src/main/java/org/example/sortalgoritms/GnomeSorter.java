package org.example.sortalgoritms;

public class GnomeSorter<T extends Comparable<T>> implements ArraySorter<T> {
    @Override
    public T[] sort(T[] arr) {
        gnomeSort(arr, arr.length);
        return arr;
    }

    private void gnomeSort(T[] arr, int n) {
        int index = 0;
        while (index < n) {
            if (index == 0) {
                index++;
            }
            if (arr[index].compareTo(arr[index - 1]) >= 0) {
                index++;
            } else {
                T temp;
                temp = arr[index];
                arr[index] = arr[index - 1];
                arr[index - 1] = temp;
                index--;
            }
        }
    }
}
