package com.academy.homework.sep23;

import java.util.Arrays;

// Question: https://www.interviewbit.com/problems/alternate-positive-and-negative-elements/

public class AlternativePositiveNegative {

	public static void main(String[] args) {
		AlternativePositiveNegative obj = new AlternativePositiveNegative();
		int[] array = { -5, 3, 4, 5, -6, -2, 8, 9, -1, -4 };
		array = obj.solve(array);
		System.out.println(Arrays.asList(array));
	}

	public int[] solve(int[] A) {
		int invalidIndex = -1;
		for (int i = 0; i < A.length; i++) {
			if (A[i] < 0 && i % 2 != 0)
				invalidIndex = i;
			else if (A[i] >= 0 && i % 2 == 0)
				invalidIndex = i;
			if (invalidIndex != -1) {
				// Check for next opposite sign to replace this index
				for (int j = invalidIndex + 1; j < A.length; j++) {
					if ((A[invalidIndex] >= 0 && A[j] < 0) || (A[invalidIndex] < 0 && A[j] >= 0)) {
						rightRotateArray(A, invalidIndex, j);
						invalidIndex = -1;
						break;
					}
				}
			}
		}
		return A;
	}

	public void rightRotateArray(int[] A, int from, int to) {
		int temp = A[to];
		for (int i = to; i > from; i--)
			A[i] = A[i - 1];
		A[from] = temp;
	}

}
