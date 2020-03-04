package com.academy.assignment.nov21;

import java.util.Scanner;
import java.util.Stack;

public class Solution {
	public static void main(String[] argh) {
		Scanner sc = new Scanner(System.in);

		while (sc.hasNext()) {
			String input = sc.next();
			if (isBalanced(input))
				System.out.println("true");
			else
				System.out.println("false");
		}

	}

	public static boolean isBalanced(String str) {
		Stack<Character> stack = new Stack<>();
		stack.push(str.charAt(0));
		for (int i = 1; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (!stack.isEmpty() && (stack.peek() == '}' || stack.peek() == ')' || stack.peek() == ']'))
				return false;
			if (!stack.isEmpty()) {
				if (stack.peek() == '{' && ch == '}')
					stack.pop();
				else if (stack.peek() == '(' && ch == ')')
					stack.pop();
				else if (stack.peek() == '[' && ch == ']')
					stack.pop();
				else
					stack.push(ch);
			} else
				stack.push(ch);
		}
		if (!stack.isEmpty())
			return false;
		return true;
	}
}
