package com.scaler.academy.assignment.nov04;

import java.util.Stack;

public class MinStack {
	Stack<Long> stack = null;
	long min = -1;

	MinStack() {
		stack = new Stack<>();
	}

	public void push(int x) {
		if (stack.isEmpty()) {
			min = x;
			stack.push((long) x);
		} else {
			if (x < min) {
				stack.push(2 * x - min);
				min = x;
			} else
				stack.push((long) x);
		}
	}

	public void pop() {
		if (stack.isEmpty())
			return;
		if (stack.peek() < min) {
			min = min * 2 - stack.peek();
			stack.pop();
		} else
			stack.pop();
	}

	public int top() {
		if (stack.isEmpty())
			return -1;
		if (stack.peek() < min)
			return (int) min;
		return Integer.parseInt(String.valueOf(stack.peek()));
	}

	public int getMin() {
		if (stack.isEmpty())
			return -1;
		return (int) min;
	}

	public static void main(String[] args) {
		MinStack stack = new MinStack();
		stack.push(10);
		stack.push(9);
		System.out.println(stack.getMin());
		stack.push(8);
		System.out.println(stack.getMin());
		stack.push(7);
		System.out.println(stack.getMin());
		stack.push(6);
		System.out.println(stack.getMin());
		stack.pop();
		System.out.println(stack.getMin());
		stack.pop();
		System.out.println(stack.getMin());
		stack.pop();
		System.out.println(stack.getMin());
		stack.pop();
		System.out.println(stack.getMin());
		stack.pop();
		System.out.println(stack.getMin());
	}

}
