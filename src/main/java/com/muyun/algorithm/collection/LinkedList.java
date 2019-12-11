package com.muyun.algorithm.collection;

/**
 * @author dali.niu
 */
public class LinkedList {

    public static void main(String[] args) {
        {
            Node<String> third = new Node<>("3", null);
            Node<String> second = new Node<>("2", third);
            Node<String> first = new Node<>("1", second);

            print(first);
            print(reverse(first));
        }
        System.out.println("-----------------------------");
        {
            Node<String> fourth = new Node<>("4", null);
            Node<String> third = new Node<>("3", fourth);
            Node<String> second = new Node<>("2", third);
            Node<String> first = new Node<>("1", second);
            fourth.next = first;
            System.out.println(checkLoop(first));
        }
        System.out.println("-----------------------------");
        {
            IntNode one = new IntNode(1, null);
            IntNode two = new IntNode(2, one);
            IntNode three = new IntNode(3, two);
            IntNode four = new IntNode(4, three);

            IntNode five = new IntNode(2, null);
            IntNode six = new IntNode(3, five);
            IntNode seven = new IntNode(4, six);

            print(merge(four, seven));
        }
        System.out.println("-----------------------------");
        {
            Node<String> fourth = new Node<>("4", null);
            Node<String> third = new Node<>("3", fourth);
            Node<String> second = new Node<>("2", third);
            Node<String> first = new Node<>("1", second);

            deleteN(first, 2);
            print(first);
        }
        System.out.println("-----------------------------");
        {
            Node<String> fourth = new Node<>("4", null);
            Node<String> third = new Node<>("3", fourth);
            Node<String> second = new Node<>("2", third);
            Node<String> first = new Node<>("1", second);

            System.out.println(getMiddle(fourth).value);
            System.out.println(getMiddle(third).value);
            System.out.println(getMiddle(second).value);
            System.out.println(getMiddle(first).value);
        }
    }

    private static <V> void print(Node<V> node) {
        while (node != null) {
            System.out.println(node.value);
            node = node.next;
        }
    }

    private static void print(IntNode node) {
        while (node != null) {
            System.out.println(node.value);
            node = node.next;
        }
    }

    public static <V> Node<V> getMiddle(Node<V> node) {
        if (node == null || node.next == null) {
            return node;
        }
        Node<V> oneStep = node;
        Node<V> twoStep = node;

        while (twoStep != null && twoStep.next != null) {
            twoStep = twoStep.next.next;
            oneStep = oneStep.next;
        }
        return oneStep;
    }

    /**
     * delete n to last
     *
     * @param node
     * @param n
     * @param <V>
     */
    public static <V> void deleteN(Node<V> node, int n) {
        if (node == null) {
            return;
        }
        Node<V> first = node;
        Node<V> nodeN = node;

        while (n > 0) {
            if (nodeN == null) {
                throw new RuntimeException("list size must greater than n");
            }
            nodeN = nodeN.next;
            n--;
        }

        Node pre = node;
        while (nodeN != null) {
            nodeN = nodeN.next;
            pre = first;
            first = first.next;
        }
        pre.next = first.next;
    }

    /**
     * merge two sorted linked list
     *
     * @param nodeOne
     * @param nodeTwo
     * @return
     */
    public static IntNode merge(IntNode nodeOne, IntNode nodeTwo) {
        if (nodeOne == null) {
            return nodeTwo;
        }
        if (nodeTwo == null) {
            return nodeOne;
        }

        IntNode node = new IntNode(0, null);
        IntNode guard = node;
        while (nodeOne != null && nodeTwo != null) {
            if (nodeOne.value >= nodeTwo.value) {
                node.next = nodeOne;
                nodeOne = nodeOne.next;
            } else {
                node.next = nodeTwo;
                nodeTwo = nodeTwo.next;
            }
            node = node.next;
        }

        if (nodeOne == null) {
            node.next = nodeTwo;
        }
        if (nodeTwo == null) {
            node.next = nodeOne;
        }
        return guard.next;
    }


    /**
     * check linked list loop
     *
     * @param node
     * @param <V>
     * @return
     */
    public static <V> boolean checkLoop(Node<V> node) {
        if (node == null || node.next == null) {
            return false;
        }
        Node<V> oneStep = node;
        Node<V> twoStep = node;
        while (twoStep != null && twoStep.next != null) {
            twoStep = twoStep.next.next;
            oneStep = oneStep.next;
            if (twoStep == oneStep) {
                return true;
            }
        }
        return false;
    }

    /**
     * reverse single linked list
     *
     * @param node
     * @param <V>
     * @return
     */
    public static <V> Node<V> reverse(Node<V> node) {
        if (node == null || node.next == null) {
            return node;
        }

        Node<V> pre = node;
        Node<V> current = node.next;
        Node<V> next = null;
        node.next = null;
        while (current != null) {
            next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }
        return pre;
    }


    private static class IntNode {
        int value;
        IntNode next;

        IntNode(int value, IntNode next) {
            this.value = value;
            this.next = next;
        }
    }

    private static class Node<V> {
        V value;
        Node<V> next;

        Node(V value, Node<V> next) {
            this.value = value;
            this.next = next;
        }
    }

}
