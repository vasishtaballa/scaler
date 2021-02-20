package com.scaler.academy.homework.sep27;

// Question: https://www.interviewbit.com/problems/find-if-two-rectangles-overlap/

public class TwoRectanglesOverlap {

	public static void main(String[] args) {
		TwoRectanglesOverlap obj = new TwoRectanglesOverlap();
		System.out.println(obj.solve(0, 0, 4, 4, 2, 2, 6, 6));
	}

	public int solve(int A, int B, int C, int D, int E, int F, int G, int H) {
		if (A > G || C < E)
			return 0;
		if (D < F || B > H)
			return 0;
		return 1;
	}

}
