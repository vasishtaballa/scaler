package com.scaler.academy.homework.sep30;

/*Question:
	Xor queries
	You are given an array (containing only 0 and 1) as element of N length. Given L and R, you need to determine value of XOR of all elements from L to R (both inclusive) and number of unset bits (0's) in the given range of the array. Input
	First argument contains the array of size N containing 0 and 1 only (1<=N<=100000). 
	
	Second argument contains a 2D array with Q rows and 2 columns, each row represent a query with 2 columns representing L and R. 
	
	(1<=Q<=100000), (1<=L<=R<=N).
	Output
	Return an 2D array of Q rows and 2 columns i.e the xor value and number of unset bits in that range respectively for each query.
	Examples Input
	1 0 0 0 1
	2 4
	1 5 
	3 5
	Output
	0 3
	0 3
	1 2
	Explanation Testcase 1-
	In the given case the bit sequence is of length 5 and the sequence is 1 0 0 0 1. For query 1 the range is (2,4), and the answer is (array[2] xor array[3] xor array[4]) = 0, and number of zeroes are 3, so output is 0 3. Similarly for other queries.*/

public class XORQueries {

	public static void main(String[] args) {
		XORQueries obj = new XORQueries();
		int[] array = { 1, 0, 0, 0, 1 };
		int[][] matrix = { { 2, 4 }, { 1, 5 }, { 3, 5 } };
		int[][] result = obj.solve(array, matrix);
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[0].length; j++)
				System.out.print(result[i][j] + " ");
			System.out.println();
		}
	}

	public int[][] solve(int[] A, int[][] B) {
		int[] prefixSum = new int[A.length];
		int[][] result = new int[B.length][2];
		prefixSum[0] = A[0];
		for (int i = 1; i < A.length; i++)
			prefixSum[i] = prefixSum[i - 1] + A[i];
		for (int i = 0; i < B.length; i++) {
			int start = B[i][0] - 1;
			int end = B[i][1] - 1;
			int numberOfOnes = 0;
			if (start - 1 > -1)
				numberOfOnes = prefixSum[end] - prefixSum[start - 1];
			else
				numberOfOnes = prefixSum[end];
			result[i][0] = (numberOfOnes % 2 == 0) ? 0 : 1;
			result[i][1] = Math.abs(numberOfOnes - (end - start + 1));
		}
		return result;
	}

}
