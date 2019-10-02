package com.academy.assignment.sep27;

// Question: https://www.interviewbit.com/problems/largest-coprime-divisor/

public class LargestCoprimeDivisor {

	public static void main(String[] args) {
		LargestCoprimeDivisor obj = new LargestCoprimeDivisor();
		System.out.println(obj.cpFact(30, 12));
	}

	public int cpFact(int A, int B) {
		int gcd = gcd(A, B);
		while (gcd != 1) {
			A /= gcd;
			gcd = gcd(A, B);
		}
		return A;
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
