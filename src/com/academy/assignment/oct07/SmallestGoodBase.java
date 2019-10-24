package com.academy.assignment.oct07;

// Question: https://www.interviewbit.com/problems/smallest-good-base/ 

public class SmallestGoodBase {

	public static void main(String[] args) {
		SmallestGoodBase obj = new SmallestGoodBase();
		System.out.println(obj.solve("13"));
	}

	public String solve(String A) {
		long number = Long.parseLong(A);
		for (int i = Math.min((int) (Math.pow(number, 0.5)), 64); i > 0; i--) {
			long k = (long) Math.pow(number, 1.0 / i);
			if (isGoodBase(number, k, i))
				return String.valueOf(k);
		}
		return String.valueOf(number - 1);
	}

	public boolean isGoodBase(long number, long k, long m) {
		int value = 1;
		for (int i = 0; i <= m; i++) {
			number -= value;
			value *= k;
		}
		return number == 0;
	}

}
