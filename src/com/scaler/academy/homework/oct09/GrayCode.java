package com.scaler.academy.homework.oct09;

// Question: https://www.interviewbit.com/problems/gray-code/

import java.util.ArrayList;
import java.util.List;

public class GrayCode {

    public static void main(String[] args) {
        GrayCode obj = new GrayCode();
        System.out.println(obj.grayCode(3).toString());
    }

    public ArrayList<Integer> grayCode(int a) {
        ArrayList<ArrayList<Integer>> aux = new ArrayList<>();
        aux.add((ArrayList<Integer>) getListFromArray(new int[]{0}));
        aux.add((ArrayList<Integer>) getListFromArray(new int[]{1}));
        ArrayList<ArrayList<Integer>> binaryResult = grayCodeUtil(a, aux);
        return getDecimalResult(binaryResult);
    }

    private ArrayList<Integer> getDecimalResult(ArrayList<ArrayList<Integer>> binaryResult) {
        ArrayList<Integer> result = new ArrayList<>();
        for (ArrayList<Integer> list : binaryResult) {
            int decimal = 0;
            for (int i = 0, j = list.size() - 1; i < list.size() && j >= 0; i++, j--)
                decimal += Math.pow(2, j) * list.get(i);
            result.add(decimal);
        }
        return result;
    }

    private ArrayList<ArrayList<Integer>> grayCodeUtil(int size, ArrayList<ArrayList<Integer>> aux) {
        if (size == 1) {
            return (ArrayList<ArrayList<Integer>>) aux.clone();
        }
        ArrayList<ArrayList<Integer>> temp = grayCodeUtil(size - 1, aux);
        aux.clear();
        for (int i = 0; i < Math.pow(2, size - 1); i++) {
            // Starting with zeroes
            aux.add((ArrayList<Integer>) getListFromArray(new int[]{0}));
            aux.get(i).addAll(temp.get(i));
        }
        for (int i = (int) Math.pow(2, size - 1), j = (int) Math.pow(2, size - 1) - 1; j >= 0; i++, j--) {
            // Starting with ones
            aux.add((ArrayList<Integer>) getListFromArray(new int[]{1}));
            aux.get(i).addAll(temp.get(j));
        }
        return (ArrayList<ArrayList<Integer>>) aux.clone();
    }

    private List<Integer> getListFromArray(int[] array) {
        List<Integer> list = new ArrayList<>();
        for (int i : array)
            list.add(i);
        return list;
    }
}
