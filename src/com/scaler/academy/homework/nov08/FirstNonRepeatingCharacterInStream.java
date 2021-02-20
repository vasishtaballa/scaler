package com.scaler.academy.homework.nov08;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

// Question: https://www.interviewbit.com/problems/first-non-repeating-character-in-a-stream-of-characters/

public class FirstNonRepeatingCharacterInStream {

	public static void main(String[] args) {
		FirstNonRepeatingCharacterInStream obj = new FirstNonRepeatingCharacterInStream();
		System.out.println(obj.solve("xxikr"));
	}

	public String solve(String A) {
		Map<Character, Integer> countMap = new HashMap<>();
		Queue<Character> queue = new LinkedList<>();
		StringBuilder result = new StringBuilder();
		queue.add(A.charAt(0));
		countMap.put(A.charAt(0), 1);
		result.append(A.charAt(0));
		for (int i = 1; i < A.length(); i++) {
			int count = 0;
			if (countMap.containsKey(A.charAt(i)))
				count = countMap.get(A.charAt(i));
			count += 1;
			countMap.put(A.charAt(i), count);
			while (!queue.isEmpty() && countMap.get(queue.peek()) > 1)
				queue.poll();
			if (queue.isEmpty() && count == 1)
				result.append(A.charAt(i));
			else if (queue.isEmpty())
				result.append("#");
			else
				result.append(queue.peek());
			if (countMap.get(A.charAt(i)) == 1)
				queue.add(A.charAt(i));
		}
		return result.toString();
	}

}
