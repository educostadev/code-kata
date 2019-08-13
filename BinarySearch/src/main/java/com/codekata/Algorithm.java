package com.codekata;

import java.util.Arrays;

class Algorithm {

	/*
	  Problem: Binary search - non recursive approache
	  Input: Array of integers, value to find
	  Output: Index of the found value or -1

	  Given a value to find and an ordered array of integer as input
	  Set lower value to the first index
	  Set higher value to the last index
	  While lower <= higher
	  * Set midleIndex to the lenght between lower and higher divided by 2
	  * Get the guessValue at array position midleIndex
	  * If the guessValue > valueFind then higher receives midleIndex - 1
	  * If the guessValue < valueFind then lower receives midleIndex + 1
	  * Otherwise found the value and should return midleIndex
	  Not found the value and should return -1
	 */
	static int search_non_recursive(Integer[] input, int find) {
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

	/*
	Problem: Binary search - recursive aproach

	Base case: If array has length 1 then return the first element

	Given a value to find and an ordered array of integer as input
	If array has lenght 0 then return -1 (base case)
	Otherwise calculate the midle index
	Get the guess value from the array at midle index
	If guess value is higher than number to find then search by array from index 0 to midle index
	If guess value is lower  than number to find then search by array from midlex index + 1 to array lenght
	Otherwise return midle index

	 */
	static int search_recursive(Integer[] input, int find) {
		if (input.length == 0) {
			return -1;
		}
		int midle = input.length / 2;
		int guess = input[midle];
		if (guess > find) {
			return search_recursive(Arrays.copyOfRange(input, 0, midle), find);
		} else if (guess < find) {
			return search_recursive(Arrays.copyOfRange(input, midle + 1, input.length), find);
		} else {
			return midle;
		}

	}
}
