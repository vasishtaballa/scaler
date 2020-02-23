package com.academy.assignment.util;

import java.util.List;

public class PrintUtility {
	public static void printArray(int[] array) {
		for (int item : array)
			System.out.print(item + " ");
	}

	public static void printArrayList(List<Object> list) {
		for (Object item : list)
			System.out.print(item + " ");
	}

	public static void printMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++)
				System.out.print(matrix[i][j] + " ");
			System.out.println();
		}
	}
}
