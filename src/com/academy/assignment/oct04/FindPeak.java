package com.academy.assignment.oct04;

import java.util.Arrays;

// Question: https://www.interviewbit.com/problems/find-a-peak-element/

public class FindPeak {

	public static void main(String[] args) {
		FindPeak obj = new FindPeak();
		int[] array = { 1, 4, 4, 4 };
		Arrays.sort(array);
		System.out.println(obj.solve(array));
	}

	public int solve(int[] A) {
		int low = 0, high = A.length - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (mid == 0 || mid == A.length - 1)
				return A[mid] > A[A.length - 1] ? A[mid] : A[A.length - 1];
			if (A[mid] > A[mid - 1] && A[mid] > A[mid + 1])
				return A[mid];
			if (A[mid] <= A[mid + 1])
				low = mid + 1;
			else if (A[mid] >= A[mid + 1])
				high = mid - 1;
		}
		return 0;
	}

}
