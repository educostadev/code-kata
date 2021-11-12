package com.codekata;

import java.util.Arrays;

public class PrintUtil {

  static void printVertical(int[][] items) {
    Arrays.stream(items).map(Arrays::toString).forEach(System.out::println);
  }

  static void printHorizontal(int[][] items) {
    System.out.println(Arrays.deepToString(items));
  }

}
