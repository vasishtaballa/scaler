package com.scaler.academy.assignment.oct04;

import java.util.ArrayList;
import java.util.List;

// Question: https://www.interviewbit.com/problems/search-for-a-range/

public class SearchForRange {

	public static void main(String[] args) {
		SearchForRange obj = new SearchForRange();
		List<Integer> list = new ArrayList<>();
		list.add(5);
		list.add(7);
		list.add(7);
		list.add(8);
		list.add(8);
		list.add(10);
		ArrayList<Integer> result = obj.searchRange(list, 7);
		for (Integer i : result)
			System.out.println(i);
	}

	public ArrayList<Integer> searchRange(final List<Integer> a, int b) {
		ArrayList<Integer> result = new ArrayList<>();
		result.add(searchFirst(a, b));
		result.add(searchLast(a, b));
		return result;
	}

	public int searchFirst(List<Integer> a, int b) {
		int low = 0, high = a.size() - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if ((mid == 0 || a.get(mid - 1) < b) && a.get(mid) == b)
				return mid;
			else if (a.get(mid) < b)
				low = mid + 1;
			else
				high = mid - 1;
		}
		return -1;
	}

	public int searchLast(List<Integer> a, int b) {
		int low = 0, high = a.size() - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if ((mid == a.size() - 1 || a.get(mid + 1) > b) && a.get(mid) == b)
				return mid;
			else if (a.get(mid) > b)
				high = mid - 1;
			else
				low = mid + 1;
		}
		return -1;
	}

}
