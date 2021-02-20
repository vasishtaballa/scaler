package com.scaler.academy.assignment.nov06;

import java.util.Stack;

// Question: https://www.interviewbit.com/problems/largest-rectangle-in-histogram/

public class LargestRectangleInHistogram {

	public static void main(String[] args) {
		LargestRectangleInHistogram obj = new LargestRectangleInHistogram();
		int[] array = { 5, 1, 1 };
		System.out.println(obj.largestRectangleArea(array));
	}

	public int largestRectangleArea(int[] A) {
		Stack<Integer> stack = new Stack<>();
		int maxArea = 0, i = 0;
		while (i < A.length) {
			if (stack.isEmpty() || A[i] >= A[stack.peek()])
				stack.push(i++);
			else {
				int top = stack.pop();
				int area = 0;
				if (stack.isEmpty())
					area = A[top] * i;
				else
					area = A[top] * (i - stack.peek() - 1);
				maxArea = Math.max(maxArea, area);
			}
		}
		while (!stack.isEmpty()) {
			int top = stack.pop();
			int area = 0;
			if (stack.isEmpty())
				area = A[top] * i;
			else
				area = A[top] * (i - stack.peek() - 1);
			maxArea = Math.max(maxArea, area);
		}
		return maxArea;
	}

}
