package com.codekata;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * https://www.baeldung.com/parameterized-tests-junit-5
 */
class SolutionTest {

	/**
	 * @return Return a Stream of Agrument to be tested. Arguments.of(<INPUT>,<EXPECTED>)
	 */
	private static Stream<Arguments> readInput() {
		return Stream.of(
				Arguments.of(9, 2), //1001
				Arguments.of(529, 4), // 1000010001
				Arguments.of(20, 1), //10100
				Arguments.of(15, 0), //1111
				Arguments.of(32, 0)//100000
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
	void myTest(int input, int expected) {
		assertEquals(expected, perform(input));
	}

	private int perform(int N) {
		return Solution.solution(N);
	}
}
