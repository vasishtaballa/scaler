package com.scaler.academy.assignment.nov08;

import java.util.Deque;
import java.util.LinkedList;

// Question: https://www.interviewbit.com/problems/sum-of-minimum-and-maximum-elements-of-all-subarrays-of-size-k/

public class MinMaxSumSubArray {

	public static void main(String[] args) {
		MinMaxSumSubArray obj = new MinMaxSumSubArray();
		int[] array = { 2, 5, -1, 7, -3, -1, -2 };
		System.out.println(obj.solve(array, 4));
	}

	public int solve(int[] A, int B) {
		int result = 0, minimum = Integer.MAX_VALUE, maximum = Integer.MIN_VALUE, modValue = 1000000007;
		Deque<Integer> maxQueue = new LinkedList<>();
		Deque<Integer> minQueue = new LinkedList<>();
		maxQueue.addLast(0);
		minQueue.addLast(0);
		for (int i = 1; i < B; i++) {
			while (!maxQueue.isEmpty() && A[maxQueue.peekLast()] <= A[i])
				maxQueue.pollLast();
			maxQueue.addLast(i);
			while (!minQueue.isEmpty() && A[minQueue.peekLast()] >= A[i])
				minQueue.pollLast();
			minQueue.addLast(i);
		}
		for (int i = B; i < A.length; i++) {
			maximum = A[maxQueue.peekFirst()];
			minimum = A[minQueue.peekFirst()];
			result += maximum % modValue + minimum % modValue;
			while (B - i >= maxQueue.peekFirst())
				maxQueue.pollFirst();
			while (B - i >= minQueue.peekFirst())
				minQueue.pollFirst();
			while (!maxQueue.isEmpty() && A[maxQueue.peekLast()] <= A[i])
				maxQueue.pollLast();
			maxQueue.addLast(i);
			while (!minQueue.isEmpty() && A[minQueue.peekLast()] >= A[i])
				minQueue.pollLast();
			minQueue.addLast(i);
		}
		result += maximum % modValue + minimum % modValue;
		return result;
	}

}
