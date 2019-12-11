package com.muyun.algorithm.sort;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int[] a = {1, 3, 2, 5, 4};
        int[] b = {5, 4, 3, 2, 1};
        System.out.println(Arrays.toString(sort(a)));
        System.out.println(Arrays.toString(sort(b)));
    }

    public static int[] sort(int[] a) {
        if (a == null || a.length < 2) {
            return a;
        }
        int length = a.length;
        for (int i = 0; i < length; i++) {
            //标记此次是否有数据交换，没有数据交换证明排序完成，可以提前退出
            boolean exchange = false;
            for (int j = 0; j < length - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    exchange = true;
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
            if (!exchange) {
                break;
            }
        }
        return a;
    }
}
