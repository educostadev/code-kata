package ${package}.util;

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

    public Node<T> toTree(T[] values, Type treeType) {
        if (Type.RIGHT_SKEWED_BINARY_TREE.equals(treeType)) {
            return null;
        }
        if (Type.LEFT_SKEWED_BINARY_TREE.equals(treeType)) {
            return toLeftSkewedTree(values);
        } else {
            return toCompleteTree(values);
        }
    }

    public Node<T> toLeftSkewedTree(T[] values) {
        Node<T> root = new Node<>(values[0]);
        Node<T> current = root;
        for (int i = 1; i < values.length; i++) {
            T value = values[i];
            if (value != null) {
                current.left = new Node<>(value);
                current = current.left;
            }
        }
        return root;
    }

    public Node<T> toCompleteTree(T[] values) {

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

        return root;
    }

    public enum Type {
        COMPLETE_BINARY_TREE,
        LEFT_SKEWED_BINARY_TREE,
        RIGHT_SKEWED_BINARY_TREE,
    }
}
