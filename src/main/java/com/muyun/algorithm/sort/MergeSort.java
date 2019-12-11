package com.muyun.algorithm.sort;

public class MergeSort {

    public static int[] sort(int[] a) {
        if (a == null || a.length < 2) {
            return a;
        }
        int[] temp = new int[a.length];
        sort(a, temp, 0, a.length - 1);
        return a;
    }

    private static void sort(int[] a, int[] temp, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = low + (high - low) / 2;
        sort(a, temp, low, mid);
        sort(a, temp, mid + 1, high);
        merge(a, temp, low, high, mid);
    }

    private static void merge(int[] a, int[] temp, int low, int high, int mid) {
        for (int i = low; i <= high; i++) {
            temp[i] = a[i];
        }
        int m = low;
        int n = mid + 1;
        for (int i = low; i <= high; i++) {
            if (m > mid) {
                a[i] = temp[n++];
            } else if (n > high) {
                a[i] = temp[m++];
            } else if (temp[m] > temp[n]) {
                a[i] = temp[n++];
            } else {
                a[i] = temp[m++];
            }
        }
    }

}
