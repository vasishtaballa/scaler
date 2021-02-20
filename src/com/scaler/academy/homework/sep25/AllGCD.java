package com.scaler.academy.homework.sep25;

import java.util.HashSet;
import java.util.Set;

// Question: https://www.interviewbit.com/problems/all-gcd/

public class AllGCD {

	public static void main(String[] args) {
		AllGCD obj = new AllGCD();
		int[] array = { 3, 2, 8 };
		System.out.println(obj.solve(array));
	}

	public int solve(int[] A) {
		Set<Integer> gcds = new HashSet<>();
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A.length; j++)
				gcds.add(gcd(A[i], A[j]));
		}
		return gcds.size();
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
