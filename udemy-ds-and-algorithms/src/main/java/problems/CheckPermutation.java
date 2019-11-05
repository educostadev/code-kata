package problems;

import java.util.*;
import static java.lang.System.out;

//Check Permuation - Cracking code interview book
//Given two strings, write a method to decide if one is a permutation of the other.
//Assumptions: Case sensitive matters. Space matters. Two strings of differnet size can not be a permutation of each other.
class CheckPermutation {
    public static void main(String[] args) {
        out.println(checkPermutation("dog", "god")); // true
        out.println(checkPermutation("abc", "def")); // false
        out.println("Book solution 1");
        out.println(checkPermutationBookSolution1("dog", "god")); // true
        out.println(checkPermutationBookSolution1("abc", "def")); // false
        out.println("Book solution 2");
        out.println(checkPermutationBookSolution2("dog", "god")); // true
        out.println(checkPermutationBookSolution2("abc", "def")); // false
    }

    // If texts has different lenght return false
    // From index=0 to text lenght
    // Get from text1 the letter at index
    // Get from text2 the letter at index
    // Check if text1 does not contains letter from text 2 then return false
    // Check if text2 does not contains letter from text 1 then return false
    // Retun true in the end
    static boolean checkPermutation(String text1, String text2) {
        if (text1.length() != text2.length())
            return false;

        for (int i = 0; i < text2.length(); i++) {
            String letterText1 = String.valueOf(text1.charAt(i));
            String letterText2 = String.valueOf(text2.charAt(i));
            if (!text1.contains(letterText2) || !text2.contains(letterText1))
                return false;
        }
        return true;
    }

    // If two strings are permutations, then we know they have the same characters,
    // but in different orders. There­ fore, sorting the strings will put the
    // characters from two permutations in the same order. We just need to
    // compare the sorted versions of the strings.
    static boolean checkPermutationBookSolution1(String text1, String text2) {
        if (text1.length() != text2.length())
            return false;

        char[] text1Chars = text1.toCharArray();
        Arrays.sort(text1Chars);
        char[] text2Chars = text2.toCharArray();
        Arrays.sort(text2Chars);

        return String.valueOf(text1Chars).equals(String.valueOf(text2Chars));
    }

    // counting how many times each character appears
    static boolean checkPermutationBookSolution2(String text1, String text2) {
        if (text1.length() != text2.length())
            return false;

        int[] letterCount = new int[128]; // Assumption ASCII
        for (char letter : text1.toCharArray())
            letterCount[letter]++;

        for (char letter : text2.toCharArray()) {
            letterCount[letter]--;
            if (letterCount[letter] < 0)
                return false;
        }

        return true;
    }
}