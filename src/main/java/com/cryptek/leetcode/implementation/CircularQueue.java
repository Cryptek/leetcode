package com.cryptek.leetcode.implementation;

import java.util.ArrayList;
import java.util.List;

public class CircularQueue<T> {
  /*
  Implement Circular queue of fixed size
   */
  private final List<T> data;
  private int head;
  private int tail;
  private final int capacity;
  private int size;

  public CircularQueue(int capacity) {
    data = new ArrayList<>(capacity);
    for (int i = 0; i < capacity; i++) {
      data.add(null);
    }
    this.capacity = capacity;
    head = 0;
    tail = 0;
    size = 0;
  }

  public void enQueue(T item) {
    if (isFull()) {
      throw new IllegalStateException("Queue is full");
    }
    data.set(tail, item);
    tail = (tail + 1) % capacity;
    size++;
  }

  public T peek() {
    if (isEmpty()) {
      throw new IllegalStateException("Queue is empty");
    }
    return data.get(head);
  }

  public T rear() {
    if (isEmpty()) {
      throw new IllegalStateException("Queue is empty");
    }
    return data.get((tail - 1 + capacity) % capacity);
  }

  public T deQueue() {
    if (isEmpty()) {
      throw new IllegalStateException("Queue is empty");
    }
    T item = data.get(head);
    data.set(head, null);
    head = (head + 1) % capacity;
    size--;
    return item;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public boolean isFull() {
    return size == capacity;
  }

  public int size() {
    return size;
  }
}
