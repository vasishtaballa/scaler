package com.scaler.academy.assignment.nov04;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

// Question: https://www.interviewbit.com/problems/maximum-frequency-stack/

public class MaximumFrequencyStack {

	Map<Integer, Integer> frequencyMap = new HashMap<>();
	Map<Integer, Stack<Integer>> stackMap = new HashMap<>();
	int maxFrequency = 0;

	public static void main(String[] args) {
		MaximumFrequencyStack obj = new MaximumFrequencyStack();
		int[][] matrix = { { 1, 5 }, { 1, 7 }, { 1, 5 }, { 1, 7 }, { 1, 4 }, { 1, 5 }, { 2, 0 }, { 2, 0 }, { 2, 0 },
				{ 2, 0 } };
		int[] result = obj.solve(matrix);
		for (int i = 0; i < result.length; i++)
			System.out.print(result[i] + " ");
	}

	public int[] solve(int[][] A) {
		int[] result = new int[A.length];
		for (int i = 0; i < A.length; i++) {
			int operation = A[i][0];
			int item = A[i][1];
			switch (operation) {
			case 1:
				result[i] = push(item);
				break;
			case 2:
				result[i] = pop();
				break;
			}
		}
		return result;
	}

	private int push(int item) {
		int count = 0;
		if (frequencyMap.containsKey(item)) {
			count = frequencyMap.get(item) + 1;
			frequencyMap.put(item, count);
			if (count >= maxFrequency)
				maxFrequency = count;
		} else {
			count = 1;
			frequencyMap.put(item, count);
			maxFrequency = Math.max(maxFrequency, count);
		}
		if (stackMap.containsKey(count)) {
			Stack<Integer> existingStack = stackMap.get(count);
			existingStack.push(item);
			stackMap.put(count, existingStack);
		} else {
			Stack<Integer> stack = new Stack<>();
			stack.push(item);
			stackMap.put(count, stack);
		}
		return -1;
	}

	private int pop() {
		int top = stackMap.get(maxFrequency).pop();
		if (stackMap.get(maxFrequency).isEmpty())
			maxFrequency--;
		int itemCount = frequencyMap.get(top) - 1;
		frequencyMap.put(top, itemCount);
		return top;
	}

}
