package com.codekata;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Kata {

	static char firstNotRepeatingCharacter(String s) {
		Set<Character> allLetters = new HashSet<>();
		List<Character> uniqueLettersOrdered = new ArrayList<>();
		for (Character ch : s.toCharArray()) {
			if (allLetters.contains(ch)) {
				if (uniqueLettersOrdered.contains(ch)) {
					uniqueLettersOrdered.remove(ch);
				}
			} else {
				allLetters.add(ch);
				uniqueLettersOrdered.add(ch);
			}
		}
		return uniqueLettersOrdered.isEmpty() ? '_' : uniqueLettersOrdered.get(0);
	}

}
