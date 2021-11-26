package com.codekata;

import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * https://www.baeldung.com/parameterized-tests-junit-5
 */
class KataTest {

  /**
   * @return Return a Stream of Argument to be tested. Arguments.of(<INPUT>,<EXPECTED>)
   */
  private static Stream<Arguments> readInput() {
    return Stream.of(
        Arguments.of("abacabad", 'c'),
        Arguments.of("a", 'c')
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
  void solveTheProblem(String input, char expected) {
    ISolution ISolution = new Kata();
    Assertions.assertEquals(expected, ISolution.solve(input));
  }

}
