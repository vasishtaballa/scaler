package com.scaler.academy.homework.sep17;

import java.util.ArrayList;

// Question: https://www.interviewbit.com/problems/next-permutation/

public class NextPermutation {
	public static void main(String[] args) {
		ArrayList<Integer> arrayList = new ArrayList<>();
		arrayList.add(5);
		arrayList.add(3);
		arrayList.add(4);
		arrayList.add(9);
		arrayList.add(7);
		arrayList.add(6);

		NextPermutation obj = new NextPermutation();
		obj.nextPermutation(arrayList);
		for (int i = 0; i < arrayList.size(); i++)
			System.out.println(arrayList.get(i));
	}

	public void nextPermutation(ArrayList<Integer> a) {
		int swapFirst = -1, swapLast = -1;
		for (int i = a.size() - 1; i > 0; i--) {
			if (a.get(i) > a.get(i - 1)) {
				swapFirst = i - 1;
				break;
			}
		}
		int nextMax = a.get(swapFirst + 1);
		swapLast = swapFirst + 1;
		if (swapFirst != -1) {
			for (int i = swapFirst + 1; i < a.size(); i++) {
				if (a.get(i) > a.get(swapFirst)) {
					if (nextMax > a.get(i)) {
						nextMax = a.get(i);
						swapLast = i;
					}
				}
			}
			swap(swapFirst, swapLast, a);
			reverseRemaining(swapFirst + 1, a.size() - 1, a);
			return;
		}
		reverseRemaining(swapFirst + 1, a.size() - 1, a);
	}

	public void swap(int first, int last, ArrayList<Integer> a) {
		int temp = a.get(first);
		a.set(first, a.get(last));
		a.set(last, temp);
	}

	public void reverseRemaining(int first, int last, ArrayList<Integer> a) {
		for (int i = first, j = last; i <= j; i++, j--)
			swap(i, j, a);
	}
}
