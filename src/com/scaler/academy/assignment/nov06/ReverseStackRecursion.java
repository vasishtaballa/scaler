package com.scaler.academy.assignment.nov06;

import java.util.Stack;

// Question: https://www.interviewbit.com/problems/reverse-a-stack-using-recursion/ 

public class ReverseStackRecursion {

	public static void main(String[] args) {
		int[] array = { 1, 5, 3, 2, 4 };
		ReverseStackRecursion obj = new ReverseStackRecursion();
		int[] result = obj.solve(array);
		for (int i = 0; i < result.length; i++)
			System.out.print(result[i] + " ");
	}

	public int[] solve(int[] A) {
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < A.length; i++)
			stack.push(A[i]);
		reverseStack(stack);
		int index = A.length - 1;
		while (!stack.isEmpty())
			A[index--] = stack.pop();
		return A;
	}

	private void reverseStack(Stack<Integer> stack) {
		if (stack.isEmpty())
			return;
		int top = stack.pop();
		reverseStack(stack);
		pushAtBottom(top, stack);
	}

	private void pushAtBottom(int element, Stack<Integer> stack) {
		if (stack.isEmpty())
			stack.push(element);
		else {
			int item = stack.pop();
			pushAtBottom(element, stack);
			stack.push(item);
		}
	}

}
