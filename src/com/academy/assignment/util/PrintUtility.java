package com.academy.assignment.util;

import java.util.List;

public class PrintUtility {
	public static void printArray(int[] array) {
		for (int item : array)
			System.out.println(item + " ");
	}

	public static void printArrayList(List<Object> list) {
		for (Object item : list)
			System.out.println(item + " ");
	}
}
