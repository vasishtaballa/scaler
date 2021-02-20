package com.scaler.academy.homework.sep17;

// Question: https://www.interviewbit.com/problems/max-non-negative-subarray/
public class MaxNonNegativeSubArray {
	public static void main(String[] args) {
		MaxNonNegativeSubArray obj = new MaxNonNegativeSubArray();
		int[] array = { 0, 0, -1, 0 };
		obj.maxset(array);
	}

	public int[] maxset(int[] A) {
		int currentStart = 0, currentEnd = 0, maxStart = -1, maxEnd = -1, currentSum = 0, maxSum = Integer.MIN_VALUE;
		for (int i = currentStart; i < A.length; i++) {
			if (A[i] >= 0) {
				currentSum += A[i];
				currentEnd += 1;
				if (currentSum > maxSum) {
					maxSum = currentSum;
					maxStart = currentStart;
					maxEnd = currentEnd;
				} else if (currentSum == maxSum) {
					if (currentEnd - currentStart > maxEnd - maxStart) {
						maxStart = currentStart;
						maxEnd = currentEnd;
					}
				}
			} else {
				currentStart = i + 1;
				currentEnd = i + 1;
				currentSum = 0;
			}
		}
		int[] result = new int[maxEnd - maxStart];
		int index = 0;
		for (int i = maxStart; i < maxEnd; i++)
			result[index++] = A[i];
		return result;
	}
}
