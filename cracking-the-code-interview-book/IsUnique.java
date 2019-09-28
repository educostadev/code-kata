import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/*
1.1
Is Unique:  Implement an algorithm to determine if a string has all unique characters. What if you
cannot use additional data structures?
Hints: #44,  #7 7  7,  #732
*/
public class IsUnique {

    IsUnique() {
    }

    public static void main(String[] args) {
        IsUnique algorithm = new IsUnique();

        assertTrue(algorithm.isUniqueWithDataStructure("abc"));
        assertFalse(algorithm.isUniqueWithDataStructure("abca"));
        assertTrue(algorithm.isUniqueWithoutUseDataStructure("abc"));
        assertFalse(algorithm.isUniqueWithoutUseDataStructure("abca"));
        assertTrue(algorithm.isUniqueBookSolution("abc"));
        assertFalse(algorithm.isUniqueBookSolution("abca"));
        assertTrue(algorithm.isUnique_SoluctionWithHashSetOptimized("abc"));
        assertFalse(algorithm.isUnique_SoluctionWithHashSetOptimized("abca"));
        System.out.println("Success");
    }

    static void assertFalse(boolean result) {
        if (result != false)
            throw new RuntimeException("Expected False");
    }

    static void assertTrue(boolean result) {
        if (!result)
            throw new RuntimeException("Expected True");
    }

    boolean isUniqueWithDataStructure(String sequence) {
        // O(N)
        // Add each letter in a data structure that does not allow repetition.
        // If the original lenght != the no repetition lenght return TRUE
        HashSet<String> noRepetition = new HashSet();
        for (char ch : sequence.toCharArray())
            noRepetition.add(String.valueOf(ch));

        return sequence.length() == noRepetition.size();
    }

    boolean isUnique_SoluctionWithHashSetOptimized(String sequence) {
        // Create a empty Hashset
        // For each letter
        // Check if the letter is on hashset and return FALSE othersie go to next
        // iteration
        // Return true in the end
        HashSet<CharSequence> letters = new HashSet<>();
        for (char letter : sequence.toCharArray())
            if (!letters.add(String.valueOf(letter)))
                return false;

        return true;
    }

    boolean isUniqueWithoutUseDataStructure(String sequence) {
        // Brute force - O(N²)
        // For each letter in the string
        // Count how many times the letter is found on the same string
        // If repetition > 1 for a letter then return false otherwise go to next
        // iteration
        // return true in the end
        for (char letter : sequence.toCharArray()) {
            int repetition = 0;
            for (char nLetter : sequence.toCharArray()) {
                if (letter == nLetter)
                    repetition += 1;

                if (repetition > 1)
                    return false;
            }
        }
        return true;
    }

    boolean isUniqueBookSolution(String sequence) {
        // Assumptions: The sequence is ASCII characters. 128 character with pontuation
        // Return false if que sequence lenght is > 128 wich is the max unique
        // characters
        // Create a boolean array of the max character size to represent the character
        // exists
        // for each character
        // Get the the value from the boolean array at character index
        // If the value is true then the ch is repeted and return false otherswise add
        // true on the position
        // Return false at the end for no repetition

        if (sequence.length() > 128)
            return false;

        boolean charExists[] = new boolean[128];
        for (char ch : sequence.toCharArray()) {
            if (charExists[ch] == true) {
                return false;
            }
            charExists[ch] = true;
        }
        return true;

    }
}