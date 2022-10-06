package com.algorithms;

import java.util.Optional;

public class Queue<V> {
    /*
    This is the Queue using DblLinkedListNode
     */
//    // DblLinkedListNode is provided
//    // create a private Node for "head"
//    // create a private Node for "tail"
//    private DblLinkedListNode<V> head;
//    private DblLinkedListNode<V> tail;
//
    /*
    This is the Queue using SinglyLinkedListNode
     */
    private LinkedListNode<V> head;
    private LinkedListNode<V> tail;

    public Queue() {
        head = null;
        tail = null;
    }

    public void enqueue(V item) {
        /*
        This is DblLinkedListNode implementation
         */
//        // add an item to the queue
//        //    create new node from item, null previous and next
//        DblLinkedListNode node = new DblLinkedListNode(item, null, null);
//        //    if head is null:
//        if (head == null) {
//            //        point head and tail at new node
//            head = node;
//            tail = node;
//        }
//        //    else:
//        else {
//            //        set tail next to new node
//            tail.setNext(node);
//            //        set new node's previous to tail
//            node.setPrevious(tail);
//            //        set tail to new node
//            tail = node;
//        }
        /*
        This is SinglyLinkedListNode implementation
         */
        LinkedListNode node = new LinkedListNode(item, null);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.setNext(node);
            tail = node;
        }
    }

    public V dequeue() {
        /*
        This is DblLinkedListNode implementation
         */
//        // get and remove an item from the queue
//        //    1. if head is null
//        if (head == null) {
//            //          return null
//            return null;
//        }
//        //    2. node = the node head is pointing at
//        DblLinkedListNode node = head;
//        //    3. head = head.next
//        head = head.getNext();
//        //    4. if head is not null:
//        if (head != null) {
//            //            set head previous to null
//            head.setPrevious(null);
//        }
//        //    5. return node.value
//        return (V) node.getValue();
        /*
        This is SinglyLinkedListNode implementation
         */
        if (head == null) {
            return null;
        }
        LinkedListNode node = head;
        head = head.getNext();
        if (tail == node) {
            tail = null;
        }
        return (V) node.getValue();
    }

    /*
        DblLinkedListNode getHead
     */
    //    public DblLinkedListNode<V> getHead() {
    //        return head;
    //    }
    public LinkedListNode<V> getHead() {
        return head;
    }

    /*
        DblLinkedListNode getTail
     */
    //    public DblLinkedListNode<V> getTail() {
    //        return tail;
    //    }
    public LinkedListNode<V> getTail() {
        return tail;
    }

    public static void main(String[] args) {
        Queue<String> q = new Queue<>();
        q.enqueue("one");
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        q.enqueue("one");
        q.enqueue("two");
        q.enqueue("three");
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        q.enqueue("two");
        q.enqueue("three");
        System.out.println("2 values added to queue");
        System.out.println("Now try to remove both values");
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println("\nAll values removed, try to remove another");
        System.out.println(q.dequeue());
        System.out.println("\nQueue should be empty now, add a new item");
        q.enqueue("four");
        System.out.println("\nNow remove the one item");
        System.out.println(q.dequeue());
        System.out.println("\nAll items should be gone, try to remove one");
        System.out.println(q.dequeue());
    }
}
