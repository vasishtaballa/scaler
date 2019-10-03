package com.academy.homework.sep30;

// Question: https://www.interviewbit.com/problems/divide-integers/

public class DivideIntegers {

	public static void main(String[] args) {
		DivideIntegers obj = new DivideIntegers();
		System.out.println(obj.divide(-2147483648, -1));
	}

	public int divide(int A, int B) {
		long quotient = 0, temp = 0;
		int sign = ((A > 0 && B > 0) || (A < 0 && B < 0)) ? 1 : -1;
		long dividend = (long) A;
		long divisor = (long) B;
		dividend = Math.abs(dividend);
		divisor = Math.abs(divisor);
		for (int i = 31; i >= 0; i--) {
			if (temp + (divisor << i) <= dividend) {
				temp += divisor << i;
				quotient |= 1L << i;
			}
		}
		long answer = quotient * sign;
		if (answer > Integer.MAX_VALUE || answer < Integer.MIN_VALUE)
			return Integer.MAX_VALUE;
		return (int) answer;
	}

}
