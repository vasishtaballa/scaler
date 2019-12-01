package com.academy.assignment.nov04;

import java.util.Stack;

public class SortStack {

	public static void main(String[] args) {
		SortStack obj = new SortStack();
		int[] array = { 5, 17, 100, 11 };
		array = obj.solve(array);
		for (int i = 0; i < array.length; i++)
			System.out.print(array[i] + " ");
	}

	public int[] solve(int[] A) {
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < A.length; i++)
			stack.push(A[i]);
		stack = sortStack(stack);
		int index = 0;
		while (!stack.isEmpty())
			A[index++] = stack.pop();
		return A;
	}

	private Stack<Integer> sortStack(Stack<Integer> stack) {
		Stack<Integer> tempStack = new Stack<>();
		while (!stack.isEmpty()) {
			int item = stack.pop();
			insertAtPosition(item, tempStack);
		}
		return tempStack;
	}

	private void insertAtPosition(int item, Stack<Integer> stack) {
		if (stack.isEmpty() || stack.peek() > item)
			stack.push(item);
		else {
			int temp = stack.pop();
			insertAtPosition(item, stack);
			stack.push(temp);
		}
	}

}
