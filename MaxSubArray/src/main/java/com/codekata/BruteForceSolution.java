package com.codekata;

public class BruteForceSolution implements Solution {
    @Override
    public int solve(int[] input) {
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < input.length; i++) {
            int currentSum = 0;
            for (int j = i; j < input.length; j++) {
                currentSum = currentSum + input[j];
                maxSum = Math.max(maxSum, currentSum);
            }
        }
        return maxSum;
    }
}
