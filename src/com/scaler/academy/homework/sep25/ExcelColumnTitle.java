package com.scaler.academy.homework.sep25;

// Question: https://www.interviewbit.com/problems/excel-column-title/ 

public class ExcelColumnTitle {

	public static void main(String[] args) {
		ExcelColumnTitle obj = new ExcelColumnTitle();
		System.out.println(obj.convertToTitle(52));
	}

	public String convertToTitle(int A) {
		String result = "";
		while (A > 26) {
			int value = A % 26;
			if (A % 26 == 0) {
				value = 26;
				A -= 1;
			}
			result = (char) (value + 64) + result;
			A /= 26;
		}
		return (char) (A + 64) + result;
	}

}
