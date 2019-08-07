package com.codekata;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * https://www.baeldung.com/parameterized-tests-junit-5
 */
class KataTest {

	/**
	 * @return Return a Stream of Agrument to be tested. Arguments.of(<INPUT>,<EXPECTED>)
	 */
	private static Stream<Arguments> readInput() {
		return Stream.of(
				Arguments.of(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 }, 5, 4),
				Arguments.of(new Integer[] { 1, 2, 3 }, 10, -1),
				Arguments.of(new Integer[] { 1, 2, 3 }, 0, -1)
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
	void myTest(Integer[] input, int find, int expected) {
		assertEquals(expected, perform(input, find));
	}

	private int perform(Integer[] input, int find) {
		return Kata.perform(input, find);
	}
}
