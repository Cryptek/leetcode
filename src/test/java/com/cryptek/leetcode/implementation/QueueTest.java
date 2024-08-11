package com.cryptek.leetcode.implementation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {

    private Queue<Integer> queue;

    @BeforeEach
    void setUp() {
        queue = new Queue<>();
    }

    @Test
    void testInitiallyEmpty() {
        assertTrue(queue.isEmpty(), "Queue should be empty initially");
    }

    @Test
    void testEnqueueAndSize() {
        queue.enQueue(10);
        queue.enQueue(20);
        queue.enQueue(30);
        assertEquals(3, queue.size(), "Queue size should be 3 after enqueueing 3 elements");
    }

    @Test
    void testPeek() {
        queue.enQueue(10);
        assertEquals(10, queue.peek(), "Peek should return the first element, 10");
    }

    @Test
    void testDequeue() {
        queue.enQueue(10);
        queue.enQueue(20);
        assertEquals(10, queue.deQueue(), "Dequeue should return the first element, 10");
        assertEquals(20, queue.deQueue(), "Dequeue should return the next element, 20");
    }

    @Test
    void testSizeAfterDequeuing() {
        queue.enQueue(10);
        queue.enQueue(20);
        queue.deQueue();
        assertEquals(1, queue.size(), "Queue size should be 1 after dequeuing 1 element");
    }

    @Test
    void testPeekAfterDequeues() {
        queue.enQueue(10);
        queue.enQueue(20);
        queue.deQueue();
        assertEquals(20, queue.peek(), "Peek should now return the next element, 20");
    }

    @Test
    void testDequeueAll() {
        queue.enQueue(10);
        queue.deQueue();
        assertTrue(queue.isEmpty(), "Queue should be empty after dequeuing all elements");
    }

    @Test
    void testEmptyQueuePeekAndDequeue() {
        assertNull(queue.peek(), "Peek on empty queue should return null");
        assertNull(queue.deQueue(), "Dequeue on empty queue should return null");
    }
}
