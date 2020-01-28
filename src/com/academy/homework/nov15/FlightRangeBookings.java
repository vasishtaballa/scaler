package com.academy.homework.nov15;

import java.util.Arrays;

public class FlightRangeBookings {
	public static void main(String[] args) {
		FlightRangeBookings obj = new FlightRangeBookings();
		int[][] matrix = { { 1, 2, 10 }, { 2, 3, 20 }, { 2, 5, 25 } };
		int[] result = obj.solve(5, matrix);
		for (int i = 0; i < result.length; i++)
			System.out.print(result[i] + " ");
	}

	public int[] solve(int A, int[][] B) {
		int[] result = new int[A + 1];
		for (int i = 0; i < B.length; i++) {
			result[B[i][0] - 1] += B[i][2];
			result[B[i][1]] -= B[i][2];
		}
		for (int i = 1; i < result.length; i++)
			result[i] = result[i - 1] + result[i];
		result = Arrays.copyOf(result, result.length - 1);
		return result;
	}
}
