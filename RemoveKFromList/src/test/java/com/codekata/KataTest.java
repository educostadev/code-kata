package com.codekata;

import static com.codekata.Kata.removeKFromList;
import static com.codekata.ListNode.toArray;
import static com.codekata.ListNode.toNode;
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
	 * input
	 * expected
	 * k
	 */
	private static Stream<Arguments> readInput() {
		return Stream.of(
				Arguments.of(new int[] { 3, 1, 2, 3, 4, 5 }, new int[] { 1, 2, 4, 5 }, 3),
				Arguments.of(new int[] { 1, 2, 3, 4, 5, 6, 7 }, new int[] { 1, 2, 3, 4, 5, 6, 7 }, 10),
				Arguments.of(new int[] { 1000, 1000 }, new int[] {}, 1000),
				Arguments.of(new int[] {}, new int[] {}, -1000),
				Arguments.of(new int[] { 123, 456, 789, 0 }, new int[] { 123, 456, 789 }, 0)
		);
	}

	@ParameterizedTest
	@MethodSource("readInput")
	void myTest(int[] input, int[] expected, int k) {
		assertArrayEquals(expected, toArray(removeKFromList(toNode(input), k)));
	}

	private int[] perform(int[] input, int k) {
		return input;
	}
}
