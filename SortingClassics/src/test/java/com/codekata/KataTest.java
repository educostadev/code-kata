package com.codekata;

import com.codekata.util.Node;
import com.codekata.util.PrintTree;

import lombok.Builder;
import lombok.ToString;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class KataTest {

  static int execution;

  /**
   * @return Return a Stream of Argument to be tested.
   *         Arguments.of(<DATA_INPUT>,<ALGORITHM>)
   */
  private static Stream<Arguments> readInputForBubbleSort() {
    return readInput(new BubbleSort());
  }

  private static Stream<Arguments> readInput(Solution algorithm) {

    var dataInput1 = DataInput.builder()
        .input(new int[] {})
        .expected(new int[] {})
        .build();

    var dataInput2 = DataInput.builder()
        .input(new int[] { 1, 0 })
        .expected(new int[] { 0, 1 })
        .build();

    var dataInput3 = DataInput.builder()
        .input(new int[] { 5, 4, 3, 2, 1, 0 })
        .expected(new int[] { 0, 1, 2, 3, 4, 5 })
        .build();

    var dataInput4 = DataInput.builder()
        .input(new int[] { 9, 8, 7, 1, 2, 3, 6, 5, 4, 0 })
        .expected(new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 })
        .build();

    return Stream.of(
        Arguments.of(dataInput1, algorithm),
        Arguments.of(dataInput2, algorithm),
        Arguments.of(dataInput3, algorithm),
        Arguments.of(dataInput4, algorithm)
        );
  }

  /**
   * Adjust the method signature type according to the INPUT and EXPECTED result.
   *
   * @param data      - The input that should be tested and the result expected.
   * @param algorithm - The aproach used to solve the problem
   */
  @ParameterizedTest
  @MethodSource("readInputForBubbleSort")
  void solveTheProblemWithBubbleSort(DataInput data, Solution algorithm) {
    System.out.println("Execution Nr [" + (++execution) + "]");
    System.out.println("\n");
    var result = algorithm.solve(data.input);
    var expected = data.expected;
    if (expected.getClass().isArray() && result.getClass().isArray())
       Assertions.assertArrayEquals(expected, result);
    else
       Assertions.assertEquals(expected, result);
  }

  @Builder
  @ToString
  static class DataInput {
    int[] input;
    int[] expected;
  }
}
