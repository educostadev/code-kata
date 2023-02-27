package com.codekata;

import java.util.LinkedList;

import com.codekata.util.Node;
import com.codekata.util.Pair;

public class BFSQueueApproach implements Solution {

    @Override
    public int solve(Node<Integer> root) {
        
        if (root == null)
            return 0;

        LinkedList<Pair<Node<Integer>, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(root,1));

        int current_depth = 0;
        while(!queue.isEmpty()){
            var pair = queue.poll();
            var node = pair.valueA;
            current_depth = pair.valueB;

            if (node.left == null && node.right == null)
                break;
            
            if (node.left != null)
                queue.add(new Pair<>(node.left, current_depth+1));
            
            if (node.right != null)
                queue.add(new Pair<>(node.right, current_depth+1));
            
        }

        return current_depth;
    }


    
}
