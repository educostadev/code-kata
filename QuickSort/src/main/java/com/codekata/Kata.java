package com.codekata;

public class Kata {

	/*
	Algorithm: Quick Sort
	Input: Non ordered array of integers
	Output: Ordered array of integers

	If array is 0 our 1 return array (Base Case)
	Pick the first element as pivot
	Split the array into one array with number lower than pivot and other higher the pivot
	Call quicksort on the lower array join with pivot number and joing with the quicksort on the higher array

	 */
	static Integer[] perform(Integer[] input) {

		if (input.length < 2) {
			return input;
		}
		int pivot = input[0];
		Integer[] lower = new Integer[0];
		Integer[] higher = new Integer[0];
		for (int i = 1; i < input.length; i++) {
			if (input[i] < pivot) {
				lower = addOnTheEnd(lower, input[i]);
			} else {
				higher = addOnTheEnd(higher, input[i]);
			}
		}
		return joinArray(perform(lower), pivot, perform(higher));

	}

	private static Integer[] joinArray(final Integer[] lower, final int pivot, final Integer[] higher) {
		Integer[] value = new Integer[lower.length + higher.length + 1];
		for (int i = 0; i < lower.length; i++)
			value[i] = lower[i];

		value[lower.length] = pivot;

		for (int i = 0; i < higher.length; i++)
			value[i + lower.length + 1] = higher[i];

		return value;
	}

	static Integer[] addOnTheEnd(Integer[] input, int pivot) {
		Integer[] tmpLower = new Integer[input.length + 1];
		tmpLower[input.length] = pivot;
		for (int x = 0; x < input.length; x++)
			tmpLower[x] = input[x];
		return tmpLower;
	}
}
