package com.algorithms;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class QueueTest {

    // TODO-Lab2.6: create a Queue test fixture reference
    Queue<Customer> queue;

    @Before
    public void setUp() throws Exception {
        // TODO-Lab2.6: instantiate the queue test fixture
        queue = new Queue<Customer>();
        // TODO-Lab2.6: populate with one customer object
        queue.enqueue(new Customer(12345, "Andrew Smith", 255));
    }

    // TODO-Lab2.6: design and implement positive and negative tests and give them decent names

    @Test
    public void enqueue_should_add_a_new_node_with_the_value_given() {
        Customer customer = queue.getHead().getValue();

        assertEquals("Andrew Smith", customer.getName());
        assertEquals(12345, customer.getCustNo());
        assertEquals(255, customer.getBalance(), 0.00001);

        queue.enqueue(new Customer(12346, "Brian Hill", 230));
        customer = queue.getHead().getNext().getValue();

        assertEquals("Brian Hill", customer.getName());
        assertEquals(12346, customer.getCustNo());
        assertEquals(230, customer.getBalance(), 0.00001);

        queue.enqueue(new Customer(12347, "Charles K", 9999));
        customer = queue.getHead().getNext().getNext().getValue();

        assertEquals("Charles K", customer.getName());
        assertEquals(12347, customer.getCustNo());
        assertEquals(9999, customer.getBalance(), 0.00001);
    }

    @Test
    public void test_head_tail_updates() {
        Customer headCustomer = queue.getHead().getValue();
        Customer tailCustomer = queue.getTail().getValue();

        assertEquals("Andrew Smith", headCustomer.getName());
        assertEquals(12345, headCustomer.getCustNo());
        assertEquals(255, headCustomer.getBalance(), 0.00001);

        assertEquals("Andrew Smith", tailCustomer.getName());
        assertEquals(12345, tailCustomer.getCustNo());
        assertEquals(255, tailCustomer.getBalance(), 0.00001);

        queue.enqueue(new Customer(12347, "Charles K", 9999));
        headCustomer = queue.getHead().getValue();
        tailCustomer = queue.getTail().getValue();

        assertEquals("Andrew Smith", headCustomer.getName());
        assertEquals(12345, headCustomer.getCustNo());
        assertEquals(255, headCustomer.getBalance(), 0.00001);

        assertEquals("Charles K", tailCustomer.getName());
        assertEquals(12347, tailCustomer.getCustNo());
        assertEquals(9999, tailCustomer.getBalance(), 0.00001);

        queue.dequeue();
        headCustomer = queue.getHead().getValue();
        tailCustomer = queue.getTail().getValue();

        assertEquals("Charles K", headCustomer.getName());
        assertEquals(12347, headCustomer.getCustNo());
        assertEquals(9999, headCustomer.getBalance(), 0.00001);

        assertEquals("Charles K", tailCustomer.getName());
        assertEquals(12347, tailCustomer.getCustNo());
        assertEquals(9999, tailCustomer.getBalance(), 0.00001);
    }

    @Test
    public void dequeue_should_remove_the_first_node_in_the_queue_and_return_value() {
        Customer customer = queue.dequeue();

        assertEquals("Andrew Smith", customer.getName());
        assertEquals(12345, customer.getCustNo());
        assertEquals(255, customer.getBalance(), 0.00001);

        queue.enqueue(new Customer(12346, "Brian Hill", 230));
        customer = queue.dequeue();

        assertEquals("Brian Hill", customer.getName());
        assertEquals(12346, customer.getCustNo());
        assertEquals(230, customer.getBalance(), 0.00001);

        queue.enqueue(new Customer(12347, "Charles K", 9999));
        queue.enqueue(new Customer(12346, "Brian Hill", 230));

        customer = queue.dequeue();
        assertEquals("Charles K", customer.getName());
        assertEquals(12347, customer.getCustNo());
        assertEquals(9999, customer.getBalance(), 0.00001);

        customer = queue.dequeue();
        assertEquals("Brian Hill", customer.getName());
        assertEquals(12346, customer.getCustNo());
        assertEquals(230, customer.getBalance(), 0.00001);
    }

    @Test
    public void dequeueExistingSingleElementPositive() {
        String expected = new Customer(12345, "Andrew Smith", 255).toString();
        String actual = queue.dequeue().toString();
        assertEquals(expected.toString(), actual);
        assertEquals(null, queue.getHead());  // <--- add this test
        assertEquals(null, queue.getTail());  // <--- add this test
    }

}