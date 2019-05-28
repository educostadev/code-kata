package com.codekata;

public class Kata {

	static ListNode<Integer> removeKFromList(ListNode<Integer> node, int k) {

		if (node == null)
			return null;

		node.next = removeKFromList(node.next, k);

		if (node.value == k)
			return node.next;

		return node;

	}

}
