package com.muyun.algorithm.sort;

public class QuickSort {

    public static int[] sort(int[] a) {
        if (a == null || a.length < 2) {
            return a;
        }
        sort(a, 0, a.length - 1);
        return a;
    }

    private static void sort(int[] a, int low, int high) {
        if (low >= high) {
            return;
        }
        int i = low;
        int j = high;
        int x = a[i];
        while (i < j) {
            while (i < j && a[j] >= x) {
                j--;
            }
            if (i < j) {
                a[i++] = a[j];
            }
            while (i < j && a[i] < x) {
                i++;
            }
            if (i < j) {
                a[j--] = a[i];
            }
        }
        a[i] = x;
        sort(a, low, i - 1);
        sort(a, i + 1, high);
    }
}
