package com.scaler.academy.assignment.sep23;

// Question: https://www.interviewbit.com/problems/sub-matrix-sum-queries/

public class SubMatrixSumQueries {

	public static void main(String[] args) {
		SubMatrixSumQueries obj = new SubMatrixSumQueries();
		int[][] matrix = { { 999999999, 999999999, 999999999 }, { 999999999, 999999999, 999999999 },
				{ 999999999, 999999999, 999999999 } };
		int[] B = { 1, 2 };
		int[] C = { 1, 2 };
		int[] D = { 2, 3 };
		int[] E = { 2, 3 };
		System.out.println(obj.solve(matrix, B, C, D, E));
	}

	public int[] solve(int[][] A, int[] B, int[] C, int[] D, int[] E) {
		int[][] prefixSum = prefixSumRowCol(A);
		int[] result = new int[B.length];
		int modValue = (int) (Math.pow(10, 9) + 7);
		for (int i = 0; i < B.length; i++) {
			int topLeftX = B[i] - 1, topLeftY = C[i] - 1;
			int bottomRightX = D[i] - 1, bottomRightY = E[i] - 1;
			long sum = (prefixSum[bottomRightX][bottomRightY] + modValue) % modValue;
			if (topLeftX - 1 >= 0)
				sum = (sum - prefixSum[topLeftX - 1][bottomRightY] + modValue) % modValue;
			if (topLeftY - 1 >= 0)
				sum = (sum - prefixSum[bottomRightX][topLeftY - 1] + modValue) % modValue;
			if (topLeftX - 1 >= 0 && topLeftY - 1 >= 0)
				sum = ((long) sum + (long) prefixSum[topLeftX - 1][topLeftY - 1]) % modValue;
			sum = (sum + modValue) % modValue;
			result[i] = (int) sum;
		}
		return result;
	}

	public int[][] prefixSumRowCol(int[][] A) {
		int[][] prefixSum = new int[A.length][A[0].length];
		int modValue = (int) (Math.pow(10, 9) + 7);
		for (int i = 0; i < A.length; i++) {
			prefixSum[i][0] = A[i][0] % modValue;
			for (int j = 1; j < A[0].length; j++) {
				long sum = ((long) prefixSum[i][j - 1] + (long) A[i][j]) % modValue;
				prefixSum[i][j] = (int) sum;
			}
		}
		for (int i = 0; i < A[0].length; i++) {
			for (int j = 1; j < A.length; j++) {
				long sum = ((long) prefixSum[j - 1][i] + (long) prefixSum[j][i]) % modValue;
				prefixSum[j][i] = (int) sum;
			}
		}
		return prefixSum;
	}

}
