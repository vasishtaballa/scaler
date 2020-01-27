package com.academy.homework.nov15;

import java.util.Arrays;

// Question: https://www.geeksforgeeks.org/find-sum-maximum-difference-possible-subset-given-array/

public class SumTheDifference {
	public static void main(String[] args) {
		SumTheDifference obj = new SumTheDifference();
		int[] array = { 1, 2, 3, 4 };
		System.out.println(obj.solve(array));
	}

	public int solve(int[] A) {
		Arrays.sort(A);
		long minSum = 0, maxSum = 0, modValue = 1000000007;
		for (int i = 0; i < A.length; i++) {
			maxSum = 2 * maxSum + A[A.length - i - 1];
			maxSum %= modValue;
			minSum = 2 * minSum + A[i];
			minSum %= modValue;
		}
		return (int) (Math.abs(maxSum - minSum) % modValue);
	}
}
