package com.codekata;

import java.util.HashSet;
import java.util.Set;

public class App {

	int firstDuplicate(int[] array) {
		Set<Integer> values = new HashSet<>();
		for (int value: array) {
			if (values.contains(value))
				return value;

			values.add(value);
		}
		return -1;
	}
}
