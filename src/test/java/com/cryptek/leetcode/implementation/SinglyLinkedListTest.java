package com.cryptek.leetcode.implementation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SinglyLinkedListTest {

  private SinglyLinkedList<Integer> list;

  @BeforeEach
  void setUp() {
    list = new SinglyLinkedList<>();
  }

  @Test
  void testAddAtHead() {
    list.addAtHead(1);
    assertEquals(1, list.get(0));

    list.addAtHead(2);
    assertEquals(2, list.get(0));
    assertEquals(1, list.get(1));
  }

  @Test
  void testAddAtTail() {
    list.addAtHead(1);
    list.addAtTail(2);
    assertEquals(1, list.get(0));
    assertEquals(2, list.get(1));

    list.addAtTail(3);
    assertEquals(3, list.get(2));
  }

  @Test
  void testAddAtIndex() {
    list.addAtHead(1);
    list.addAtTail(3);

    list.addAtIndex(1, 2);
    assertEquals(1, list.get(0));
    assertEquals(2, list.get(1));
    assertEquals(3, list.get(2));

    // Add at the head (index 0)
    list.addAtIndex(0, 0);
    assertEquals(0, list.get(0));
    assertEquals(1, list.get(1));

    // Add at the tail (index == size)
    list.addAtIndex(4, 4);
    assertEquals(4, list.get(4));

    // Test invalid index (greater than size)
    assertThrows(IllegalStateException.class, () -> list.addAtIndex(6, 6));
  }

  @Test
  void testDeleteAtIndex() {
    list.addAtHead(1);
    list.addAtTail(2);
    list.addAtTail(3);

    list.deleteAtIndex(1);
    assertEquals(1, list.get(0));
    assertEquals(3, list.get(1));

    // Delete head
    list.deleteAtIndex(0);
    assertEquals(3, list.get(0));

    // Delete the only element
    list.deleteAtIndex(0);
    assertNull(list.get(0));

    // Test invalid index (greater than size)
    list.addAtHead(1);
    list.addAtTail(2);
    assertThrows(IllegalStateException.class, () -> list.deleteAtIndex(2));
  }

  @Test
  void testGet() {
    list.addAtHead(1);
    list.addAtTail(2);
    list.addAtTail(3);

    assertEquals(1, list.get(0));
    assertEquals(2, list.get(1));
    assertEquals(3, list.get(2));

    // Test invalid index (greater than size)
    assertNull(list.get(3));
  }

  @Test
  void testEmptyListOperations() {
    // Test get from empty list
    assertNull(list.get(0));

    // Test delete from empty list
    assertThrows(IllegalStateException.class, () -> list.deleteAtIndex(0));  // Should do nothing
    assertNull(list.get(0));

    // Test add at tail in empty list
    list.addAtTail(1);
    assertEquals(1, list.get(0));

    // Test add at index 1 in empty list
    SinglyLinkedList<Integer> emptyList = new SinglyLinkedList<>();
    assertThrows(IllegalStateException.class, () -> emptyList.addAtIndex(1, 1));
  }

  @Test
  void testSingleElementList() {
    list.addAtHead(1);

    // Get the only element
    assertEquals(1, list.get(0));

    // Delete the only element
    list.deleteAtIndex(0);
    assertNull(list.get(0));

    // Test add at tail in single-element list
    list.addAtTail(2);
    assertEquals(2, list.get(0));

    // Add at index 1 in single-element list
    list.addAtIndex(1, 3);
    assertEquals(3, list.get(1));

    // Add at index 0 in single-element list (which has become a two-element list now)
    list.addAtIndex(0, 4);
    assertEquals(4, list.get(0));
    assertEquals(2, list.get(1));
    assertEquals(3, list.get(2));
  }
}

