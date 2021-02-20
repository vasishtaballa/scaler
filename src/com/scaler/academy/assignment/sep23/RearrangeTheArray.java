package com.scaler.academy.assignment.sep23;

// Question: https://www.interviewbit.com/problems/rearrange-the-array/

public class RearrangeTheArray {
	public static void main(String[] args) {
		RearrangeTheArray obj = new RearrangeTheArray();
		int[] array = { 2, 0, 1, 3 };
		array = obj.solve(array);
		System.out.println(array);
	}

	public int[] solve(int[] A) {
		for (int i = 0; i < A.length; i++)
			A[i] += 1;
		for (int i = 0; i < A.length; i++) {
			if (A[i] > 0)
				rearrangeArray(i, A);
		}
		for (int i = 0; i < A.length; i++) {
			A[i] = -A[i] - 1;
		}
		return A;
	}

	public void rearrangeArray(int index, int[] A) {
		int value = -index - 1;
		index = A[index] - 1;
		while (A[index] > 0) {
			int newValue = A[index] - 1;
			A[index] = value;
			value = -index - 1;
			index = newValue;
		}
	}
}
