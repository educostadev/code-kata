package problems;

import java.lang.*;
import java.util.*;
import static java.lang.System.out;

/**
 * Given a list of integers from the range [1, N] with some of the elements missing. 
 * The task is to find the missing elements. Note that there can be duplicates in the list.
 * 
 * Input: arr[] = {1, 3, 3, 3, 5} Output: 2 4
 *
 * Input: arr[] = {1, 2, 3, 4, 4, 7, 7}  Output: 5 6
 * 
 * Input: arr[] = {1, 2, 3, 4, 7, 4, 7}  Output: 5 6 
 * 
 * https://www.geeksforgeeks.org/find-missing-elements-from-an-array/?ref=feed
 */
public class FindMissingElementsArray {
    public static void main(String[] args) {
        int[] input;
        input = new int[]{ 1, 3, 3, 3, 5 };
        List<Integer> result = findMissingElementWhenInputIsOrdered(input);
        assertEquals(2, result.get(0));
        assertEquals(4, result.get(1));

        input = new int[] { 1, 2, 3, 4, 4, 7, 7 };
        result = findMissingElementWhenInputIsOrdered(input);
        assertEquals(5, result.get(0));
        assertEquals(6, result.get(1));
        
        input = new int[]{ 1, 3, 3, 3, 5 };
        result = findMissingElementWhenInputIsNotOrdered(input);
        assertEquals(2, result.get(0));
        assertEquals(4, result.get(1));

        input = new int[] { 1, 2, 3, 4, 7, 4, 7 };
        result = findMissingElementWhenInputIsNotOrdered(input);
        assertEquals(5, result.get(0));
        assertEquals(6, result.get(1));
        out.println("Sucess!!");

    }

    //Assumption: The input should be an ordered array
    //Interact over all the elements of the array
    //Check if the value at input[index] is not equals to index+1 then
    //Add the index+1 value in the missing list otherwise continue
    static List<Integer> findMissingElementWhenInputIsOrdered(int[] input) {
        List<Integer> missing = new ArrayList<>();
        for (int index = 0; index < input.length; index++) {
            if (input[index] != index + 1)
                ;
                missing.add(index + 1);
        }
        return missing;
    }
   
    //The input array will hava lenght of N and will be filled with values between 1 to N.
    //Create a dummy int array of lenght N 
    //Transverse the input array and add the value at input[index] in dummy array at position value-1
    //Transverse the dummy array
    //If the value at dummy[index] is Zero the missing number will be index+1 so add it to a list 
    //Return the list of missing numbers
    static List<Integer> findMissingElementWhenInputIsNotOrdered(int[] input) {
        List<Integer> missing = new ArrayList<>();
        int dummy[] = new int[input.length];
        for (int index = 0; index < input.length; index++) {
            int value = input[index];
            dummy[value - 1] = value;
        }
        for (int index = 0; index < dummy.length; index++) {
            int value = dummy[index];
            if (value == 0)
                missing.add(index + 1);
        }
        return missing;
    }

    static void assertEquals(int expected, int result) {
        if (expected != result)
            throw new RuntimeException("Expected ["+expected+"] but was ["+result+"]");
    }
}