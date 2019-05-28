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
	 * input / expected
	 */
	private static Stream<Arguments> readInput() {
		return Stream.of(
				Arguments.of(new int[] { 0, 1, 0 }, true),
				Arguments.of(new int[] { 1, 2, 2, 3 }, false),
				Arguments.of(new int[] { 1, 1000000000, -1000000000, -1000000000, 1000000000, 1 }, true),
				Arguments.of(new int[] { 1, 2, 3, 3, 2 }, false),
				Arguments.of(new int[] { 1, 2, 3, 1, 2, 3 }, false),
				Arguments.of(new int[] {}, true),
				Arguments.of(new int[] { 3, 5, 3, 5 }, false),
				Arguments.of(new int[] { 1, 5, 2, 4 }, false),
				Arguments.of(new int[] { 10 }, true),
				Arguments.of(new int[] { 0, 0 }, true),
				Arguments.of(new int[] { 1, 3, 2, 2, 2 }, false)

		);
	}

	@ParameterizedTest
	@MethodSource("readInput")
	void myTest(int[] input, boolean expected) {
		Assertions.assertEquals(expected, Kata.isListPalindrome(ListNode.toNode(input)));
	}

}
