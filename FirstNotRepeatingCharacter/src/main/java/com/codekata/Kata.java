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
			if (allLetters.add(ch)){
				uniqueLettersOrdered.add(ch); //isUnique
			}else{
				uniqueLettersOrdered.remove(ch); //isRepeated
			}
		}
		return uniqueLettersOrdered.isEmpty() ? '_' : uniqueLettersOrdered.get(0);
	}

}
