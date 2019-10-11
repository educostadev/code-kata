import java.util.*;
import java.lang.*;
import static java.lang.System.out;

//Given an array of number find if there is a pair which the sum is equals to the given expected sum
//Input: Array of numbers and a expected sum
//Output: True or False
//Take from: (Google Interview) 
// https://www.youtube.com/watch?v=XKu_SEDAykw&list=WL&index=2&t=154s
// https://www.youtube.com/watch?v=6ZZX9iIgFoo
public class PairSum {

    // Considering the array is unsorted
    // For each i from 0 to input.lengt-1
    // |For each j from 0 to input.lengt-1
    // | if input[i]+input[j]==sumExpected then return true
    // Return false;
    // Time complexity: O(n^2)
    static boolean hasPairBruteForceSolution(int[] input, int sumExpected) {
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input.length; j++) {
                if (i == j)
                    continue;

                if (input[i] + input[j] == sumExpected)
                    return true;
            }
        }
        return false;
    }

    // Considering the array is sorted
    // Transverse the input array starting at i= 0
    // Transerver the input array starting at j=index+1
    // Check if sum of input[i] is equals to input[j] then return true
    // Return false if any value is voud
    // Time complexibility O(n^2)
    static boolean hasPairBruteForceUsingSortedArray(int[] input, int sumExpected) {
        for (int i = 0; i < input.length; i++) {
            for (int j = i + 1; j < input.length; j++) {
                if (input[i] + input[j] == sumExpected)
                    return true;
            }
        }
        return false;
    }

    // Initialize a Map with Number -> boolean (true if the number is repeated)
    // For each number in input
    // |add number in the Map (true if the number is repeated, false otherwise)
    // For each number in input
    // |Initialize numberToFind with sumExpected-number
    // |Check if
    // ||numbers contains numberToFind AND number is not equals to number to find
    // ||numbers contains numberToFind AND number is repeated
    // ||then return true
    // Return false
    // Time Complexibility O(n)
    static boolean hasPairUsingMap(int[] input, int sumExpected) {
        Map<Integer, Boolean> numbers = new HashMap<>();
        for (Integer number : input) {
            if (numbers.putIfAbsent(number, Boolean.FALSE) != null)
                numbers.put(number, Boolean.TRUE);
        }
        for (int number : input) {
            int numberToFind = sumExpected - number;
            if (numbers.get(numberToFind) != null
                    && (number != numberToFind || Boolean.TRUE.equals(numbers.get(numberToFind))))
                return true;
        }
        return false;
    }

    // Good Solution
    // Time complexibility: O(n)
    // Input array should be sorted
    // Description: Create a lower and higher index abd compare if the sum of the pair is equal
    // the sum you are looking for. When the sum is lower increase the lowerIndex and when the sum 
    // is higher decrease the higher index. Move both index until they meet each other. 
    //
    // Initilize a lowerIndex with 0
    // Initilize a higherIndex with input.lenght-1
    // Move both index While lowerIndex != higherIndex
    // |Calculate sum = input[lowerNumber] + input[HigherNumber]
    // |Check If sum == sumExpected then return true
    // |else check If sum > sumExpected then higerIndex--
    // |else check if sum < sumExpected lowerIndex++
    // Return false
    static boolean hasPairUsingThePairSolutionUsingSortedArray(int[] input, int sumExpected) {
        int lowerIndex = 0;
        int higherIndex = input.length - 1;
        while (lowerIndex != higherIndex) {
            int sum = input[lowerIndex] + input[higherIndex];
            if (sum == sumExpected)
                return true;
            else if (sum > sumExpected)
                higherIndex--;
            else if (sum < sumExpected)
                lowerIndex++;
        }
        return false;
    }

    // Best Solution
    // Time Complexibility: O(n)
    // Input array can be unordered 
    // Description: Crate a buffer to hold the numbers already visited and 
    // for each interation check if the complement necessary is in the buffer.
    //
    // Initialize a Set buffer
    // For each number in the input
    // |Calculate the complement = sumExpected-number
    // |Check if buffer.contains(complement) then return true
    // |else buffer.add(number)
    // Return false
    static boolean hasPairUsingBufferSolution(int[] input, int sumExpected) {
        Set<Integer> buffer = new HashSet<>();
        for (Integer number : input) {
            int complement = sumExpected - number;
            if (buffer.contains(complement))
                return true;
            buffer.add(number);
        }
        return false;
    }

    public static void main(String[] args) {
        // unsorted array
        assertEquals(hasPairBruteForceSolution(new int[] { 9, 3, 2, 1 }, 8), false);
        assertEquals(hasPairBruteForceSolution(new int[] { 1, 2, 3, 9 }, 8), false);
        assertEquals(hasPairBruteForceSolution(new int[] { 1, 2, 4, 10 }, 8), false);
        assertEquals(hasPairBruteForceSolution(new int[] { 5, 1, 2, 4, 4 }, 8), true);
        assertEquals(hasPairBruteForceSolution(new int[] { 1, 2, 4, 4 }, 8), true);
        // sorted array
        assertEquals(hasPairBruteForceUsingSortedArray(new int[] { 1, 2, 3, 9 }, 8), false);
        assertEquals(hasPairBruteForceUsingSortedArray(new int[] { 1, 2, 4, 4 }, 8), true);
        // solution O(n) - unsorted array
        assertEquals(hasPairUsingMap(new int[] { 9, 3, 2, 1 }, 8), false);
        assertEquals(hasPairUsingMap(new int[] { 1, 2, 3, 9 }, 8), false);
        assertEquals(hasPairUsingMap(new int[] { 1, 2, 4, 10 }, 8), false);
        assertEquals(hasPairUsingMap(new int[] { 5, 1, 2, 4, 4 }, 8), true);
        assertEquals(hasPairUsingMap(new int[] { 1, 2, 4, 4 }, 8), true);
        // solution O(n) - sorted array
        assertEquals(hasPairUsingThePairSolutionUsingSortedArray(new int[] { 1, 2, 3, 9 }, 8), false);
        assertEquals(hasPairUsingThePairSolutionUsingSortedArray(new int[] { 1, 2, 4, 10 }, 8), false);
        assertEquals(hasPairUsingThePairSolutionUsingSortedArray(new int[] { 1, 2, 4, 4 }, 8), true);
        // solution O(n) - unsorted array
        assertEquals(hasPairUsingBufferSolution(new int[] { 9, 3, 2, 1 }, 8), false);
        assertEquals(hasPairUsingBufferSolution(new int[] { 1, 2, 3, 9 }, 8), false);
        assertEquals(hasPairUsingBufferSolution(new int[] { 1, 2, 4, 10 }, 8), false);
        assertEquals(hasPairUsingBufferSolution(new int[] { 5, 1, 2, 4, 4 }, 8), true);
        assertEquals(hasPairUsingBufferSolution(new int[] { 1, 2, 4, 4 }, 8), true);
        out.println("All Passed!");
    }

    static void assertEquals(boolean value, boolean expected) {
        if (value != expected)
            throw new RuntimeException("Expected " + expected + " but was " + value);
    }
}