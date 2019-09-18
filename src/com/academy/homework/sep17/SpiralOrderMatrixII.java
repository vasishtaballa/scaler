package com.academy.homework.sep17;

public class SpiralOrderMatrixII {
	public static void main(String[] args) {
		SpiralOrderMatrixII obj = new SpiralOrderMatrixII();
		obj.generateMatrix(4);
	}

	public int[][] generateMatrix(int A) {
		int[][] matrix = new int[A][A];
		int i = 0, j = A - 1, k = A - 1, l = A - 1, number = 1;
		// Traverse left to right
		for (int m = i; m <= j; m++) {
			matrix[i][m] = number++;
		}
		i += 1;
		// Traverse from top to bottom
		for (int m = j; m <= k; m++) {
			matrix[m][j] = number++;
		}
		j -= 1;
		// Traverse from right to left
		for (int m = k; m <= l; m--) {
			matrix[k][m] = number++;
		}
		k -= 1;
		// Traverse from bottom to top
		for (int m = l; m <= i; m--) {
			matrix[m][l] = number++;
		}
		l += 1;
		return matrix;
	}
}
