package com.scaler.academy.assignment.nov15;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

// Question: https://www.interviewbit.com/problems/largest-number/

public class LargestNumber {

	public static void main(String[] args) {
		LargestNumber obj = new LargestNumber();
		int[] array = { 3, 30, 34, 5, 9 };
		System.out.println(obj.largestNumber(array));
	}

	public String largestNumber(final int[] A) {
		StringBuilder builder = new StringBuilder();
		ArrayList<Integer> list = new ArrayList<>();
		for (int i : A)
			list.add(i);
		Collections.sort(list, new LargestNumberComparator());
		for (int i : list) {
			if (!(i == 0 && builder.toString().length() > 0 && builder.charAt(builder.toString().length() - 1) == '0'))
				builder.append(i);
		}
		return builder.toString();
	}

}

class LargestNumberComparator implements Comparator<Integer> {

	@Override
	public int compare(Integer o1, Integer o2) {
		String str1 = String.valueOf(o1);
		String str2 = String.valueOf(o2);
		String str3 = str1 + str2;
		String str4 = str2 + str1;
		if (str3.compareTo(str4) < 1)
			return 1;
		else if (str3.compareTo(str4) >= 1)
			return -1;
		return 0;
	}

}