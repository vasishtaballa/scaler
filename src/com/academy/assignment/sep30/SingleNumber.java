package com.academy.assignment.sep30;

// Question: https://www.interviewbit.com/problems/single-number/ 

public class SingleNumber {

	public static void main(String[] args) {
		SingleNumber obj = new SingleNumber();
		int[] array = { 1, 2, 2, 3, 1 };
		System.out.println(obj.singleNumber(array));
	}

	public int singleNumber(final int[] A) {
		int xor = A[0];
		for (int i = 1; i < A.length; i++)
			xor ^= A[i];
		return xor;
	}
}
