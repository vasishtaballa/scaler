package com.academy.assignment.sep30;

// Question: https://www.interviewbit.com/problems/reverse-bits/

public class ReverseBits {

	public static void main(String[] args) {
		ReverseBits obj = new ReverseBits();
		System.out.println(obj.reverse(11));
	}

	public long reverse(long a) {
		int power = 31;
		long result = 0;
		for (int i = 0; i < 32; i++) {
			if ((a & (1 << i)) > 0)
				result += Math.pow(2, power);
			power -= 1;
		}
		return result;
	}

}
