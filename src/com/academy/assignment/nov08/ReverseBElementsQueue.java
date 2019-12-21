package com.academy.assignment.nov08;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class ReverseBElementsQueue {

	public static void main(String[] args) {
		ReverseBElementsQueue obj = new ReverseBElementsQueue();
		int[] array = { 1, 2, 3, 4, 5 };
		int[] result = obj.solve(array, 3);
		for (int i = 0; i < result.length; i++)
			System.out.print(result[i] + " ");
	}

	public int[] solve(int[] A, int B) {
		Deque<Integer> dequeue = new LinkedList<>();
		Queue<Integer> queue = new LinkedList<>();
		// Adding elements to queue
		for (int i = 0; i < A.length; i++)
			queue.add(A[i]);
		for (int i = 0; i < B; i++)
			dequeue.addFirst(A[i]);
		for (int i = B; i < A.length; i++)
			dequeue.addLast(A[i]);
		for (int i = 0; i < A.length; i++)
			A[i] = dequeue.pollFirst();
		return A;
	}

}
