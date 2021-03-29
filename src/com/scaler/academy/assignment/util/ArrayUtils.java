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

    public static ArrayList<ArrayList<Character>> getListFromMatrix(char[][] board) {
        ArrayList<ArrayList<Character>> matrixList = new ArrayList<>();
        for (char[] row : board)
            matrixList.add((ArrayList<Character>) getListFromArray(row));
        return matrixList;
    }

    public static List<Character> getListFromArray(char[] array) {
        List<Character> list = new ArrayList<>();
        for (char i : array)
            list.add(i);
        return list;
    }

    public static List<String> getListFromArray(String[] array) {
        List<String> list = new ArrayList<>();
        for (String i : array)
            list.add(i);
        return list;
    }
}
