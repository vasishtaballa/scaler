package com.scaler.academy.homework.sep23;

// Question: https://www.interviewbit.com/problems/max-chunks-to-make-sorted/ 

public class MaxChunksToMakeSorted {

	public static void main(String[] args) {
		MaxChunksToMakeSorted obj = new MaxChunksToMakeSorted();
		int[] array = { 2, 0, 1, 3 };
		System.out.println(obj.solve(array));
	}

	public int solve(int[] A) {
		// Take ideal example 0 1 2 3 4 5 to understand better.
		int maximum = 0, count = 0;
		for (int i = 0; i < A.length; i++) {
			if (A[i] > maximum)
				maximum = A[i];
			if (i == maximum)
				count += 1;
		}
		return count;
	}

}
