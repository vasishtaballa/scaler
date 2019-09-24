package com.academy.assignment.sep23;

// Question: https://www.interviewbit.com/problems/rearrange-the-array/

public class RearrangeTheArray {
	public static void main(String[] args) {
		RearrangeTheArray obj = new RearrangeTheArray();
		int[] array = { 1, 2, 3, 4, 0 };
		array = obj.solve(array);
		System.out.println(array);
	}

	public int[] solve(int[] A) {
		for (int i = 0; i < A.length; i++)
			A[A[i] % A.length] += i * A.length;
		for (int i = 0; i < A.length; i++)
			A[i] /= A.length;
		return A;
	}
}
