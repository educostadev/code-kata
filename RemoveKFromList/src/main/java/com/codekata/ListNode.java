package com.codekata;

import java.util.ArrayList;
import java.util.List;

public class ListNode<T> {

	T value;
	ListNode<T> next;

	ListNode(T x) {
		value = x;
	}

	static int[] toArray(ListNode<Integer> node) {
		if (node == null) {
			return new int[] {};
		}

		List<Integer> values = new ArrayList<>();

		while (node.next != null) {
			values.add(node.value);
			node = node.next;
		}
		values.add(node.value);

		int[] array = values.stream().mapToInt(i -> i).toArray();
		return array;
	}

	static ListNode<Integer> toNode(int[] array) {
		if (array.length == 0) {
			return null;
		}
		ListNode<Integer> currentNode = new ListNode<>(array[0]);
		ListNode<Integer> firstNode = currentNode;
		for (int index = 1; index < array.length; index++) {
			currentNode.next = new ListNode<>(array[index]);
			currentNode = currentNode.next;
		}
		return firstNode;
	}

	@Override
	public String toString() {
		return value + " -> " + (next == null ? "null" : next.value);
	}

}

