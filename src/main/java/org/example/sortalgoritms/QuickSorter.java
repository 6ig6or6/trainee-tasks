package org.example.sortalgoritms;

public class QuickSorter<T extends Comparable<T>> implements ArraySorter<T> {
    @Override
    public T[] sort(T[] arr) {
        quickSort(arr, 0, arr.length - 1);
        return arr;
    }

    public void quickSort(T[] arr, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            quickSort(arr, begin, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, end);
        }
    }

    private int partition(T[] arr, int begin, int end) {
        T pivot = arr[end];
        int i = (begin - 1);

        for (int j = begin; j < end; j++) {
            if (arr[j].compareTo(pivot) <= 0) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, end);
        return i + 1;
    }

    private void swap(T[] arr, int first, int second) {
        T swapTemp = arr[first];
        arr[first] = arr[second];
        arr[second] = swapTemp;
    }
}
