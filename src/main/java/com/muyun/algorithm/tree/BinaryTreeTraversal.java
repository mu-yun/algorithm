package com.muyun.algorithm.tree;

public class BinaryTreeTraversal {

    public static void main(String[] args) {
        //TODO
    }

    public static <E> void preOrderTraversal(Node<E> node) {
        if (node == null) {
            return;
        }
        System.out.println(node.value);
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }

    public static <E> void inOrderTraversal(Node<E> node) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.left);
        System.out.println(node.value);
        inOrderTraversal(node.right);
    }

    public static <E> void postOrderTraversal(Node<E> node) {
        if (node == null) {
            return;
        }
        postOrderTraversal(node.left);
        postOrderTraversal(node.right);
        System.out.println(node.value);
    }

    private static class Node<E> {
        E value;
        Node<E> left;
        Node<E> right;
    }
}
