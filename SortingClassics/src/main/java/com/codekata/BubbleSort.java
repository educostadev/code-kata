package com.codekata;


public class BubbleSort implements Solution {

    @Override
    public int[] solve(int[] input) {
        int sortedUntil = input.length - 1;
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < sortedUntil; i++) {
                var leftValue = input[i];
                var rightValue = input[i + 1];
                if (leftValue > rightValue) {
                    input[i + 1] = leftValue;
                    input[i] = rightValue;
                    sorted = false;
                }
            }
            sortedUntil--;
        }
        return input;
    }

}
