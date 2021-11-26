package com.codekata;


import java.util.Arrays;

public interface ISolution {

  /**
   * Change the type of the input and output according to the expected type of the problem being solved.
   *
   * @param input - The input for the problem.
   * @return output - The result for the problem solved.
   */
  char solve(String input);

  /**
   * Utility method for print array vertically.
   * i.e
   * [1, 87]
   * [2, 88]
   */
  default void print(int[][] items) {
    Arrays.stream(items).map(Arrays::toString).forEach(System.out::println);
  }

  /**
   * Utility method for print array horizontally
   * i.e
   * [[1, 87], [2, 88]]
   */
  default void printHorizontal(int[][] items) {
    System.out.println(Arrays.deepToString(items));
  }

}
