package com.academy.homework.oct07;

// Question: https://www.interviewbit.com/problems/painters-partition-problem/

public class PaintersPartition {

	public static void main(String[] args) {
		PaintersPartition obj = new PaintersPartition();
		int[] array = { 1000000, 1000000 };
		System.out.println(obj.paint(1, 1000000, array));
	}

	public int paint(int A, int B, int[] C) {
		// Calculate maximum total time
		long low = 0, high = Integer.MIN_VALUE, result = -1, total = 0;
		for (int i = 0; i < C.length; i++) {
			high = Math.max(high, C[i]);
			total += C[i];
		}
		low = high;
		high = total;
		while (low < high) {
			long mid = (int) (low + (high - low) / 2);
			if (isPossible(A, B, C, mid) <= A) {
				result = mid;
				high = mid;
			} else
				low = mid + 1;
		}
		result = ((low % 10000003) * (B % 10000003)) % 10000003;
		return (int) result;
	}

	public long isPossible(int A, int B, int[] C, long mid) {
		long total = 0, count = 1;
		for (int i = 0; i < C.length; i++) {
			total += C[i];
			if (total > mid) {
				total = C[i];
				count += 1;
			}
		}
		return count;
	}

}
