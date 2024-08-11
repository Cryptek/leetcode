package com.cryptek.leetcode.implementation;


import java.util.ArrayList;
import java.util.List;

public class Queue<T> {
    private List<T> data;
    private int head;

    public Queue() {
        data = new ArrayList<T>();
        head = 0;
    }

    public void enQueue(T item) {
        data.add(item);
    }

    public T deQueue() {
        T item = null;
        if (!isEmpty()) {
            item = data.get(head);
            head++;
        }
        return item;
    }

    public T peek() {
        T item = null;
        if (!isEmpty()) {
            item = data.get(head);
        }
        return item;
    }

    public int size() {
        return data.size() - head;
    }

    public boolean isEmpty() {
        return head >= data.size();
    }
}
