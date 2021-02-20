package com.scaler.academy.assignment.sep27;

// Question: https://www.interviewbit.com/problems/day-of-the-week/

public class DayOfTheWeek {

	public static void main(String[] args) {
		DayOfTheWeek obj = new DayOfTheWeek();
		System.out.println(obj.solve(26, 07, 1996));
	}

	public String solve(int A, int B, int C) {
		int[] differences = { 0, 3, 2, 5, 0, 3, 5, 1, 4, 6, 2, 4 };
		String[] days = { "sunday", "monday", "tuesday", "wednesday", "thursday", "friday", "saturday" };
		if (B <= 2)
			C -= 1;
		int day = (C + C / 4 - C / 100 + C / 400 + differences[B - 1] + A) % 7;
		return days[day];
	}

}
