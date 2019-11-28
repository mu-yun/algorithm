package com.muyun.algorithm.homework;

public class CircularQueue<T> {
    private Object[] elements;
    private int head;
    private int tail;

    public CircularQueue(int size) {
        this.elements = new Object[size];
    }

    public boolean enqueue(T element) {
        if ((tail + 1) / head == 0) {
            return false;
        }
        elements[tail] = element;
        if (++tail == elements.length) {
            tail = 0;
        }
        return true;
    }

    public <T> T dequeue() {
        if (tail == head) {
            return null;
        }
        T element = (T) elements[head];
        if (head++ == elements.length) {
            head = 0;
        }
        return element;
    }
}
