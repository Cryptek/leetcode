package com.cryptek.leetcode.implementation;

public class SinglyLinkedList<T> implements LinkedList<T> {
    private Node<T> head;

    public SinglyLinkedList() {

    }
    @Override
    public T get(int index) {
        Node<T> curr = head;
        for(int i=0; i<index; i++) {
            if (curr == null) {throw new IllegalStateException("Index is invalid");}
            curr = curr.next;
        }
        return curr == null ? null : curr.val;
    }

    @Override
    public void addAtHead(T val) {
        Node<T> newNode = new Node<>(val, head);
        head = newNode;
    }

    @Override
    public void addAtTail(T val) {
        Node<T> curr = head;
        while (curr.next != null) {curr = curr.next;}
        curr.next = new Node<>(val);
    }

    @Override
    public void addAtIndex(int index, T val) {
        Node<T> curr = head;
        for (int i=0; i<index-1; i++) {
            if (curr == null) {throw new IllegalStateException("Index is invalid. Value will not be inserted.");}
            curr = curr.next;
        }
        Node<T> oldNext = curr.next;
        curr.next = new Node<>(val, oldNext);
    }

    @Override
    public void deleteAtIndex(int index) {
        if (index == 0) {
            head = head.next;
        }
        Node<T> curr = head;
        for (int i=0; i<index-1; i++) {
            if (curr == null) {throw new IllegalStateException("Index is invalid");}
            curr = curr.next;
        }
        if(curr.next != null) {
            curr.next = curr.next.next;
        }
    }

    private class Node<T> {
        T val;
        Node next;

        Node(T val) {
            this.val = val;
        }

        Node(T val, Node next) {
            this.val = val;
            this.next = next;
        }
    }
}
