package com.scaler.academy.homework.sep25;

// Question: https://www.interviewbit.com/problems/reverse-integer/

public class ReverseInteger {

	public static void main(String[] args) {
		ReverseInteger obj = new ReverseInteger();
		System.out.println(obj.reverse(-123));
	}

	public int reverse(int A) {
		int temp = A;
		long result = 0;
		if (A < 0)
			A = -A;
		while (A > 0) {
			result = result * 10 + A % 10;
			if (result > Integer.MAX_VALUE)
				return 0;
			A /= 10;
		}
		if (temp < 0)
			return (int) -result;
		return (int) result;
	}

}
