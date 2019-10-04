package com.academy.assignment.sep27;

// Question: https://www.interviewbit.com/problems/solve-sub-sequences-and-return-or/ 

public class SolveSubsequence {

	public static void main(String[] args) {
		SolveSubsequence obj = new SolveSubsequence();
		int[] array = { 1, 2, 3 };
		System.out.println(obj.solve(array));
	}

	public int solve(int[] A) {
		int gcd = A[0];
		for (int i = 1; i < A.length; i++)
			gcd = gcd(gcd, A[i]);
		if (gcd != 1)
			return 0;
		return 1;
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
}
