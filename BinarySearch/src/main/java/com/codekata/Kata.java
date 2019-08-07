package com.codekata;

public class Kata {

	/**
	 * Set a lower value to the first index
	 * Set a higher value to the last index
	 * While lower <= higher
	 * * Set midleIndex to the lenght between lower and higher divided by 2
	 * * Get the guessValue at array position midleIndex
	 * * If the guessValue > findValue then higher receives midleIndex - 1
	 * * If the guessValue < findValue then lower receives midleIndex + 1
	 * * Else found the value and should return midle
	 * Not found the value and should return -1
	 */
	static int perform(Integer[] input, int find) {
		int lower = 0;
		int higher = input.length - 1;
		while (lower <= higher) {
			int mid = (lower + higher) / 2;
			int guess = input[mid];
			if (guess > find)
				higher = mid - 1;
			else if (guess < find)
				lower = mid + 1;
			else
				return mid;
		}
		return -1;
	}
}
