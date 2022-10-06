package com.algorithms;

public class Stack<V> {

    private LinkedListNode<V> head;

    public void push(V item) {
//        pseudo-code
//        if (item != null)
        if (item != null) {
//          node = new LinkedListNode(item, head)
            LinkedListNode<V> node = new LinkedListNode(item, head);
//          head = node
            head = node;
        }
    }

    public V pop() {
//      pseudo-code
//      if (head != null)
        if (head != null) {
//          node = head
            LinkedListNode<V> node = head;
//          head = node.next
            head = node.getNext();
//          return node.value
            return node.getValue();
        }
//      if (head == null), return null
        return null;
    }

    public LinkedListNode<V> getHead() {
        return head;
    }

}
