package com.scaler.academy.homework.oct04;

import java.util.ArrayList;

// Question: https://www.interviewbit.com/problems/matrix-search/

public class MatrixSearch {

	public static void main(String[] args) {
		MatrixSearch obj = new MatrixSearch();
		int[][] matrixArr = { { 17, 22 }, { 27, 28 }, { 31, 33 }, { 37, 37 }, { 40, 41 }, { 41, 43 }, { 47, 49 },
				{ 60, 69 }, { 73, 74 }, { 100, 100 } };
		ArrayList<ArrayList<Integer>> matrix = obj.getArrayList(matrixArr);
		System.out.println(obj.searchMatrix(matrix, 50));
	}

	public int searchMatrix(ArrayList<ArrayList<Integer>> a, int b) {
		int row = getRow(a, b);
		int column = binarySearch(a.get(row), 0, a.get(row).size() - 1, b);
		if (row != -1 && column != -1)
			return 1;
		return 0;
	}

	public int getRow(ArrayList<ArrayList<Integer>> a, int b) {
		int low = 0, high = a.size() - 1, columns = a.get(0).size();
		while (low < high) {
			int mid = low + (high - low) / 2;
			if (a.get(mid).get(columns - 1) >= b && a.get(mid).get(0) <= b)
				return mid;
			else if (a.get(mid).get(columns - 1) > b)
				high = mid - 1;
			else
				low = mid + 1;
		}
		return low;
	}

	public int binarySearch(ArrayList<Integer> list, int low, int high, int key) {
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (list.get(mid) == key)
				return mid;
			else if (list.get(mid) < key)
				low = mid + 1;
			else
				high = mid - 1;
		}
		return -1;
	}

	private ArrayList<ArrayList<Integer>> getArrayList(int[][] matrix) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < matrix.length; i++) {
			ArrayList<Integer> row = new ArrayList<>();
			for (int j = 0; j < matrix[i].length; j++)
				row.add(matrix[i][j]);
			result.add(row);
		}
		return result;
	}

}
