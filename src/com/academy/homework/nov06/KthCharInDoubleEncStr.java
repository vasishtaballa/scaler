package com.academy.homework.nov06;

import java.util.Stack;

// Question: https://www.interviewbit.com/problems/kth-character-in-double-decrypted-string/

public class KthCharInDoubleEncStr {

	public static void main(String[] args) {
		KthCharInDoubleEncStr obj = new KthCharInDoubleEncStr();
		System.out.println(obj.solve("vy97dc59ua98cr19xy", 31));
	}

	public String solve(String A, int B) {
		Stack<StackEntry> stack = new Stack<>();
		int length = 0, number = 0;
		for (int i = 0; i < A.length(); i++) {
			char ch = A.charAt(i);
			if (isCharacter(ch)) {
				number = 0;
				length++;
				StackEntry stackEntry = new StackEntry(A.charAt(i), length);
				stack.push(stackEntry);
			} else {
				while (i < A.length() && !isCharacter(A.charAt(i))) {
					number = findNumericValue(number, A.charAt(i));
					i++;
				}
				i--;
				length *= number;
			}
			if (length >= B)
				break;
		}
		return solveStack(stack, B);
	}

	private int findNumericValue(int number, char charAt) {
		return number * 10 + (charAt - 48);
	}

	private String solveStack(Stack<StackEntry> stack, int key) {
		StackEntry top = stack.pop();
		int length = top.length;
		key = key % length;
		while (key != 0) {
			top = stack.pop();
			length = top.length;
			key = key % length;
		}
		return String.valueOf(top.ch);
	}

	private boolean isCharacter(char ch) {
		if (ch > 47 && ch < 58)
			return false;
		return true;
	}

	class StackEntry {
		char ch;
		int length;

		public StackEntry(char ch, int length) {
			super();
			this.ch = ch;
			this.length = length;
		}

	}

}
