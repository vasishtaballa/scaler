package com.academy.assignment.oct04;

import java.util.ArrayList;
import java.util.List;

// Question: https://www.interviewbit.com/problems/rotated-sorted-array-search/

public class RotatedSortedArraySearch {

	public static void main(String[] args) {
		RotatedSortedArraySearch obj = new RotatedSortedArraySearch();
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(5);
		list.add(5);
		list.add(133);
		list.add(178);
		System.out.println(obj.search(list, 5));
	}

	public int search(final List<Integer> a, int b) {
		int pivot = getPivot(a);
		if (pivot == -1)
			return binarySearch(a, 0, a.size() - 1, b);
		if (a.get(pivot) == b)
			return pivot;
		if (a.get(0) <= b && a.get(pivot) >= b)
			return binarySearch(a, 0, pivot, b);
		else if (a.get(pivot + 1) <= b && a.get(a.size() - 1) >= b)
			return binarySearch(a, pivot + 1, a.size(), b);
		return -1;
	}

	public int binarySearch(List<Integer> list, int low, int high, int key) {
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (list.get(mid) == key)
				return mid;
			else if (list.get(mid) < key)
				low = mid + 1;
			else
				high = mid - 1;
		}
		return -1;
	}

	public int getPivot(List<Integer> list) {
		int low = 0, high = list.size() - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (list.get(mid) >= list.get(high) && list.get(mid) > list.get(0) && list.get(mid) > list.get(mid + 1))
				return mid;
			if (list.get(mid) > list.get(high))
				low = mid + 1;
			else if (list.get(mid) < list.get(low))
				high = mid - 1;
			else
				return -1;
		}
		return -1;
	}

}
