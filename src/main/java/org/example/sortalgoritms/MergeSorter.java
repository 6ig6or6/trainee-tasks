package org.example.sortalgoritms;

import java.lang.reflect.Array;

public class MergeSorter<T extends Comparable<T>> implements ArraySorter<T> {
    @Override
    public T[] sort(T[] arr) {
        mergeSort(arr, arr.length);
        return arr;
    }

    @SuppressWarnings("unchecked")
    private void mergeSort(T[] arr, int n) {
        if (n < 2) {
            return;
        }
        int pivot = n / 2;

        T[] left = (T[]) Array.newInstance(arr.getClass().getComponentType(), pivot);
        T[] right = (T[]) Array.newInstance(arr.getClass().getComponentType(), n - pivot);

        System.arraycopy(arr, 0, left, 0, pivot);
        if (n - pivot >= 0) {
            System.arraycopy(arr, pivot, right, 0, n - pivot);
        }
        mergeSort(left, pivot);
        mergeSort(right, n - pivot);

        merge(arr, left, right, pivot, n - pivot);
    }

    private void merge(T[] a, T[] l,
                       T[] r, int left,
                       int right) {

        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i].compareTo(r[j]) <= 0) {
                a[k++] = l[i++];
            } else {
                a[k++] = r[j++];
            }
        }
        while (i < left) {
            a[k++] = l[i++];
        }
        while (j < right) {
            a[k++] = r[j++];
        }
    }
}
