package com.muyun.algorithm.collection;

public class CircularQueue<T> {
    private Object[] elements;
    private int head;
    private int tail;

//    private int count; //判断队列为空或者满时，也可以通过添加一个count变量来实现

    public CircularQueue(int size) {
        this.elements = new Object[size];
    }


    public boolean enqueue(T element) {
//        if (count == elements.length) {
//            return false;
//        }
        if ((tail + 1) % head == 0) {
            return false;
        }
        elements[tail] = element;
        calculateTail();
//        count++;
        return true;
    }

    public <T> T dequeue() {
//        if (count == 0) {
//            return null;
//        }
        if (tail == head) {
            return null;
        }
        T element = (T) elements[head];
        calculateHead();
//        count--;
        return element;
    }

    /**
     * 计算head的两种方式：
     * 0.自增以后，如果等于elements长度则为0
     * 1.自增然后对elements长度做取余操作
     */
    private void calculateHead() {
        calculateHead0();
    }

    private void calculateHead0() {
        if (++head == elements.length) {
            head = 0;
        }
    }

    private void calculateHead1() {
        head = (head + 1) % elements.length;
    }

    private void calculateTail() {
        calculateTail0();
    }

    private void calculateTail0() {
        if (++tail == elements.length) {
            tail = 0;
        }
    }

    private void calculateTail1() {
        tail = (tail + 1) % elements.length;
    }

}
