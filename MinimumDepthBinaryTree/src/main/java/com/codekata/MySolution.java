package com.codekata;

import com.codekata.util.Node;
import com.codekata.util.PrintTree;

public class MySolution implements Solution {

  @Override
  public int solve(Integer[] input) {

    Node<Integer> root = new Node<Integer>().arrayToTree(input);
    PrintTree.vertical(root);

    return -1;
  }
}
