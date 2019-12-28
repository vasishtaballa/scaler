package com.academy.assignment.nov08;

// Question: https://www.interviewbit.com/problems/gas-station/

public class GasStation {

	public static void main(String[] args) {
		GasStation obj = new GasStation();
		int[] petrol = { 1, 2, 3, 4, 5 };
		int[] distance = { 3, 4, 5, 1, 2 };
		System.out.println(obj.canCompleteCircuit(petrol, distance));
	}

	public int canCompleteCircuit(final int[] A, final int[] B) {
		int excessPetrol = 0, deficientPetrol = 0, start = 0;
		for (int i = 0; i < A.length; i++) {
			excessPetrol = excessPetrol + A[i] - B[i];
			if (excessPetrol < 0) {
				deficientPetrol += excessPetrol;
				start = i + 1;
				excessPetrol = 0;
			}
		}
		return excessPetrol + deficientPetrol >= 0 ? start : -1;
	}

}
