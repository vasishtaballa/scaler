package com.scaler.academy.homework.nov06;

import java.util.Stack;

// Question: https://www.interviewbit.com/problems/redundant-braces/ 

public class RedundantBraces {

	public static void main(String[] args) {
		RedundantBraces obj = new RedundantBraces();
		System.out.println(obj.braces("((a+b))"));
	}

	public int braces(String A) {
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < A.length(); i++) {
			if (A.charAt(i) == ')') {
				boolean operatorFlag = false;
				while (stack.peek() != '(') {
					char top = stack.pop();
					if (top == '+' || top == '-' || top == '*' || top == '/')
						operatorFlag = true;
				}
				if (operatorFlag == false)
					return 1;
				stack.pop();
			} else
				stack.push(A.charAt(i));
		}
		return 0;
	}

}
