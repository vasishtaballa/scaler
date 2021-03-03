package com.scaler.academy.assignment.util;

import java.util.ArrayList;
import java.util.List;

public class ArrayUtils {

    public static List<Integer> getListFromArray(int[] array) {
        List<Integer> list = new ArrayList<>();
        for (int i : array)
            list.add(i);
        return list;
    }

    public static List<ArrayList<Integer>> getListFromMatrix(int[][] matrix) {
        ArrayList<ArrayList<Integer>> matrixList = new ArrayList<>();
        for (int[] row : matrix) {
            matrixList.add((ArrayList<Integer>) getListFromArray(row));
        }
        return matrixList;
    }
}
