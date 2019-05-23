package com.codekata;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class App {

	int firstDuplicate(int[] a) {
		Set<Integer> numbers = new HashSet<>();
		Map<Integer, Integer> mapIndex = new HashMap<>();
		for (int index = 0; index < a.length; index++) {
			int value = a[index];
			if (numbers.contains(value)) {
				if (!mapIndex.keySet().contains(value)) {
					mapIndex.put(value, index);
				}
			}
			numbers.add(value);
		}
		int firstDuplicate = -1;
		int firstDuplicateIndex = Integer.MAX_VALUE;
		for (Map.Entry<Integer, Integer> entry : mapIndex.entrySet()) {
			int key = entry.getKey();
			int valueIndex = entry.getValue();
			if (valueIndex < firstDuplicateIndex) {
				firstDuplicate = key;
				firstDuplicateIndex = valueIndex;
			}
		}
		return firstDuplicate;
	}

}
