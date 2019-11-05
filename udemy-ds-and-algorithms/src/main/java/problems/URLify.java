package problems;

import java.util.*;
import java.lang.*;
import static java.lang.System.out;

// Write a method to replace all spaces in a string with '%20'. You may assume that the string
// has sufficient space at the end to hold the additional characters, and that you are given the "true"
// length of the string. (Note: If implementing in Java, please use a character array so that you can
// perform this operation in place.)
// Input: "Mr John Smith    ",  13
// Output: "Mr%20John%20Smith"
public class URLify {
    public static void main(String[] args) {
        String input = "Mr John Smith    ";
        out.println("Shift(" + new String(PersonalSolution.shift(1, "A BC  ".toCharArray())) + ")");
        out.println("Shift(" + new String(PersonalSolution.shift(3, "A BC  ".toCharArray())) + ")");
        out.println("(" + input + ")->(" + PersonalSolution.urlFily(input.toCharArray(), 13) + ")");
        out.println("(" + input + ")->(" + BookSolution.replaceSpaces(input.toCharArray(), 13) + ")");
    }

    static class BookSolution {
        static String replaceSpaces(char[] input, int trueLenght) {
            int spaceCount = 0;
            for (int i = 0; i < trueLenght; i++) {
                if (input[i] == ' ') {
                    spaceCount++;
                }
            }

            int index = trueLenght + spaceCount * 2;
            if (trueLenght < input.length) {
                input[trueLenght] = '\0'; // end array ?!
            }

            for (int i = trueLenght - 1; i >= 0; i--) {
                if (input[i] == ' ') {
                    input[index - 1] = '0';
                    input[index - 2] = '2';
                    input[index - 3] = '%';
                    index = index - 3;
                } else {
                    input[index - 1] = input[i];
                    index--;
                }
            }
            return new String(input);
        }
    }

    static class PersonalSolution {
        // Find the index for the last non space charactere
        // From index=lastCharIndex down to 0
        // If charactere at index is blank
        // |Shift the array starting at index
        // |add the characteres %20 starting at index
        // Return the string
        static String urlFily(char[] input, int length) {
            int lastCharIndex = findLastNonSpaceIndex(input);
            for (int index = lastCharIndex; index >= 0; index--) {
                if (isBlank(input[index])) {
                    input = shift(index, input);
                    input = add("%20".toCharArray(), input, index);
                }
            }
            return new String(input);
        }

        // To shift the array receive the start index and the array input
        // Find the index for the last non space charactere
        // From index=lastCharIndex while index >= start index
        // |Move character at index to index+2
        // |Clean charactere at index
        static char[] shift(int startIndex, char[] input) {
            int gap = 2;
            if (startIndex + gap > input.length - 1)
                throw new RuntimeException("Wont possible move " + startIndex + ", " + gap
                        + " position foward. Last position is " + (input.length - 1));

            int lastCharIndex = findLastNonSpaceIndex(input);
            for (int index = lastCharIndex; index >= startIndex; index--) {
                input[index + gap] = input[index];
                input[index] = ' ';
            }
            return input;
        }

        // To add receive the array values to add, the input to receive the values and
        // the position to start add
        // For index=0 until index < input.length
        // | Add at input[startIndex+index] the value at value[index]
        static char[] add(char[] value, char[] input, int startIndex) {
            for (int index = 0; index < value.length; index++) {
                input[startIndex + index] = value[index];
            }
            return input;
        }

        static boolean isBlank(char ch) {
            return String.valueOf(ch).trim().isEmpty();
        }

        static int findLastNonSpaceIndex(char[] input) {
            for (int index = input.length - 1; index >= 0; index--)
                if (!isBlank(input[index]))
                    return index;

            throw new RuntimeException("No letter");
        }
    }
}