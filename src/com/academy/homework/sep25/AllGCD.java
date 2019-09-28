package com.academy.homework.sep25;

import java.util.ArrayList;
import java.util.List;

// Question: https://www.interviewbit.com/problems/all-gcd/

public class AllGCD {

	public static void main(String[] args) {
		AllGCD obj = new AllGCD();
		ArrayList<Integer> list = new ArrayList<>();
		list.add(3);
		list.add(2);
		list.add(8);
		System.out.println(obj.solve(list));
	}

	public int solve(ArrayList<Integer> A) {
		int ans = 0;
		for (int i = 1; i <= 1000; i++) {
			List<Integer> arr = new ArrayList<Integer>();
			for (int j = 0; j < A.size(); j++) {
				if (A.get(j) % i == 0) {
					arr.add(A.get(j) / i);
				}
			}
			if (arr.size() > 0 && isGcdOne(arr)) {
				ans += 1;
				// System.out.println(i);
				// System.out.println(arr);
			}
		}
		return ans;
	}

	public boolean isGcdOne(List<Integer> arr) {
		int max = -1;
		for (int i = 0; i < arr.size(); i++) {
			if (arr.get(i) > max) {
				max = arr.get(i);
			}
		}
		boolean ans = false;
		for (int i = 2; i <= max; i++) {
			if (!ans) {
				ans = true;
				// System.out.println(true);
				for (int j = 0; j < arr.size(); j++) {
					if (arr.get(j) % i != 0) {
						ans = false;
						break;
					}
				}
			}
		}
		return !ans;
	}

}
