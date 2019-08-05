package com.codekata;

import java.util.ArrayList;
import java.util.List;

class Solution {

	static int solution(int N) {
		//Binary gap: A sequence of 0 surronded by 1
		//INPUT: A positive integer
		//OUTPUT: The length of the longest binary gap. Zero if N does not contain

		//Convert Integer N to Binary
		//Count the length of binary gaps
		//Get the index of the first 1
		//While there is a next 1 after the index
		//get the next index of 1 after the index
		//calculate and store the length between the first and the next index
		//Update the index to the next index value
		//Return the longest offset stored

		List<Integer> offSets = new ArrayList<>();
		String binary = Integer.toBinaryString(N);
		int index = binary.indexOf('1');
		while (nextIndexAfter(index, binary) > 0) {
			int nextIndex = nextIndexAfter(index, binary);
			offSets.add(nextIndex - (index + 1));
			index = nextIndex;
		}
		return offSets.stream().max(Integer::compareTo).orElse(0);
	}

	private static int nextIndexAfter(final int index, final String binary) {
		return binary.indexOf('1', index + 1);
	}



}
