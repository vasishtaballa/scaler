package com.academy.assignment.nov04;

import java.util.Stack;

// Question: https://www.interviewbit.com/problems/order-them/

public class OrderThem {

	public static void main(String[] args) {
		OrderThem obj = new OrderThem();
		int[] array = { 5, 3, 1, 4, 2 };
		System.out.println(obj.solve(array));
	}

	public int solve(int[] A) {
		Stack<Integer> B = new Stack<>();
		Stack<Integer> C = new Stack<>();
		for (int i = 0; i < A.length; i++) {
			int number = A[i];
			if (C.isEmpty())
				C.push(number);
			else {
				if (number < C.peek())
					C.push(number);
				else {
					while (!C.isEmpty() && number > C.peek()) {
						if (!B.isEmpty() && B.peek() > C.peek())
							return 0;
						B.push(C.pop());
					}
					C.push(number);
				}
			}
		}
		while (!C.isEmpty() && (B.isEmpty() || C.peek() > B.peek()))
			B.push(C.pop());
		if (!C.isEmpty())
			return 0;
		return 1;
	}

}
