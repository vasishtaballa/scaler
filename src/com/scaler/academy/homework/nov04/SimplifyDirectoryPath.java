package com.scaler.academy.homework.nov04;

import java.util.Stack;

// Question: https://www.interviewbit.com/problems/simplify-directory-path/

public class SimplifyDirectoryPath {

	public static void main(String[] args) {
		SimplifyDirectoryPath obj = new SimplifyDirectoryPath();
		System.out.println(obj.simplifyPath("/./../../giq/xns/"));
	}

	public String simplifyPath(String A) {
		Stack<String> stack = new Stack<>();
		String[] tokens = A.split("/");
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < tokens.length; i++) {
			String token = tokens[i];
			if (token.equals("..") && !stack.isEmpty())
				stack.pop();
			else if (token.equals("..") && stack.isEmpty())
				continue;
			else if (token.equals("."))
				continue;
			else
				stack.push(token);
		}
		if (stack.isEmpty())
			return "/";
		while (!stack.isEmpty()) {
			if (stack.peek().equals(""))
				stack.pop();
			else
				result.insert(0, "/" + stack.pop());
		}
		return result.toString().equals("") ? "/" : result.toString();
	}

}
