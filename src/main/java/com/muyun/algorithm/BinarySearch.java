package com.muyun.algorithm;

public class BinarySearch {

    public static void main(String[] args) {
        int[] a = {1, 3, 4, 5, 6, 6, 7, 8, 9};
        System.out.println(search(a, 5));
        System.out.println(search(a, 6));
        System.out.println(search(a, 1));
        System.out.println(search(a, 9));
        System.out.println(search(a, 2));
        System.out.println(searchFirst(a, 6));
        System.out.println(searchLast(a, 6));
        System.out.println(searchFirstGe(a, 6));
        System.out.println(searchLastLe(a, 6));
        System.out.println(searchFirstGe(a, 2));
        System.out.println(searchLastLe(a, 2));

        int[] b = {6, 6, 6, 6, 6, 6, 6, 6};
        System.out.println(searchFirst(b, 6));
        System.out.println(searchLast(b, 6));

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

    public static int searchFirst(int[] a, int target) {
        if (a == null) {
            return -1;
        }
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] > target) {
                high = mid - 1;
            } else if (a[mid] < target) {
                low = mid + 1;
            } else {
                if (mid == 0 || a[mid - 1] != target) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    public static int searchLast(int[] a, int target) {
        if (a == null) {
            return -1;
        }
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] > target) {
                high = mid - 1;
            } else if (a[mid] < target) {
                low = mid + 1;
            } else {
                if (mid == a.length - 1 || a[mid + 1] != target) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }

    public static int searchFirstGe(int[] a, int target) {
        if (a == null) {
            return -1;
        }
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] >= target) {
                if (mid == 0 || a[mid - 1] < target) {
                    return mid;
                }
                high = mid - 1;
            } else if (a[mid] < target) {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static int searchLastLe(int[] a, int target) {
        if (a == null) {
            return -1;
        }
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] > target) {
                high = mid - 1;
            } else if (a[mid] <= target) {
                if (mid == a.length - 1 || a[mid + 1] > target) {
                    return mid;
                }
                low = mid + 1;
            }
        }
        return -1;
    }

    public static int searchInRotatedSortedArray(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            // notice: nums[mid] == nums[low]时，前半部分是有序的
            if (nums[mid] >= nums[low]) {
                if (target >= nums[low] && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}
