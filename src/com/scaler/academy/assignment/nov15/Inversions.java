package com.scaler.academy.assignment.nov15;

// Question: https://www.interviewbit.com/problems/inversions/

public class Inversions {

	int count = 0;

	public static void main(String[] args) {
		Inversions obj = new Inversions();
		int[] array = { 2, 4, 1, 3, 5 };
		System.out.println(obj.countInversions(array));
	}

	public int countInversions(int[] A) {
		divideArray(A, 0, A.length - 1);
		return count;
	}

	private void divideArray(int[] array, int low, int high) {
		if (low < high) {
			int mid = low + (high - low) / 2;
			divideArray(array, low, mid);
			divideArray(array, mid + 1, high);
			combineArray(array, low, high, mid);
		}
	}

	private void combineArray(int[] array, int low, int high, int mid) {
		int[] left = new int[mid - low + 1];
		int[] right = new int[high - mid];
		for (int i = 0; i < left.length; i++)
			left[i] = array[i + low];
		for (int j = 0; j < right.length; j++)
			right[j] = array[mid + j + 1];
		int i = 0, j = 0, k = low;
		while (i < left.length && j < right.length) {
			if (left[i] <= right[j]) {
				array[k++] = left[i];
				i++;
			} else {
				array[k++] = right[j];
				j++;
				count += left.length - i;
			}
		}

		while (i < left.length)
			array[k++] = left[i++];
		while (j < right.length)
			array[k++] = right[j++];
	}

}
