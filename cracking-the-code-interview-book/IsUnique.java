import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/*
1.1 - From book Cracking code Interview
Is Unique:  
Implement an algorithm to determine if a string has all unique characters. 
What if you cannot use additional data structures?
Hints: #44,  #7 7  7,  #732
*/
public class IsUnique {


    //Book Solution
    //Time Complexibility: O(n)
    //Assumption: The input string is a sequence os ASCII characteres. 
    //Description: Create a boolean array of length 128 wich is on position for each ASCII charactere 
    //For each charactere check is the value is true in the char position and return that the sequence
    //is not unique, othersie add true in the position.
    //
    //The max unique character lenght is 128 so return false if the sequence is higher
    //Create a boolean exists array of 128 position
    //For each charactere in the sequence
    //|Check if the exists array at position of charactere is true then return the sequence is not unique
    //|othersise add true on exists array at charactere positon
    //Return true  
    boolean isUniqueBookSolution(String sequence) {

        if (sequence.length() > 128)
            return false;

        boolean exists[] = new boolean[128];
        for (char charactere : sequence.toCharArray()) {
            if (exists[charactere] == true) {
                return false;
            }
            exists[charactere] = true;
        }
        return true;

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
}