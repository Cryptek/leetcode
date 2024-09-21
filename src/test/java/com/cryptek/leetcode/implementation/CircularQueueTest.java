package com.cryptek.leetcode.implementation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CircularQueueTest {

  private CircularQueue<Integer> queue;

  @BeforeEach
  void setUp() {
    queue = new CircularQueue<>(3); // Initialize with capacity 3
  }

  @Test
  void testInitiallyEmpty() {
    assertTrue(queue.isEmpty(), "Queue should be empty initially");
    assertFalse(queue.isFull(), "Queue should not be full initially");
    assertEquals(0, queue.size(), "Queue size should be 0 initially");
  }

  @Test
  void testEnqueueAndIsFull() {
    queue.enQueue(10);
    queue.enQueue(20);
    queue.enQueue(30);

    assertEquals(3, queue.size(), "Queue size should be 3 after enqueueing 3 elements");
    assertTrue(queue.isFull(), "Queue should be full after enqueueing to capacity");
  }

  @Test
  void testPeek() {
    queue.enQueue(10);
    assertEquals(10, queue.peek(), "Peek should return the first element, 10");
    assertEquals(1, queue.size(), "Peek should not change the queue size");
  }

  @Test
  void testDequeue() {
    queue.enQueue(10);
    assertEquals(10, queue.deQueue(), "Dequeue should return the first element, 10");
    assertEquals(0, queue.size(), "Queue size should be 0 after one dequeue");
    assertFalse(queue.isFull(), "Queue should not be full after dequeueing");
  }

  @Test
  void testCircularBehavior() {
    queue.enQueue(10);
    queue.enQueue(20);
    queue.deQueue();
    queue.enQueue(30);
    assertEquals(20, queue.peek(), "Peek should return the first element after wrapping");

    queue.enQueue(40);
    assertTrue(queue.isFull(), "Queue should be full after wrapping");
  }

  @Test
  void testDequeueAll() {
    queue.enQueue(10);
    queue.enQueue(20);
    queue.enQueue(30);

    assertEquals(10, queue.deQueue());
    assertEquals(20, queue.deQueue());
    assertEquals(30, queue.deQueue());

    assertTrue(queue.isEmpty(), "Queue should be empty after dequeuing all elements");
    assertEquals(0, queue.size(), "Queue size should be 0 after dequeuing all");
  }

  @Test
  void testDequeueFromEmptyQueue() {
    assertThrows(IllegalStateException.class, queue::deQueue, "Dequeue on empty queue should throw exception");
  }

  @Test
  void testPeekFromEmptyQueue() {
    assertThrows(IllegalStateException.class, queue::peek, "Peek on empty queue should throw exception");
  }

  @Test
  void testEnqueueAfterEmptying() {
    queue.enQueue(10);
    queue.deQueue();
    queue.enQueue(20);
    assertEquals(20, queue.peek(), "Peek should return the enqueued element");
  }
}
