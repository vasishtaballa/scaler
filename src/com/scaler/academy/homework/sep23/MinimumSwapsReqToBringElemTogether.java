package com.scaler.academy.homework.sep23;

// Question: https://www.interviewbit.com/problems/minimum-swaps-required-to-bring-all-elements-less-than-or-equal-to-k-together/

public class MinimumSwapsReqToBringElemTogether {

	public static void main(String[] args) {
		MinimumSwapsReqToBringElemTogether obj = new MinimumSwapsReqToBringElemTogether();
		int[] array = { 5, 17, 100, 11 };
		System.out.println(obj.solve(array, 20));
	}

	public int solve(int[] A, int B) {
		int minimumCount = 0, currentMin = 0, minimumSwaps = 0;
		for (int i = 0; i < A.length; i++) {
			if (A[i] <= B)
				minimumCount += 1;
		}
		for (int i = 0; i < minimumCount; i++) {
			if (A[i] > B)
				currentMin += 1;
		}
		minimumSwaps = currentMin;
		for (int i = 0, j = minimumCount; j < A.length; i++, j++) {
			if (A[i] > B)
				currentMin -= 1;
			if (A[j] > B)
				currentMin += 1;
			minimumSwaps = currentMin < minimumSwaps ? currentMin : minimumSwaps;
		}
		return minimumSwaps;
	}

}
