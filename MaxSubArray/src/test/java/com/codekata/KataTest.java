package com.codekata;

import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * https://www.baeldung.com/parameterized-tests-junit-5
 */
abstract class KataTest {

  /**
   * @return Return a Stream of Argument to be tested. Arguments.of(<INPUT>,<EXPECTED>)
   */
  private static Stream<Arguments> readInput() {
    return Stream.of(
            Arguments.of(new int[]{-2,1,-3,4,-1,2,1,-5,4}, 6),
            Arguments.of(new int[]{1}, 1),
            Arguments.of(new int[]{5,4,-1,7,8}, 23)
    );
  }

  /**
   * Adjust the method signature type according to the INPUT and EXPECTED result.
   *
   * @param input    - The input that should be tested.
   * @param expected - The expected result.
   */
  @ParameterizedTest
  @MethodSource("readInput")
  void solveTheProblem(int[] input, int expected) {
    Solution solution = createSolution();
    Assertions.assertEquals(expected, solution.solve(input));
  }

  abstract Solution createSolution();
}
