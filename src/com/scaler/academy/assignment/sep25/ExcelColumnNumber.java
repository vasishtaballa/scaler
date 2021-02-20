package com.scaler.academy.assignment.sep25;

// Question: https://www.interviewbit.com/problems/excel-column-number/

public class ExcelColumnNumber {

	public static void main(String[] args) {
		ExcelColumnNumber obj = new ExcelColumnNumber();
		System.out.println(obj.titleToNumber("AA"));
	}

	public int titleToNumber(String A) {
		int result = 0;
		for (int i = A.length() - 1, index = 0; i > -1; i--, index++) {
			char ch = A.charAt(i);
			result += Math.pow(26, index) * (ch - 64);
		}
		return result;
	}

}
