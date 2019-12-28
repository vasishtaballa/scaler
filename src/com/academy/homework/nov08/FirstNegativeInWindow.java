package com.academy.homework.nov08;

import java.util.Deque;
import java.util.LinkedList;

// Question: https://www.interviewbit.com/problems/first-negative-integer-in-window-size-b/ 

public class FirstNegativeInWindow {

	public static void main(String[] args) {
		FirstNegativeInWindow obj = new FirstNegativeInWindow();
		int[] array = { 10, 4, 1, 5, 3, -4, -7, -9, 10 };
		int[] result = obj.solve(array, 3);
		for (int i = 0; i < result.length; i++)
			System.out.print(result[i] + " ");
	}

	public int[] solve(int[] A, int B) {
		int[] result = new int[A.length - B + 1];
		int index = 0;
		Deque<Integer> deQueue = new LinkedList<>();
		for (int i = 0; i <= A.length; i++) {
			if (i < B) {
				// First B elements, no need to decide output. Just either add element or not to
				// queue
				if (A[i] < 0)
					deQueue.addLast(i);
			} else {
				// Check for every element and decide output
				if (deQueue.isEmpty() || !(deQueue.peekFirst() > i - B - 1 && deQueue.peekFirst() < i))
					result[index++] = 0;
				else
					result[index++] = A[deQueue.peekFirst()];
				while (!deQueue.isEmpty() && deQueue.peekFirst() <= i - B)
					deQueue.pollFirst();
				if (i < A.length && A[i] < 0)
					deQueue.addLast(i);
			}
		}
		return result;
	}

}
