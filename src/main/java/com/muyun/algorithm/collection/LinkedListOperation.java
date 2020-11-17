package com.muyun.algorithm.collection;

/**
 * @author muyun
 * @date 2020/11/17
 */
public class LinkedListOperation {

    public ListNode reverseList(ListNode head) {
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

    public boolean hasCycle(ListNode head) {
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

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
