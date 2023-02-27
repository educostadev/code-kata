package com.codekata;

import com.codekata.util.Node;

public class DFSRecursiveApproach implements Solution {

  @Override
  public int solve(Node<Integer> root) {

    if (root == null)
      return 0;

    System.out.println("Visited ["+root.value+"]");

    if (root.left == null && root.right == null)
      return 1;

    int min_depth = Integer.MAX_VALUE;
    if (root.left != null)
      min_depth = Math.min(solve(root.left), min_depth);

    if (root.right != null)
      min_depth = Math.min(solve(root.right), min_depth);

    return min_depth + 1;
  }
}
