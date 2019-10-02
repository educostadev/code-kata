import java.util.*;

import javafx.scene.Node;

import static java.lang.System.out;
import java.lang.*;

public class SinglyLinkedListImplementation {

    public static void main(String args[]) {
        Node head = new Node(0);
        out.println(head);
        for (int i = 1; i <= 5; i++) {
            head.appendToTail(i);
            out.println(head);
        }

        head = deleteNode(head, 0);
        out.println(head);
        head = deleteNode(head, 3);
        out.println(head);
        head = deleteNode(head, 5);
        out.println(head);
    }

    // Delete a note and return a new Head
    static Node deleteNode(Node head, int data) {
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
}