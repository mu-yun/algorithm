package com.muyun.algorithm.collection;

/**
 * @author muyun
 * @date 2020/11/17
 */
public class LinkedListOperation {

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode node = curr.next;
            curr.next = prev;
            prev = curr;
            curr = node;
        }
        return prev;
    }

    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        //可以假设在head前有一个虚拟节点，slow和fast都前进了一步，不然循环条件无法直接正常运行
        ListNode slowPoint = head;
        ListNode fastPoint = head.next;
        while (slowPoint != fastPoint) {
            if (fastPoint == null || fastPoint.next == null) {
                return false;
            }
            slowPoint = slowPoint.next;
            fastPoint = fastPoint.next.next;
        }
        return true;
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode sentry = new ListNode();
        ListNode curr = sentry;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                curr.next = l2;
                l2 = l2.next;
            } else {
                curr.next = l1;
                l1 = l1.next;
            }
            curr = curr.next;

        }
        curr.next = l1 == null ? l2 : l1;

        return sentry.next;
    }

    //使用快慢指针
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode sentry = new ListNode(0, head);
        ListNode fast = head;
        ListNode slow = sentry;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return sentry.next;
    }

    //使用递归
    public static ListNode removeNthFromEndByRecursion(ListNode head, int n) {
        int sort = removeNth(head, n);
        if (sort == n) {
            return head.next;
        }
        return head;
    }

    private static int removeNth(ListNode node, int n) {
        if (node.next == null) {
            return 1;
        }
        int sort = removeNth(node.next, n);
        if (sort == n) {
            node.next = node.next.next;
        }
        return ++sort;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int x) {
            val = x;
        }

        ListNode(int x, ListNode next) {
            val = x;
            next = next;
        }
    }

}
