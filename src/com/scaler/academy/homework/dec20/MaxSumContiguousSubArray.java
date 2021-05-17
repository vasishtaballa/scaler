package com.scaler.academy.homework.dec20;

// Question: https://www.interviewbit.com/problems/max-sum-contiguous-subarray/

public class MaxSumContiguousSubArray {
	public static void main(String[] args) {
		MaxSumContiguousSubArray obj = new MaxSumContiguousSubArray();
		int[] A = { 1, 2, 3, 4, -10 };
		obj.maxSubArray(A);
	}

	/*
	 * Idea is to observe each and every element and add all continuous positive
	 * element's sum and update maxSum. If any negative values comes in sum, we can
	 * truncate because any other self individual number can be already considered
	 * as maximum
	 */
	public int maxSubArray(final int[] A) {
		int currentMax = 0, maximumSum = Integer.MIN_VALUE;
		for (int i = 0; i < A.length; i++) {
			currentMax += A[i];
			if (currentMax > maximumSum)
				maximumSum = currentMax;
			if (currentMax < 0)
				currentMax = 0;
		}
		return maximumSum;
	}
}
