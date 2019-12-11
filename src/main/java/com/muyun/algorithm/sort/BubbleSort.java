package com.muyun.algorithm.sort;

public class BubbleSort {

    public static int[] sort(int[] a) {
        if (a == null || a.length < 2) {
            return a;
        }
        int length = a.length;
        for (int i = 0; i < length - 1; i++) {
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
