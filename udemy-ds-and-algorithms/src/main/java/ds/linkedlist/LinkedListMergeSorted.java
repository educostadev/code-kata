package ds.linkedlist;

import java.util.*;
import java.lang.*;
import static java.lang.System.out;

/**
 * Write a SortedMerge() function that takes two linked lists, each of which is sorted
 * in increasing order, and merges the two together into one list which is in
 * increasing order. SortedMerge() should return the new list. The new list
 * should be made by splicing together the nodes of the first two lists.
 * 
 * For example if the first linked list a is 5->10->15 and the other linked list
 * b is 2->3->20, then SortedMerge() should return a pointer to the head node of
 * the merged list 2->3->5->10->15->20.
 * https://www.geeksforgeeks.org/merge-two-sorted-linked-lists/
 */
public class LinkedListMergeSorted {

    public static void main(String args[]) {
        Node headA = new Node(5);
        addToTail(headA, 10);
        addToTail(headA, 15);
        out.println("headA: " + toString(headA));

        Node headB = new Node(2);
        addToTail(headB, 3);
        addToTail(headB, 20);
        out.println("headB: " + toString(headB));

        Node sortedHead = merge(headA, headB);
        assertEquals("2->3->5->10->15->20->null", toString(sortedHead));

    }

    static Node merge(Node headA, Node headB) {
        Node dummy = new Node(-1);
        Node tail = dummy;
        while (headA !=null && headB != null) {
            if (headA.data <= headB.data) {
                tail.next = headA;
                tail = headA;
                headA = headA.next;
            } else {
                tail.next = headB;
                tail = headB;
                headB = headB.next;
            }
        }

        if (headA == null) {
            tail.next = headB;
        } else if (headB == null) {
            tail.next = headA;
        }

        return dummy.next;
    }

    // Only for construct the Linked List. Because this is method is not efficient.
    static void addToTail(Node head, int data) {
        Node n = head;
        while (n.next != null) {
            n = n.next;
        }
        n.next = new Node(data);
    }

    public static String toString(Node head) {
        StringBuffer str = new StringBuffer();
        str.append(head.data + "->");
        Node n = head.next;
        while (n != null) {
            str.append(n.data + "->");
            n = n.next;
        }
        str.append("null");
        return str.toString();
    }

    static class Node {
        Node next;
        int data;

        Node(int data) {
            this.data = data;
        }
    }

    static void assertEquals(String expected, String value) {
        String msg = "Expected[" + expected + "] was [" + value + "]";
        if (!expected.equals(value))
            throw new RuntimeException("Fail " + msg);

        out.println("OK! " + msg);
    }

}