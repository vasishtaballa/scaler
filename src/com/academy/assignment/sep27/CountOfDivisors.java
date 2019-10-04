package com.academy.assignment.sep27;

import java.util.Arrays;

// Question: https://www.interviewbit.com/problems/count-of-divisors-for-multiple-queries/ 

public class CountOfDivisors {

	public static void main(String[] args) {
		CountOfDivisors obj = new CountOfDivisors();
		int[] array = { 2, 3, 4, 5 };
		int[] result = obj.solve(array);
		System.out.println(Arrays.toString(result));
	}

	public int[] solve(int[] A) {
		int[] factors = new int[1000001];
		int[] counts = new int[A.length];
		factors[0] = 1;
		factors[1] = 1;
		for (int i = 2; i < 1000001; i++)
			factors[i] = 2;
		for (int i = 2; i < 1000001; i++) {
			for (int j = i + i; j < 1000001; j += i)
				factors[j] += 1;
		}
		for (int i = 0; i < A.length; i++)
			counts[i] = factors[A[i]];
		return counts;
	}
}
