package com.academy.assignment.nov06;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

// Question: https://www.interviewbit.com/problems/remove-duplicate-letters/ 

public class RemoveDuplicateLetters {
	public static void main(String[] args) {
		RemoveDuplicateLetters obj = new RemoveDuplicateLetters();
		System.out.println(obj.solve("bcabc"));
	}

	public String solve(String A) {
		Stack<Character> stack = new Stack<>(); // Stack to maintain the lexicographically smallest string
		Map<Character, Integer> countMap = new HashMap<>(); // Contains count of each character in string
		Map<Character, Boolean> visitedMap = new HashMap<>(); // Contains whether the character is included in result

		initiliazeMaps(countMap, visitedMap, A);
		// Iterating the string from left to right
		for (int i = 0; i < A.length(); i++) {
			if (stack.isEmpty() || (!visitedMap.get(A.charAt(i)) && stack.peek() < A.charAt(i))) {
				// If stack is empty, push the character to stack
				stack.push(A.charAt(i));
				countMap.put(A.charAt(i), countMap.get(A.charAt(i)) - 1);
				visitedMap.put(A.charAt(i), true);
			} else {
				// If stack is not empty, check the character with top element in the stack.
				while (!stack.isEmpty() && stack.peek() >= A.charAt(i) && !visitedMap.get(A.charAt(i))) {
					char topElement = stack.peek();
					if (countMap.get(topElement) > 0) {
						// countMap.put(topElement, countMap.get(topElement) - 1);
						visitedMap.put(topElement, false);
						topElement = stack.pop();
					} else
						break;
				}
				if (!visitedMap.get(A.charAt(i))) {
					stack.push(A.charAt(i));
					countMap.put(A.charAt(i), countMap.get(A.charAt(i)) - 1);
					visitedMap.put(A.charAt(i), true);
				} else {
					countMap.put(A.charAt(i), countMap.get(A.charAt(i)) - 1);
				}
			}
		}
		StringBuilder result = new StringBuilder();
		while (!stack.isEmpty())
			result.append(stack.pop());
		return result.reverse().toString();
	}

	private void initiliazeMaps(Map<Character, Integer> countMap, Map<Character, Boolean> visitedMap, String str) {
		for (int i = 0; i < str.length(); i++) {
			if (countMap.containsKey(str.charAt(i)))
				countMap.put(str.charAt(i), countMap.get(str.charAt(i)) + 1);
			else {
				countMap.put(str.charAt(i), 1);
				visitedMap.put(str.charAt(i), false);
			}
		}
	}
}
