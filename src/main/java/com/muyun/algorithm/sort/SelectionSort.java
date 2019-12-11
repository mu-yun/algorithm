package com.muyun.algorithm.sort;

public class SelectionSort {

    public static int[] sort(int[] a) {
        if (a == null || a.length < 2) {
            return a;
        }
        int length = a.length;
        for (int i = 0; i < length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < length; j++) {
                if (a[j] < a[minIndex]) {
                    minIndex = j;
                }
            }

            int temp = a[i];
            a[i] = a[minIndex];
            a[minIndex] = temp;
        }
        return a;
    }
}
