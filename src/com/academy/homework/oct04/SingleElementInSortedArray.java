package com.academy.homework.oct04;

// Question: https://www.interviewbit.com/problems/single-element-in-a-sorted-array/
public class SingleElementInSortedArray {

	public static void main(String[] args) {
		SingleElementInSortedArray obj = new SingleElementInSortedArray();
		int[] array = { 1, 1, 2, 3, 3 };
		System.out.println(obj.solve(array));
	}

	public int solve(int[] A) {
		int low = 0, high = A.length - 1;
		while (low <= high) {
			if (low == high)
				return A[low];
			int mid = low + (high - low) / 2;
			if (mid % 2 == 0) {
				if (A[mid] == A[mid + 1])
					low = mid + 2;
				else
					high = mid;
			} else {
				if (A[mid] == A[mid - 1])
					low = mid + 1;
				else
					high = mid - 1;
			}
		}
		return -1;
	}

}
