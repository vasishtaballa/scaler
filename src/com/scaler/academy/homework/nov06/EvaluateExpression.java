package com.scaler.academy.homework.nov06;

import java.util.Stack;

// Question: https://www.interviewbit.com/problems/evaluate-expression/ 

public class EvaluateExpression {

	public static void main(String[] args) {
		EvaluateExpression obj = new EvaluateExpression();
		String[] array = { "4", "13", "5", "/", "+" };
		System.out.println(obj.evalRPN(array));
	}

	public int evalRPN(String[] A) {
		Stack<String> stack = new Stack<>();
		for (int i = 0; i < A.length; i++) {
			if (isOperator(A[i])) {
				// If element in the array is operator, take top two elements from the stack and
				// perform this operation and push result back to the stack
				int operand1 = Integer.parseInt(stack.pop());
				int operand2 = Integer.parseInt(stack.pop());
				int result = executeOperation(operand2, operand1, A[i]);
				stack.push(String.valueOf(result));
			} else
				stack.push(A[i]);
		}
		return Integer.parseInt(stack.pop());
	}

	private int executeOperation(int operand1, int operand2, String string) {
		if (string.equals("+"))
			return operand1 + operand2;
		else if (string.equals("-"))
			return operand1 - operand2;
		else if (string.equals("*"))
			return operand1 * operand2;
		else if (string.equals("/"))
			return operand1 / operand2;
		return 0;
	}

	private boolean isOperator(String str) {
		if (str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/"))
			return true;
		return false;
	}

}
