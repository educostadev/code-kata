package com.codekata;

class Solution {

	static int solution(int N) {
		//Binary gap: A sequence of 0 surronded by 1
		//INPUT: A positive integer
		//OUTPUT: The length of the longest binary gap. Zero if N does not contain

		//Get the first index for 1
		//initialize gap with 0
		//While has a nextIndex for 1 after index
		//get the nextIndex for 1 after index
		//calculate the gap between nextIndex and index
		//if currentGap is greader than gap so gap is equal to current gap
		//index not is equal to next index
		//return gap

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
