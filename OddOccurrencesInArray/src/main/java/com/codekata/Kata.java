package com.codekata;

import java.util.HashSet;
import java.util.Set;

public class Kata {

	/*
	Input: Array of integers
	Solution: Find the unpared element
	Output: Value of the unpared element

	Given an array of numbers
	Create an unpairedItem
	For each number in numbers
	If the number is into unpairedItem remove it otherwise add it
	In the end return the first item in unpaireds or -1 when empty
	 */
	static int perform(Integer[] numbers) {
		Set<Integer> unpairedItem = new HashSet<>();
		for (Integer number : numbers) {
			if (!unpairedItem.remove(number)) {
				unpairedItem.add(number);
			}
		}
		return unpairedItem.isEmpty() ? -1 : unpairedItem.iterator().next();
	}
}
