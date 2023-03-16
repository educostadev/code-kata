package com.codekata;


public class BubbleSort implements Solution {

    @Override
    public int[] solve(int[] input) {
        int sortedUntil = input.length-1;
        boolean isSorted = false;
        while(!isSorted){
            isSorted = true;
            for (int i=0; i<sortedUntil;i++){
                var numA = input[i];
                var numB = input[i+1];
                if (numA > numB){
                    input[i+1] = numA;
                    input[i] = numB;
                    isSorted = false;
                }
            }
            sortedUntil = sortedUntil-1;
        }

        return input;
    }
    
}
