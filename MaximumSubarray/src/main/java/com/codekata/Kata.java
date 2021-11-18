package com.codekata;

/*
  Maximum Subarray: Dado um array de inteiro retorne a maior soma de seu subarray.
*/
public class Kata {

	/* Pseudocode:
		Para cada indice do array use-o como indice inicial para uma iteração aninhada. 
		Na iteração aninhada some todos os elementos do array e guarde o Max entre a soma anterior e soma atual.
		Após iterado por todos os elementos retorne a soma armazenada
	*/
	static int bruteForceApproach(int[] nums){

		int maxSum = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length; i++) {
			int currentSum = 0;
			for (int j = i; j < nums.length; j++) {
				currentSum = currentSum + nums[j]; 
				maxSum = Math.max(maxSum,currentSum);
			}
		}
		return maxSum;
	}
}
