package com.scaler.academy.assignment.nov08;

import java.util.LinkedList;
import java.util.Queue;

// Question: https://www.interviewbit.com/problems/n-integers-containing-only-1-2-and-3/

public class FormIntegers123 {

	public static void main(String[] args) {
		FormIntegers123 obj = new FormIntegers123();
		int[] result = obj.solve(7);
		for (int i = 0; i < result.length; i++)
			System.out.print(result[i] + " ");
	}

	public int[] solve(int A) {
		int[] result = new int[A];
		Queue<Integer> queue = new LinkedList<>();
		queue.add(1);
		queue.add(2);
		queue.add(3);
		int index = 0;
		while (index < A) {
			int item = queue.poll();
			result[index++] = item;
			int pushItem1 = item * 10 + 1;
			int pushItem2 = item * 10 + 2;
			int pushItem3 = item * 10 + 3;
			queue.add(pushItem1);
			queue.add(pushItem2);
			queue.add(pushItem3);
		}
		return result;
	}

}
