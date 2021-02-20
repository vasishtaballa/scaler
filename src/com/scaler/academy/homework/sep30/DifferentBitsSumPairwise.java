package com.scaler.academy.homework.sep30;

// Question: https://www.interviewbit.com/problems/different-bits-sum-pairwise/ 

public class DifferentBitsSumPairwise {

	public static void main(String[] args) {
		DifferentBitsSumPairwise obj = new DifferentBitsSumPairwise();
		int[] array = { 1, 3, 5 };
		System.out.println(obj.cntBits(array));
	}

	public int cntBits(int[] A) {
        long sum = 0;
        int modValue = 1000000007;
		for (int i = 0; i < 32; i++) {
			long zerosCount = 0, onesCount = 0;
			for (int j = 0; j < A.length; j++) {
				if ((A[j] & (1 << i)) > 0)
					onesCount = (onesCount + 1) % modValue;
				else
					zerosCount = (zerosCount + 1) % modValue;
			}
			sum = (sum % modValue + (zerosCount % modValue) * (onesCount % modValue) * 2) % modValue;
		}
		return (int) sum;
    }

}
