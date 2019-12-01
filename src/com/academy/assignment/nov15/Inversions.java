package com.academy.assignment.nov15;

// Question: https://www.interviewbit.com/problems/inversions/

public class Inversions {

	public static void main(String[] args) {
		Inversions obj = new Inversions();
		int[] array = { 2, 4, 1, 3, 5 };
		System.out.println(obj.countInversions(array));
	}

	public int countInversions(int[] A) {
		// mergeSortUtil(A, 0, A.length - 1, 0);
		return 1;
	}

	private void mergeSortUtil(int[] array, int low, int high) {
		if (high < low)
			return;
		int mid = low + (high - low) / 2;
		mergeSortUtil(array, low, mid - 1);
		mergeUtil(array, low, high);
		mergeSortUtil(array, mid + 1, high);
	}

	private void mergeUtil(int[] array, int low, int high) {

	}

}
