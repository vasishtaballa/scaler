package com.scaler.academy.homework.oct07;

// Question: https://www.interviewbit.com/problems/square-root-of-integer/

public class SquareRoot {

	public static void main(String[] args) {
		SquareRoot obj = new SquareRoot();
		System.out.println(obj.sqrt(2147483647));
	}

	public int sqrt(int a) {
		// Binary search on all the elements from 0 to a.
		int low = 0, high = a;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if ((long) mid * mid == a)
				return mid;
			else if ((long) mid * mid < a)
				low = mid + 1;
			else
				high = mid - 1;
		}
		return high;
	}

}
