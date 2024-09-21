package com.cryptek.leetcode.implementation;

import java.util.LinkedList;
import java.util.List;

public class Stack<T> {
  private final List<T> data;

  public Stack() {
    //better memory use(dynamic), no extra allocation in beginning plus we only remove and add at end, no resizing when full
    data = new LinkedList<>();
  }

  public void push(T item) {
    data.add(item);
  }

  public T pop() {
    if (isEmpty()) {
      throw new IllegalStateException("Stack is empty");
    }
    return data.removeLast();
  }

  public T peek() {
    if (isEmpty()) {
      throw new IllegalStateException("Stack is empty");
    }
    return data.getLast();
  }

  public boolean isEmpty() {
    return data.isEmpty();
  }
}
