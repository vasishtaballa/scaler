package com.academy.assignment.oct07;

import java.util.Arrays;

// Question: https://www.interviewbit.com/problems/matrix-median/
public class MatrixMedian {
	public static void main(String[] args) {
		MatrixMedian obj = new MatrixMedian();
		int[][] matrix = { { 1, 3, 5 }, { 2, 6, 9 }, { 3, 6, 9 } };
		System.out.println(obj.findMedian(matrix));
	}

	public int findMedian(int[][] A) {
		int minimum = Integer.MAX_VALUE, maximum = Integer.MIN_VALUE, rows = A.length, columns = A[0].length;
		int position = (rows * columns + 1) / 2;
		for (int i = 0; i < A.length; i++) {
			minimum = Math.min(minimum, A[i][0]);
			maximum = Math.max(maximum, A[i][columns - 1]);
		}
		while (minimum < maximum) {
			int mid = minimum + (maximum - minimum) / 2;
			int index = 0;
			int place = 0;
			for (int i = 0; i < rows; i++) {
				index = Arrays.binarySearch(A[i], mid);
				if (index < 0)
					index = Math.abs(index) - 1;
				else {
					while (index < A[i].length && A[i][index] == mid)
						index += 1;
				}
				place += index;
			}
			if (place < position)
				minimum = mid + 1;
			else
				maximum = mid;
		}
		return minimum;
	}
}
