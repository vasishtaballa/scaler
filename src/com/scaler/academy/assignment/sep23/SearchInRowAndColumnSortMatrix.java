package com.scaler.academy.assignment.sep23;

// Question: https://www.interviewbit.com/problems/search-in-a-row-wise-and-column-wise-sorted-matrix/ 

public class SearchInRowAndColumnSortMatrix {
	public static void main(String[] args) {
		SearchInRowAndColumnSortMatrix obj = new SearchInRowAndColumnSortMatrix();
		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		System.out.println(obj.solve(matrix, 2));
	}

	public int solve(int[][] A, int B) {
		int i = 0, j = A[0].length - 1;
		boolean found = false;
		while (i < A.length && j > -1) {
			if (A[i][j] < B)
				i += 1;
			else if (A[i][j] > B)
				j -= 1;
			else {
				found = true;
				break;
			}
		}
		if (found)
			return (i + 1) * 1009 + j + 1;
		else
			return -1;
	}
}
