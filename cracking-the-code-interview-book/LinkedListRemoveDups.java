import java.util.*;
import java.lang.*;
import static java.lang.System.out;

/**
 * Write code to remove duplicates from an unsorted linked list
 * Book: Cracking the code invervies. 2.1
 */
public class LinkedListRemoveDups {
    public static void main(String args[]) {
        Node head = new Node(10);
        head.appendToTail(9).appendToTail(10).appendToTail(1);
        Solution.usingBuffer(head);
        assertEquals("10->9->1->null", printLinkedList(head));
        
        head = new Node(10);
        head.appendToTail(9).appendToTail(10).appendToTail(1);
        Solution.usingRunnerTechnic(head);
        assertEquals("10->9->1->null", printLinkedList(head));
    }

    static class Solution {

        //Time complexibility: O(N)
        //Solution: Iterate throught the linked list adding each element to a hash table
        //When we found a duplicate element, we remove the element from th elinked list
        //and continue iterating. 
        //
        //Receive node as input
        //Initialize a previous node with null
        //Initialize a hashset buffer
        //While node is not null 
        //|Check if buffer contains node.data 
        //| previous.next receives node.next
        //|Else
        //| Add node.data into the buffer
        //| previous receives node
        //|node receives node.next
        static void usingBuffer(Node node) {
            Node previous = null;
            Set<Integer> buffer = new HashSet<>();
            while (node != null) {
                if (buffer.contains(node.data)) {
                    previous.next = node.next;
                } else {
                    buffer.add(node.data);
                    previous = node;
                }
                node = node.next;
            }
        }

        //Time complexibility: O(N²)
        //Solution: Iterate with two pointers: current which iterate trought the 
        //linked list, and runner which checks all subsequent node for duplicate.
        //
        //Receive a Node node
        //Initialize current with node
        //While current is not null
        //|Initialize a Note runner with current
        //|While runner.next is not null
        //||If current.data is equals to runner.next.data then
        //|| runner.next receives runner.next.next
        //||runner receives runner.next
        //|current receives current.next
        static void usingRunnerTechnic(Node node) {
            Node current = node;
            while (current != null) {
                Node runner = current;
                while (runner.next != null){
                    if (current.data == runner.next.data){
                        runner.next = runner.next.next;
                    }
                    runner = runner.next;
                }
                current = current.next;    
            }
        }
    }

    static String printLinkedList(Node head) {
        StringBuffer str = new StringBuffer();
        str.append(head.data).append("->");
        Node n = head;
        while (n.next != null) {
            n = n.next;
            str.append(n.data).append("->");
        }
        str.append("null");
        return str.toString();
    }

    static void assertEquals(String expected, String value) {
        String msg = "Expected[" + expected + "] was [" + value + "]";
        if (!expected.equals(value))
            throw new RuntimeException("Fail " + msg);

        out.println("OK! " + msg);
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