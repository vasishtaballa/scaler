package com.scaler.academy.assignment.sep30;

// Question: https://www.interviewbit.com/problems/single-number-ii/

public class SingleNumberII {

	public static void main(String[] args) {
		SingleNumberII obj = new SingleNumberII();
		int[] array = { 1, 4, 4, 3, 3, 4, 2, 3, 1, 1 };
		System.out.println(obj.singleNumber(array));
	}

	public int singleNumber(final int[] A) {
		int result = 0;
		for (int i = 0; i < 32; i++) {
			int oneCount = 0;
			for (int j = 0; j < A.length; j++) {
				if ((A[j] & (1 << i)) > 0)
					oneCount += 1;
			}
			if (oneCount % 3 != 0)
				result |= (1 << i);
		}
		return result;
	}

}
