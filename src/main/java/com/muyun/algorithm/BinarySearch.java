package com.muyun.algorithm;

public class BinarySearch {

    public static void main(String[] args) {
        int[] a = {1, 3, 4, 5, 6, 6, 7, 8, 9};
        System.out.println(search(a, 5));
        System.out.println(search(a, 6));
        System.out.println(search(a, 1));
        System.out.println(search(a, 9));
        System.out.println(search(a, 2));
    }

    public static int search(int[] a, int target) {
        if (a == null) {
            return -1;
        }
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            //(high - low) >> 1 必须加括号
            int mid = low + ((high - low) >> 1);
            if (a[mid] == target) {
                return mid;
            } else if (a[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
