package problems;

import java.util.*;
import static java.lang.System.out;

// Given an unsorted array find the highest number
class FindHighestNumber {
    public static void main(String[] args) {
        int[] numbers = new int[] { 10, 1, 99, 12, 34, 123, 34, 1, 546, 8, 65, 53, 234 };
        out.println(Iteractive.find(numbers));
        out.println(Recursive.find(numbers, numbers.length - 1, -1));
    }

    // Initilize a higherNumber var with the first index number
    // For index=1 to numbers length
    // Check if higherNumber is lower than number at index then
    // higherNumber receices number at index otherwise go to next iteraction
    // Redutn the higherNumber
    static class Iteractive {
        static int find(int[] numbers) {
            int higherNumber = numbers[0];
            
            for (int index = 1; index < numbers.length; index++)
                if (higherNumber < numbers[index])
                    higherNumber = numbers[index];

            return higherNumber;
        }
    }

    // Base case: When index is -1 return the highest
    // Recursive case: First call of find with: numbers, numbers.length-1, -1
    // Sucessive calls: numbers, index-1, higest
    static class Recursive {
        static int find(int[] numbers, int index, int highest) {
            if (index == -1)
                return highest;

            if (highest < numbers[index])
                highest = numbers[index];

            return find(numbers, index - 1, highest);
        }
    }
}
