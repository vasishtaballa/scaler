package com.academy.homework.oct04;

// Question: https://www.interviewbit.com/problems/preimage-size-of-factorial-zeroes-function/

public class PreimageFactorialSize {

	public static void main(String[] args) {
		PreimageFactorialSize obj = new PreimageFactorialSize();
		System.out.println(obj.solve(10));
	}

	public int solve(int A) {
		long low = 0, high = Long.MAX_VALUE, result = 0;
		while (low < high) {
			long mid = low + (high - low) / 2;
			long trailingZeroes = getTrailingZeroes(mid);
			if (trailingZeroes < A)
				low = mid + 1;
			else
				high = mid;
		}
		while (getTrailingZeroes(low) == A) {
			result += 1;
			low += 1;
		}
		return (int) result;
	}

	public long getTrailingZeroes(long number) {
		long count = 0;
		while (number > 0) {
			number /= 5;
			count += number;
		}
		return count;
	}

}
