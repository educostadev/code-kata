package com.codekata;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

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
				Arguments.of(new Integer[] {}, new Integer[] {}),
				Arguments.of(new Integer[] { 1, 0 }, new Integer[] { 0, 1 }),
				Arguments.of(new Integer[] { 5, 4, 3, 2, 1, 0 }, new Integer[] { 0, 1, 2, 3, 4, 5 }),
				Arguments.of(new Integer[] { 9, 8, 7, 1, 2, 3, 6, 5, 4, 0 }, new Integer[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 })
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
	void myTest(Integer[] input, Integer[] expected) {
		assertArrayEquals(expected, perform(input));
	}

	private Integer[] perform(Integer[] input) {
		return Kata.perform(input);
	}
}
