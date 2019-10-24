package com.academy.assignment.oct07;

// Question: https://www.interviewbit.com/problems/allocate-books/
public class AllocateBooks {

	public static void main(String[] args) {
		AllocateBooks obj = new AllocateBooks();
		int[] array = { 31, 14, 19, 75 };
		System.out.println(obj.books(array, 12));
	}

	public int books(int[] A, int B) {
		int totalPages = 0, minimum = Integer.MAX_VALUE;
		if (A.length < B)
			return -1;
		for (int i = 0; i < A.length; i++)
			totalPages += A[i];
		int low = 0, high = totalPages;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (isPossible(mid, A, B)) {
				high = mid - 1;
				minimum = Math.min(minimum, mid);
			} else
				low = mid + 1;
		}
		return minimum;
	}

	public boolean isPossible(int pageSize, int[] A, int B) {
		int total = 0, count = 1;
		for (int i = 0; i < A.length; i++) {
			if (A[i] > pageSize)
				return false;
			if (total + A[i] > pageSize) {
				total = A[i];
				count += 1;
				if (count > B)
					return false;

			} else
				total += A[i];
		}
		return true;
	}

}
