import java.util.*;

public class SumRecursive {

    public static void main(String args[]) {
        int numbers[] = {1,2,3,4};
        System.out.println(SumRecursive.sum(numbers));
    }

    /**
     * Problem: Sum the elements from an array of number in a recursive way
     * 
     * 1. Base Statement: array lenght = 1 
     * 2. Reduce the Problem
     * 
     * Given an array of integers If array lenght equals to 1 return first element
     * Otherwise return first element + the sum of the following elements
     */
    static int sum(int[] numbers) {
        if (numbers.length == 1)
            return numbers[0];
        else
            return numbers[0] + sum(Arrays.copyOfRange(numbers, 1, numbers.length));
    }
}