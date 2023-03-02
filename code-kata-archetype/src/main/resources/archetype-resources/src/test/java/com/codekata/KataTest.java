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
  private static Stream<Arguments> readInput() {

    var dataInput1 = DataInput.builder()
    .input("abacabad")
    .expected('c')
    .build();

    var dataInput2 = DataInput.builder()
    .input("a")
    .expected('c')
    .build();

    return Stream.of(
      Arguments.of(dataInput1, new MySolution()),
      Arguments.of(dataInput2, new MySolution())
  );
  }

  /**
   * Adjust the method signature type according to the INPUT and EXPECTED result.
   *
   * @param data    - The input that should be tested and the result expected.
   * @param algorithm - The aproach used to solve the problem
   */
  @ParameterizedTest
  @MethodSource("readInput")
  void solveTheProblem(DataInput data, Solution algorithm) {
    System.out.println("Execution Nr [" + (++execution) + "]");
    System.out.println("\n");
    Assertions.assertEquals(data.expected, algorithm.solve(data.input));
  }

  @Builder
  @ToString
  static class DataInput {
      String input;
      char expected;
  }
}
