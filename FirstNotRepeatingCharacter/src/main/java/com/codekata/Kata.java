package com.codekata;

public class Kata {

	static char firstNotRepeatingCharacter(String s) {
		for (char ch : s.toCharArray())
			if (s.indexOf(ch) == s.lastIndexOf(ch))
				return ch;

		return '_';
	}

}
