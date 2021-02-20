package com.scaler.academy.assignment.sep23;

// Question: https://www.interviewbit.com/problems/sum-of-all-submatrices/

public class SumOfAllSubmatrices {
	public static void main(String[] args) {
		SumOfAllSubmatrices obj = new SumOfAllSubmatrices();
		int[][] matrix = { { 1, 2 }, { 3, 7 } };
		System.out.println(obj.solve(matrix));
	}

	/*
	 * The idea is to find the contribution that each and every cell is giving in
	 * all sub- matrices. That can be found by considering number of cells that are
	 * present in top- left region of it and bottom right region of it
	 */
	public int solve(int[][] A) {
		int result = 0;
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A[i].length; j++) {
				int totalTopLeftCells = (i + 1) * (j + 1);
				int totalBottomRightCells = (A.length - i) * (A[i].length - j);
				result += A[i][j] * totalTopLeftCells * totalBottomRightCells;
			}
		}
		return result;
	}
}
