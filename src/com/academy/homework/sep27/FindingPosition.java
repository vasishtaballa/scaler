package com.academy.homework.sep27;

// Question: https://www.interviewbit.com/problems/finding-position/

public class FindingPosition {

	public static void main(String[] args) {
		FindingPosition obj = new FindingPosition();
		System.out.println(obj.solve(20));
	}

	public int solve(int A) {
		int result = 0;
		while (A > 1) {
			result += 1;
			A /= 2;
		}
		return (int) Math.pow(2, result);
	}

}
