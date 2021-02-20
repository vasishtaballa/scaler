package com.scaler.academy.assignment.util;

public class GeneralUtility {
	public static String[] getStrFrmInt(int[] arr) {
		String[] strArr = new String[arr.length];
		for (int i = 0; i < arr.length; i++)
			strArr[i] = String.valueOf(arr[i]);
		return strArr;
	}
}
