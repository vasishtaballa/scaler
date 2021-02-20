package com.scaler.academy.assignment.sep30;

import java.util.Arrays;

// Question: https://www.interviewbit.com/problems/min-xor-value/

public class MinimumXOR {

	public static void main(String[] args) {
		MinimumXOR obj = new MinimumXOR();
		int[] array = { 0, 2, 5, 7 };
		System.out.println(obj.findMinXor(array));
	}

	public int findMinXor(int[] A) {
		Arrays.sort(A);
		int minimumXor = Integer.MAX_VALUE;
		for (int i = 0; i < A.length - 1; i++) {
			int currentXor = A[i] ^ A[i + 1];
			if (currentXor < minimumXor)
				minimumXor = currentXor;
		}
		return minimumXor;
	}

}
