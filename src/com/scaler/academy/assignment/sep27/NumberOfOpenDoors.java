package com.scaler.academy.assignment.sep27;

// Question: https://www.interviewbit.com/problems/number-of-open-doors/ 

public class NumberOfOpenDoors {

	public static void main(String[] args) {
		NumberOfOpenDoors obj = new NumberOfOpenDoors();
		System.out.println(obj.solve(20));
	}

	public int solve(int A) {
		int count = 0;
		for (int i = 1; i <= A; i++) {
			double squareRoot = Math.sqrt(i);
			if (squareRoot - Math.floor(squareRoot) == 0)
				count += 1;
		}
		return count;
	}

}
