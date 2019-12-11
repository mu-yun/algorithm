package com.muyun.algorithm.sort;

public class InsertionSort {

    public static int[] sort(int[] a) {
        if (a == null || a.length < 2) {
            return a;
        }
        int length = a.length;
        for (int i = 1; i < length; i++) {
            int value = a[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (a[j] > value) {
                    a[j + 1] = a[j];
                } else {
                    break;
                }
            }
            a[j + 1] = value;
        }
        return a;
    }
}
