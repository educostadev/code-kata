package com.codekata;

public class KadaneAlgorithmSolution implements Solution {
    @Override
    public int solve(int[] input) {
        int maxGlobal = input[0];
        int maxLocal = input[0];
        for (int i = 1; i < input.length; i++) {
            int num = input[i];
            maxLocal = Math.max(num, maxLocal + num);
            maxGlobal = Math.max(maxLocal, maxGlobal);
        }
        return maxGlobal;
    }
}
