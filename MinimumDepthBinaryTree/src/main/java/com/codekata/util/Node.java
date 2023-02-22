package com.codekata.util;

import java.util.HashMap;
import java.util.Map;

public class Node<T> {
    public T value;
    public Node<T> left;
    public Node<T> right;

    public Node(T value) {
        this.value = value;
    }

    public Node() {
    }

    @Override
    public String toString() {
        return "" + value;
    }

    public Node<T> arrayToTree(T[] values) {

        Node<T> root = new Node<>(values[0]);
        Map<Integer, Node<T>> nodes = new HashMap<>();
        nodes.put(0, root);
        for (int i = 0; i < values.length; i++) {
            Node<T> node = nodes.get(i);
            if (node == null) {
                continue;
            }

            int indexLeft = 2 * i + 1;
            if (indexLeft < values.length) {
                var value = values[indexLeft];
                if (value != null) {
                    node.left = new Node<>(value);
                    nodes.put(indexLeft, node.left);
                }
            }

            int indexRight = 2 * i + 2;
            if (indexRight < values.length) {
                var value = values[indexRight];
                if (value != null) {
                    node.right = new Node<>(value);
                    nodes.put(indexRight, node.right);
                }
            }
        }
        ;

        return root;
    }
}
