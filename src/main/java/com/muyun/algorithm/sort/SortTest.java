package com.muyun.algorithm.sort;

import java.util.Arrays;
import java.util.function.Function;

public class SortTest {

    public static void main(String[] args) {
        calculateRunTime(BubbleSort::sort);
        calculateRunTime(InsertionSort::sort);
        calculateRunTime(SelectionSort::sort);
        calculateRunTime(MergeSort::sort);
        calculateRunTime(QuickSort::sort);
    }

    private static void calculateRunTime(Function<int[], int[]> sortFunction) {
        System.out.println(sortFunction);

        int[] a = {1, 3, 2, 5, 4};
        int[] b = {5, 4, 3, 2, 1};
        int[] c = {1, 2, 3, 4, 5};
        int[] d = {1, 3, 4, 2, 5, 4, 0, 2, 6};

        calculateRunTime("One:", a, sortFunction);
        calculateRunTime("Two:", b, sortFunction);
        calculateRunTime("Three:", c, sortFunction);
        calculateRunTime("Four:", d, sortFunction);
    }

    private static void calculateRunTime(String desc, int[] a, Function<int[], int[]> sortFunction) {
        long startTime = System.nanoTime();
        System.out.println(Arrays.toString(sortFunction.apply(a)));
        System.out.println(desc + (System.nanoTime() - startTime));
    }
}
