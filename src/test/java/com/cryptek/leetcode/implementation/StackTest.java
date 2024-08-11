package com.cryptek.leetcode.implementation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    @Test
    void testPushAndPop() {
        Stack<Integer> stack = new Stack<>();
        assertTrue(stack.isEmpty());

        stack.push(10);
        stack.push(20);
        stack.push(30);
        assertFalse(stack.isEmpty());

        assertEquals(30, stack.pop());
        assertEquals(20, stack.pop());
        assertEquals(10, stack.pop());
        assertTrue(stack.isEmpty());
    }

    @Test
    void testPeek() {
        Stack<String> stack = new Stack<>();
        stack.push("hello");
        stack.push("world");

        assertEquals("world", stack.peek()); // Peek doesn't remove
        assertEquals("world", stack.peek()); // Peek again
        assertEquals("world", stack.pop()); // Now remove
    }

    @Test
    void testEmptyStackExceptions() {
        Stack<Object> stack = new Stack<>();
        assertThrows(IllegalStateException.class, stack::pop);
        assertThrows(IllegalStateException.class, stack::peek);
    }

    @Test
    void testGenericTypes() {
        Stack<Double> stack = new Stack<>();
        stack.push(3.14);
        stack.push(2.718);
        assertEquals(2.718, stack.pop());
    }

    // Additional Test Cases (Optional)
    @Test
    void testLargeNumberOfElements() {
        // Push a large number of elements and verify functionality
    }

    @Test
    void testPushNull() {
        // Ensure you can push and pop null values correctly
        Stack<Integer> stack = new Stack<>();
        stack.push(null);
        assertNull(stack.pop());
    }
}
