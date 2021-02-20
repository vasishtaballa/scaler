package com.scaler.academy.homework.nov15;

// Question: https://www.interviewbit.com/problems/triplets-with-sum-between-given-range/

public class TripletsInRange {

	public static void main(String[] args) {
		TripletsInRange obj = new TripletsInRange();
		String[] array = { "0.6", "0.7", "0.8", "1.2", "0.4" };
		System.out.println(obj.solve(array));
	}

	public int solve(String[] A) {
		float max1A, max2A, max3A, min1A, min2A, min1B, min2B, min1C;
		max1A = max2A = max3A = Integer.MIN_VALUE;
		min1A = min2A = min1B = min2B = min1C = Integer.MAX_VALUE;
		for (int i = 0; i < A.length; i++) {
			float floatVal = getFloatValue(A[i]);
			if (floatVal <= 0.66) {
				if (floatVal > max1A) {
					max3A = max2A;
					max2A = max1A;
					max1A = floatVal;
				} else if (floatVal > max2A) {
					max3A = max2A;
					max2A = floatVal;
				} else if (floatVal > max3A)
					max3A = floatVal;
				if (floatVal < min1A) {
					min2A = min1A;
					min1A = floatVal;
				} else if (floatVal < min2A)
					min2A = floatVal;
			} else if (floatVal <= 1) {
				if (floatVal < min1B) {
					min2B = min1B;
					min1B = floatVal;
				} else if (floatVal < min2B)
					min2B = floatVal;
			} else if (floatVal < 2) {
				if (floatVal < min1C)
					min1C = floatVal;
			}
		}
		float sumAAA = max1A + max2A + max3A;
		float sumAAB = max1A + max2A + min1B;
		float sumAAC = min1A + min2A + min1C;
		float sumABB = min1A + min1B + min2B;
		float sumABC = min1A + min1B + min1C;
		if ((sumAAA < 2.0 && sumAAA > 1.0) || (sumAAB < 2.0 && sumAAB > 1.0) || (sumAAC < 2.0 && sumAAC > 1.0)) {
			return 1;
		}
		if ((sumABB < 2.0 && sumABB > 1.0) || (sumABC < 2.0 && sumABC > 1.0)) {
			return 1;
		}
		return 0;
	}

	public float getFloatValue(String value) {
		return Float.parseFloat(value);
	}

}
