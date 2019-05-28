package com.codekata;

public class Kata {

	static ListNode<Integer> removeKFromList(ListNode<Integer> node, int k) {

		ListNode<Integer> newHead = new ListNode<>(null);
		newHead.next = node;

		ListNode<Integer> previous = newHead;
		ListNode<Integer> current = node;
		while (current != null) {
			if (current.value == k) {
				previous.next = current.next;
			} else {
				previous = current;
			}
			current = current.next;
		}

		return newHead.next;
	}

}
