package ds.linkedlist;

import java.util.*;
import java.lang.*;
import static java.lang.System.out;

/**
 * You are given a pointer/ reference to the node which is to be deleted from
 * the linked list of N nodes. The task is to delete the node. Pointer/
 * reference to head node is not given.
 * 
 * Ex. Given the linked list: 10 20 4 30 Call the method delete(Node ference to
 * 20) The result should be 10 4 30
 * 
 * https://practice.geeksforgeeks.org/problems/delete-without-head-pointer/1
 */
public class LinkedListDeleteNodeWithoutHeadPointer {

    Node head;

    LinkedListDeleteNodeWithoutHeadPointer(Node node) {
        this.head = node;
    }

    public static void main(String[] args) {
        Node head = new Node(10);
        Node node20 = head.addToTail(20);
        head.addToTail(4).addToTail(30);
        LinkedListDeleteNodeWithoutHeadPointer algorithm = new LinkedListDeleteNodeWithoutHeadPointer(head);

        algorithm.deleteNode(node20);
        assertEquals("10->4->30->null", head.toString());
    }

    //Constraint: You can not use the HEAD reference to transverse the linked list
    //Tip: You can swap the data 
    //Swap the data between the node and the node.next
    //Now the node.next become the node that need to be removed remove the node.next
    //In fact you do not need to update the data of the next node since it will be removed.
    void deleteNode(Node node) {
       //int dataToBeDeleted = node.data;//step can be removed
        node.data = node.next.data;
       //node.next.data = dataToBeDeleted;//step can be removed
        node.next = node.next.next;
    }

    
    static class Node {
        Node next;
        int data;

        Node(int data) {
            this.data = data;
        }

        Node addToTail(int d) {
            Node tail = new Node(d);
            Node current = this;
            while (current.next != null)
                current = current.next;
            current.next = tail;
            return tail;
        }

        public String toString() {
            Node head = this;
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

    }

    static void assertEquals(String expected, String value) {
        String msg = "Expected[" + expected + "] was [" + value + "]";
        if (!expected.equals(value))
            throw new RuntimeException("Fail " + msg);

        out.println("OK! " + msg);
    }
}