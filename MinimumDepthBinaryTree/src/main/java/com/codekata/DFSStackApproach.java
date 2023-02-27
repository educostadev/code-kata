package com.codekata;

import com.codekata.util.Node;
import com.codekata.util.Pair;

import java.util.Stack;

public class DFSStackApproach implements Solution {
    @Override
    public int solve(Node<Integer> root) {
       
        if (root == null)
            return 0;

        Stack<Pair<Node<Integer>, Integer>> stack = new Stack<>();
        stack.add(new Pair<>(root, 1));

        int min_depth = Integer.MAX_VALUE;
        while (!stack.isEmpty()) {
            var pair = stack.pop();
            var node = pair.valueA;
            int current_depth = pair.valueB;
            System.out.println("Visited ["+node.value+"]");

            if (node.left == null && node.right == null)
                min_depth = Math.min(min_depth, current_depth);

            if (node.left != null)
                stack.add(new Pair<>(node.left, current_depth + 1));

            if (node.right != null)
                stack.add(new Pair<>(node.right, current_depth + 1));
        }

        return min_depth;
    }


}
