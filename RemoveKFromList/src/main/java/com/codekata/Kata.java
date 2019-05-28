package com.codekata;

public class Kata {

	static ListNode<Integer> removeKFromList(ListNode<Integer> node, int k) {

		node = findFirstNodeNotEqualsTo(k, node);
		if (node == null)
			return null;

		ListNode<Integer> firstNode = new ListNode<>(node.value);
		ListNode<Integer> newNode = firstNode;
		do {
			node = node.next;
			if (node != null && node.value != k) {
				newNode.next = new ListNode<>(node.value);
				newNode = newNode.next;
			}
		} while (node != null);

		return firstNode;
	}

	private static ListNode<Integer> findFirstNodeNotEqualsTo(int k, ListNode<Integer> node) {
		if (node == null) {
			return null;
		}
		while (node.next != null && node.value == k) {
			node = node.next;
		}
		if (node.value == k) {
			return null;
		}
		return node;
	}

}
