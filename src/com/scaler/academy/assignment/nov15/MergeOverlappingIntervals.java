package com.scaler.academy.assignment.nov15;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

// Question: https://www.interviewbit.com/problems/merge-overlapping-intervals/

public class MergeOverlappingIntervals {

	public static void main(String[] args) {
		MergeOverlappingIntervals obj = new MergeOverlappingIntervals();
		ArrayList<Interval> list = new ArrayList<>();
		list.add(new Interval(1, 10));
		list.add(new Interval(2, 9));
		list.add(new Interval(3, 8));
		list.add(new Interval(4, 7));
		list.add(new Interval(5, 6));
		list.add(new Interval(6, 6));
		ArrayList<Interval> result = obj.merge(list);
		System.out.println("Result: ");
		for (Interval item : result)
			System.out.println(item.start + " " + item.end);
	}

	public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
		ArrayList<Interval> result = new ArrayList<>();
		Collections.sort(intervals, new IntervalComparator());
		result.add(intervals.get(0));
		for (int i = 1; i < intervals.size(); i++) {
			Interval item = intervals.get(i);
			if (item.start <= result.get(result.size() - 1).end) {
				if (item.end >= result.get(result.size() - 1).end)
					result.get(result.size() - 1).end = item.end;
			} else
				result.add(item);
		}
		return result;
	}

}

class IntervalComparator implements Comparator<Interval> {

	@Override
	public int compare(Interval o1, Interval o2) {
		if (o1.start > o2.start)
			return 1;
		else if (o1.start < o2.start)
			return -1;
		return 0;
	}

}

class Interval {
	int start;
	int end;

	Interval() {
		start = 0;
		end = 0;
	}

	Interval(int s, int e) {
		start = s;
		end = e;
	}
}
