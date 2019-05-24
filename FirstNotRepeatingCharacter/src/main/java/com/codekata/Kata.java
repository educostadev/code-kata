package com.codekata;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Kata {

	static char firstNotRepeatingCharacter(String s) {

		Set<Character> letters = new HashSet<>();
		List<Character> uniqueLettersOrdered = new ArrayList<>();
		Set<Character> uniqueLetters = new HashSet<>();
		for (Character ch : s.toCharArray()) {
			if (letters.contains(ch)) {
				if (uniqueLetters.contains(ch)) {
					uniqueLettersOrdered.remove(ch);
				}
			} else {
				letters.add(ch);
				uniqueLettersOrdered.add(ch);
				uniqueLetters.add(ch);
			}
		}

		return uniqueLettersOrdered.isEmpty() ? '_' : uniqueLettersOrdered.get(0);
	}

}
