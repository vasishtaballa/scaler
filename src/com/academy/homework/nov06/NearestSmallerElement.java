package com.academy.homework.nov06;

import java.util.Stack;

// Question: https://www.interviewbit.com/problems/nearest-smaller-element/

public class NearestSmallerElement {

	public static void main(String[] args) {
		NearestSmallerElement obj = new NearestSmallerElement();
		int[] array = { 39, 27, 11, 4, 24, 32, 32, 1 };
		int[] result = obj.prevSmaller(array);
		for (int i = 0; i < result.length; i++)
			System.out.print(result[i] + " ");
	}

	public int[] prevSmaller(int[] A) {
		int[] result = new int[A.length];
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < A.length; i++) {
			while (!stack.isEmpty() && stack.peek() >= A[i])
				stack.pop();
			if (stack.isEmpty())
				result[i] = -1;
			else
				result[i] = stack.peek();
			stack.push(A[i]);
		}
		return result;
	}

}
