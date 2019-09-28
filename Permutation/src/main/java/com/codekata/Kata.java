package com.codekata;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/*
p(..)= permutation of ...
P(ABC)  ABC		A+P(BC)		AB+P(C)		ABC+P()
		ACB					AC+P(B)		ACB+P()
		BCA
		BAC
		CAB
		CBA

 */
public class Kata {

	private List<String> permutations = new ArrayList<>();

	static String perform(String input) {
		return new Kata().permutation("", input).stream().collect(Collectors.joining(" "));
	}

	private List<String> permutation(String fixed, String unfixed) {

		if (unfixed.length() == 0) {
			permutations.add(fixed);
		} else {
			for (int i = 0; i < unfixed.length(); i++) {
				String newFixed = fixed + unfixed.charAt(i);
				String newUnfixed = unfixed.substring(0, i) + unfixed.substring(i + 1);
				permutation(newFixed, newUnfixed);
			}
		}
		return permutations;
	}

}
