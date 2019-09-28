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
				Arguments.of("ABC", "ABC ACB BAC BCA CAB CBA")
		);
	}

	/**
	 * Adjust the method signature type according to the INPUT and EXPECTED result.
	 * @param input - The input that should be tested.
	 * @param expected - The expected result.
	 */
	@ParameterizedTest
	@MethodSource("readInput")
	void myTest(String input, String expected) {
		assertEquals(expected, perform(input));
	}

	private String perform(String s) {
		return Kata.perform(s);
	}
}
