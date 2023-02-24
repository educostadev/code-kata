package com.codekata;

import com.codekata.util.Node;
import com.codekata.util.PrintTree;

import javax.swing.tree.TreeNode;

public class RecursiveApproach implements Solution {

  @Override
  public int solve(Node<Integer> root) {

    if (root == null)
      return 0;

    if (root.left == null && root.right == null)
      return 1;

    int minDeph = Integer.MAX_VALUE;
    if (root.left != null)
      minDeph = Math.min(solve(root.left), minDeph);

    if (root.right != null)
      minDeph = Math.min(solve(root.right), minDeph);

    return minDeph + 1;
  }
}
