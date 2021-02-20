package com.scaler.academy.homework.sep23;

// Question: https://www.interviewbit.com/problems/kingdom-war/ 

public class KingdomWar {

	public static void main(String[] args) {
		KingdomWar obj = new KingdomWar();
		int[][] matrix = { { -5, -4, -1 }, { -3, 2, 4 }, { 2, 5, 8 } };
		System.out.println(obj.solve(matrix));
	}

	public int solve(int[][] A) {
		int maximum = Integer.MIN_VALUE;
		int[][] suffixSum = getSuffixSum(A);
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A[0].length; j++) {
				if (suffixSum[i][j] > maximum)
					maximum = suffixSum[i][j];
			}
		}
		return maximum;
	}

	public int[][] getSuffixSum(int[][] A) {
		int rows = A.length - 1, columns = A[0].length - 1;
		int[][] suffixSum = new int[rows + 1][columns + 1];
		for (int i = rows; i > -1; i--) {
			suffixSum[i][columns] = A[i][columns];
			for (int j = columns - 1; j > -1; j--)
				suffixSum[i][j] = suffixSum[i][j + 1] + A[i][j];
		}
		for (int j = 0; j <= columns; j++) {
			for (int i = rows - 1; i > -1; i--) {
				suffixSum[i][j] = suffixSum[i + 1][j] + suffixSum[i][j];
			}
		}
		return suffixSum;
	}

}
