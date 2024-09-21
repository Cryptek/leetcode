package com.cryptek.leetcode.implementation;

public interface LinkedList<T> {

  //Get the value of the index th node in the linked list. If the index is invalid, return -1.
  public T get(int index);

  //Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
  public void addAtHead(T val);

  //Append a node of value val as the last element of the linked list.
  public void addAtTail(T val);

  //Add a node of value val before the indexth node in the linked list. If index equals the length of the linked list, the node will be appended to the end of the linked list.
  // If index is greater than the length, the node will not be inserted.
  public void addAtIndex(int index, T val);

  //Delete the index th node in the linked list, if the index is valid.
  public void deleteAtIndex(int index);
}
