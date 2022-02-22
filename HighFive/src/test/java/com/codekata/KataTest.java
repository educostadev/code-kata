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
   * @return Return a Stream of Agrument to be tested. Arguments.of(<INPUT>,<EXPECTED>)
   */
  private static Stream<Arguments> readInput() {
    return Stream.of(
        Arguments.of(
            new int[][] {{1, 91}, {1, 92}, {2, 93}, {2, 97}, {1, 60}, {2, 77}, {1, 65}, {1, 87}, {1, 100}, {2, 100}, {2, 76}},
            new int[][] {{1, 87}, {2, 88}}
        )
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
  void testSortingApproach(int[][] input, int[][] expected) {
    Solution solution = createSolution();
    Assertions.assertArrayEquals(expected, solution.solve(input));
  }

  abstract Solution createSolution();


}
