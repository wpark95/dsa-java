package com.algorithms;

import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;

public class StackTest {

    private Stack<Integer> stack;

    @Before
    public void setUp() {
        stack = new Stack<>();
        stack.push(1);
    }

    @Test
    public void push_valid_types() {
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(1);

        LinkedListNode node1 = stack.getHead();
        LinkedListNode node2 = node1.getNext();
        LinkedListNode node3 = node2.getNext();
        LinkedListNode node4 = node3.getNext();
        LinkedListNode node5 = node4.getNext();
        LinkedListNode node6 = node5.getNext();

        assertEquals(1, node1.getValue());
        assertEquals(5, node2.getValue());
        assertEquals(4, node3.getValue());
        assertEquals(3, node4.getValue());
        assertEquals(2, node5.getValue());
        assertEquals(1, node6.getValue());
    }

    @Test
    public void pop() {
        stack.push(2);
        stack.push(3);

        assertEquals(Integer.valueOf(3), stack.pop());
        assertEquals(Integer.valueOf(2), stack.pop());
        assertEquals(Integer.valueOf(1), stack.pop());
        assertEquals(null, stack.pop());

        stack.push(5);
        assertEquals(Integer.valueOf(5), stack.pop());
        assertEquals(null, stack.pop());
    }

}