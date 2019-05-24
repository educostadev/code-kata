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

	private static Stream<Arguments> readInput() {
		return Stream.of(
				Arguments.of("abacabad", 'c'),
				Arguments.of("a", '_'),
		);
	}

	@ParameterizedTest
	@MethodSource("readInput")
	void myTest(String input, char expected) {
		assertEquals(expected, perform(input));
	}

	private char perform(String s) {
		return ' ';
	}
}
