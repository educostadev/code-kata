import java.util.*;

import static java.lang.System.out;
import static java.lang.System.err;
import java.lang.*;

//Implemeting a Singly Linked List
public class SinglyLinkedListImplementation {

    public static void main(String args[]) {
        SinglyLinkedList lkList = new SinglyLinkedList();
        assertEquals("empty", lkList.toString());
       
        lkList = new SinglyLinkedList();
        lkList.addFirst(1);
        assertEquals("1->null", lkList.toString());
    
        lkList.addFirst(0);
        assertEquals("0->1->null", lkList.toString());

        lkList = new SinglyLinkedList();
        lkList.addLast(1);
        assertEquals("1->null", lkList.toString());

        lkList.addLast(2);
        assertEquals("1->2->null", lkList.toString());

        lkList = new SinglyLinkedList();
        lkList.addLast(0).addLast(1).addLast(3);
        lkList.add(2, 2);
        assertEquals("0->1->2->3->null", lkList.toString());
        
        lkList = new SinglyLinkedList();
        lkList.addLast(0).addLast(1).addLast(2).addLast(3);
        lkList.removeFirst();
        assertEquals("1->2->3->null", lkList.toString());
    
        lkList = new SinglyLinkedList();
        lkList.addLast(0);
        lkList.removeFirst();
        assertEquals("empty", lkList.toString());
    }

    static class SinglyLinkedList{
        Node head;
        Node tail;

        //removeFirst
        //removeLast
        //remove(inde index)

        void removeFirst() {
            Node first = head;
            head = first.next;
            first.next = null;
            if (first.next == null)
                tail = null;
        }

        SinglyLinkedList add(int data, int position) {
            if (position == 0) {
                return this.addFirst(data);
            }
            int count = 0;
            Node node = head;
            while (count < position - 1) {
                node = node.next;
                count++;
            }

            Node newNode = new Node(data);
            Node temp = node.next;
            node.next = newNode;
            newNode.next = temp; 

            return this;
        }

        SinglyLinkedList addLast(int data) {
            if (head == null) {
                initialize(data);
            } else {
                Node newNode = new Node(data);
                tail.next = newNode;
                tail = newNode;
            }
            return this;
        }

        SinglyLinkedList addFirst(int data) {
            if (head == null)
                initialize(data);
            else {
                Node newNode = new Node(data);
                newNode.next = head;
                head = newNode;
            }
            return this;
        }

        void initialize(int data) {
            Node node = new Node(data);
            head = node;
            tail = node;
        }

        public String toString() {
            if (head == null && tail == null)
                return "empty";
                
            return head.toString();
        }

    }

    // Delete a note and return a new Head
    static Node deleteNodeWithData(Node head, int data) {
        if (head.data == data) {
            Node n = head.next;
            head.next = null;
            return n;
        }

        Node n = head;
        while (n.next != null) {
            if (n.next.data == data) {
                n.next = n.next.next;
                return head;
            }
            n = n.next;
        }

        return head;
    }

    static class Node {
        Node next;
        final int data;

        Node(int data) {
            this.data = data;
        }

        void appendToTail(int d) {
            Node end = new Node(d);
            Node n = this;
            while (n.next != null)
                n = n.next;
            n.next = end;
        }

        public String toString() {
            StringBuffer str = new StringBuffer();
            str.append(data + "->");
            Node n = next;
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