package com.scaler.academy.homework.sep17;

import java.util.ArrayList;

// Question: https://www.interviewbit.com/problems/set-matrix-zeros/

public class SetMatrixZeros {

	public static void main(String[] args) {
		SetMatrixZeros obj = new SetMatrixZeros();
		ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
		ArrayList<Integer> row1 = new ArrayList<>();
		row1.add(1);
		row1.add(0);
		row1.add(1);
		ArrayList<Integer> row2 = new ArrayList<>();
		row2.add(1);
		row2.add(1);
		row2.add(1);
		ArrayList<Integer> row3 = new ArrayList<>();
		row3.add(1);
		row3.add(1);
		row3.add(1);
		arrayList.add(row1);
		arrayList.add(row2);
		arrayList.add(row3);
		obj.setZeroes(arrayList);
	}

	public void setZeroes(ArrayList<ArrayList<Integer>> a) {
		int[] rows = new int[a.size()];
		int[] columns = new int[a.get(0).size()];
		for (int i = 0; i < a.size(); i++) {
			for (int j = 0; j < a.get(i).size(); j++) {
				if (a.get(i).get(j) == 0) {
					rows[i] = 1;
					columns[j] = 1;
				}
			}
		}
		for (int i = 0; i < a.size(); i++) {
			for (int j = 0; j < a.get(i).size(); j++) {
				if (rows[i] == 1 || columns[j] == 1)
					a.get(i).set(j, 0);
			}
		}
	}

}
