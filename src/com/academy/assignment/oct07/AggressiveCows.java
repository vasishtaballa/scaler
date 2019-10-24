package com.academy.assignment.oct07;

import java.util.Arrays;

// Question: https://www.interviewbit.com/problems/aggressive-cows/

public class AggressiveCows {

	public static void main(String[] args) {
		AggressiveCows obj = new AggressiveCows();
		int[] array = { 1, 2, 4, 8, 9 };
		System.out.println(obj.solve(array, 3));
	}

	public int solve(int[] A, int B) {
		Arrays.sort(A);
		int high = A[A.length - 1], low = 1, mid = 0, ans = 0;
		while (low <= high) {
			mid = low + (high - low) / 2;
			if (isArrangementPossible(A, mid, B)) {
				low = mid + 1;
				ans = mid;
			} else
				high = mid - 1;
		}
		return ans;
	}

	public boolean isArrangementPossible(int[] A, int distance, int cows) {
		int count = 1, index = A[0];
		for (int i = 1; i < A.length; i++) {
			if (A[i] - index >= distance) {
				count += 1;
				index = A[i];
				if (count == cows)
					return true;
			}
		}
		return false;
	}

}
