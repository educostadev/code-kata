package com.codekata;

class Solution {

	/*
		Problem: Binary Gap - A sequence of 0 surronded by 1
		Input: A positive integer
		Output: The lenght of the longest binary gap. 0 if the binary does not contain.

		Given a number
		Convert the number to binary
		Find the first index for 1
		Initialize current gap value with 0
		While there is a next index for 1 after the first index
		 Get the next index for 1 after the first index
		 Calculate the gap between the first index and the next index
		 If the gap found is higher than current gap then current gap receives gap found
		 first index receives next index
		Return current gap
	 */
	static int solution(int N) {
		String binary = Integer.toBinaryString(N);
		int gap = 0;
		int index = binary.indexOf('1');
		while (nextIndexAfter(index, binary) > 0) {
			int nextIndex = nextIndexAfter(index, binary);
			int currentGap = nextIndex - (index + 1);
			if (currentGap > gap)
				gap = currentGap;
			index = nextIndex;
		}
		return gap;
	}

	private static int nextIndexAfter(final int index, final String binary) {
		return binary.indexOf('1', index + 1);
	}

}
