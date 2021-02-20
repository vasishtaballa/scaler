package com.scaler.academy.homework.sep25;

import java.util.Arrays;

// Question: https://www.interviewbit.com/problems/all-gcd-pair/

public class AllGCDPair {

	public static void main(String[] args) {
		AllGCDPair obj = new AllGCDPair();
		int[] array = { 46, 1, 2, 1, 1, 1, 45, 5, 1, 1, 2, 5, 40, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 31 };
		System.out.println(obj.solve(array));
	}

	public int[] solve(int[] A) {
		Arrays.sort(A);
		reverseArray(A);
		int[] result = new int[(int) Math.sqrt(A.length)];
		int[] frequency = new int[A[0] + 1];
		int index = 0;
		// Counting the frequency of each number
		for (int i = 0; i < A.length; i++)
			frequency[A[i]] += 1;
		for (int i = 0; i < A.length; i++) {
			if (frequency[A[i]] != 0 && index < result.length) {
				result[index++] = A[i];
				frequency[A[i]] -= 1;
				for (int j = 0; j < index; j++) {
					if (i != j) {
						int gcd = gcd(A[i], result[j]);
						frequency[gcd] -= 2;
					}
				}
			}
		}
		return result;
	}

	public int gcd(int a, int b) {
		if (a > b)
			return gcdUtil(b, a);
		return gcdUtil(a, b);
	}

	public int gcdUtil(int a, int b) {
		if (a == 0)
			return b;
		return gcdUtil(b % a, a);
	}

	public void reverseArray(int[] A) {
		for (int i = 0, j = A.length - 1; i < j; i++, j--) {
			int temp = A[i];
			A[i] = A[j];
			A[j] = temp;
		}
	}

}
