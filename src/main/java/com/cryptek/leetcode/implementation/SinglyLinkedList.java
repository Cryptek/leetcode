package com.cryptek.leetcode.implementation;

public class SinglyLinkedList<T> implements LinkedList<T> {
  private Node<T> head;
  private int size = 0;

  @Override
  public T get(int index) {
    if (head == null || index >= size) return null;
    Node<T> curr = head;
    for (int i = 0; i < index; i++) curr = curr.next;
    return curr.val;
  }

  @Override
  public void addAtHead(T val) {
    head = new Node<>(val, head);
    size++;
  }

  @Override
  public void addAtTail(T val) {
    if (head == null) {
      addAtHead(val);
      return;
    }
    Node<T> curr = head;
    while (curr.next != null) {
      curr = curr.next;
    }
    curr.next = new Node<>(val);
    size++;
  }

  @Override
  public void addAtIndex(int index, T val) {
    if (index > size) throw new IllegalStateException("Index in invalid. Value will not be inserted");
    if (index == 0) {
      addAtHead(val);
      return;
    }
    Node<T> curr = head;
    for (int i = 0; i < index - 1; i++) curr = curr.next;
    curr.next = new Node<>(val, curr.next);
    size++;
  }

  @Override
  public void deleteAtIndex(int index) {
    if (head == null || index >= size) throw new IllegalStateException("Invalid index. No value will be deleted");
    if (index == 0) {
      head = head.next;
      size--;
      return;
    }
    Node<T> curr = head;
    for (int i = 0; i < index - 1; i++) curr = curr.next;
    curr.next = curr.next.next;
    size--;
  }

  private static class Node<T> {
    T val;
    Node<T> next;

    Node(T val) {
      this.val = val;
    }

    Node(T val, Node<T> next) {
      this.val = val;
      this.next = next;
    }
  }
}