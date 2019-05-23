package com.codekata;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class App {

	int firstDuplicate(int[] a) {
		Set<Integer> values = new HashSet<>();
		Map<Integer, Integer> mapDuplicateNumberIndex = new HashMap<>();
		for (int index = 0; index < a.length; index++) {
			int value = a[index];
			if (!mapDuplicateNumberIndex.keySet().contains(value) && values.contains(value)) {
				mapDuplicateNumberIndex.put(value, index);
			}
			values.add(value);
		}

		return findValueWithLowerIndex(mapDuplicateNumberIndex);
	}

	private int findValueWithLowerIndex(Map<Integer, Integer> mapDuplicateNumberIndex) {
		int firstDuplicateValue = -1;
		int firstDuplicateIndex = Integer.MAX_VALUE;
		for (Map.Entry<Integer, Integer> entry : mapDuplicateNumberIndex.entrySet()) {
			int value = entry.getKey();
			int index = entry.getValue();
			if (index < firstDuplicateIndex) {
				firstDuplicateValue = value;
				firstDuplicateIndex = index;
			}
		}
		return firstDuplicateValue;
	}

}
