package problems;

import java.util.*;
import static java.lang.System.out;
import java.lang.*;

//https://practice.geeksforgeeks.org/problems/intersection-point-in-y-shapped-linked-lists/1#ExpectOP
//Intersection Point in Y Shapped Linked Lists 
//There are two singly linked lists of size N and M in a system. But, due to some programming error 
//the end node of one of the linked list got linked into one of the node of second list, forming a 
//inverted Y shaped list. Write a program to get the point where two linked lists intersect each other.
public class IntersectionPointLinkedList {

    // Using Runner Technique: two index, onde for each linkedlist
    // Find the listaASize and listBSize
    // Initialize nodeA with headA and nodeB with headB
    // If listASize is the biggest
    // |nodeA receives the node at position listAsize - listBSize
    // If listBsize is the biggest
    // |nodeB receives the node at position listBSize - listASize
    // Transverse linkedList of nodeA and nodeB simultanious
    // | if nodeA.data is equals nodeB.data return nodeA.data
    // Return -1
    static class Intersect {

        static int intersectPoint(Node headA, Node headB) {
            int listASize = sizeOf(headA);
            int listBSize = sizeOf(headB);
            Node nodeA = headA;
            Node nodeB = headB;
            if (listASize > listBSize) {
                nodeA = getNodeAtPosition(listASize - listBSize, headA);
            } else if (listBSize > listASize) {
                nodeB = getNodeAtPosition(listBSize - listASize, headB);
            }

            while (nodeA.next != null) {
                nodeA = nodeA.next;
                nodeB = nodeB.next;
                if (nodeA.data == nodeB.data)
                    return nodeA.data;
            }
            return -1;
        }

        static Node getNodeAtPosition(int position, Node node) {
            Node n = node;
            while (position != 0) {
                n = node.next;
                position--;
            }
            return n;
        }

        static int sizeOf(Node head) {
            int size = 1;
            Node n = head;
            while (n.next != null) {
                size++;
                n = n.next;
            }
            return size;
        }
    }

    public static void main(String[] args) {
        Node headA = new Node(10);
        headA.appendToTail(20).appendToTail(5).appendToTail(10);
        printLinkedList(headA);
        Node headB = new Node(30);
        headB.appendToTail(40).appendToTail(50).appendToTail(5).appendToTail(10);
        printLinkedList(headB);
        out.println("Inserction:" + Intersect.intersectPoint(headA, headB));

    }

    static void printLinkedList(Node head) {
        StringBuffer str = new StringBuffer();
        str.append(head.data).append("->");
        Node n = head;
        while (n.next != null) {
            n = n.next;
            str.append(n.data).append("->");
        }
        str.append("null");
        out.println(str.toString());
    }

    static class Node {
        Node next;
        int data;

        Node(int data) {
            this.data = data;
        }

        Node appendToTail(int d) {
            Node tail = new Node(d);
            Node current = this;
            while (current.next != null)
                current = current.next;
            current.next = tail;
            return tail;
        }

        public String toString() {
            return "" + data;
        }
    }
}