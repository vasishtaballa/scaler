package com.academy.assignment.sep25;

// Question: Find GCD of 2 numbers

public class GreatestCommonDivisor {
	public static void main(String[] args) {
		GreatestCommonDivisor obj = new GreatestCommonDivisor();
		System.out.println(obj.gcd(23, 11));
	}

	public int gcd(int A, int B) {
		if (A < B)
			return gcdUtil(A, B);
		return gcdUtil(B, A);
	}

	public int gcdUtil(int A, int B) {
		if (A == 0)
			return B;
		return gcdUtil(B % A, A);
	}
}
