package org.example.sortalgoritms;

public class CocktailSorter<T extends Comparable<T>> implements ArraySorter<T> {
    @Override
    public T[] sort(T[] arr) {
        cocktailSort(arr);
        return arr;
    }

    private void cocktailSort(T[] arr) {
        boolean swapped;
        do {
            swapped = false;
            for (int i = 0; i <= arr.length - 2; i++) {
                if (arr[i].compareTo(arr[i + 1]) > 0) {
                    T temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
            swapped = false;
            for (int i = arr.length - 2; i >= 0; i--) {
                if (arr[i].compareTo(arr[i + 1]) > 0) {
                    T temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    swapped = true;
                }
            }
        } while (swapped);
    }
}
