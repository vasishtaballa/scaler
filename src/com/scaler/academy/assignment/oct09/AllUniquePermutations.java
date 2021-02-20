package com.scaler.academy.assignment.oct09;

// Question: https://www.interviewbit.com/problems/all-unique-permutations/


import com.scaler.academy.assignment.util.PrintUtility;

import java.util.ArrayList;

public class AllUniquePermutations {

    public static void main(String[] args) {
        AllUniquePermutations obj = new AllUniquePermutations();
        int[] array = {1, 2, 2};
        int[][] result = obj.permute(array);
        PrintUtility.printMatrix(result);
    }

    public int[][] permute(int[] A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        permuteUtil(A, 0, A.length - 1, result);
        int[][] resultArr = new int[result.size()][A.length];
        getArrFromList(resultArr, result);
        return resultArr;
    }

    private void getArrFromList(int[][] resultArr, ArrayList<ArrayList<Integer>> result) {
        int row = 0;
        for (int i = 0; i < result.size(); i++) {
            row = i;
            for (int j = 0; j < result.get(0).size(); j++)
                resultArr[i][j] = result.get(i).get(j);
        }
    }

    private void permuteUtil(int[] array, int left, int right, ArrayList<ArrayList<Integer>> result) {
        if (left == right) {
            result.add(getList(array));
            return;
        } else {
            for (int i = left; i <= right; i++) {
                if (!isDuplicate(array, left, i)) {
                    swap(array, left, i);
                    permuteUtil(array, left + 1, right, result);
                    swap(array, left, i);
                }
            }
        }
    }

    private boolean isDuplicate(int[] array, int left, int current) {
        for (int i = left; i < current; i++) {
            if (array[i] == array[current])
                return true;
        }
        return false;
    }

    private ArrayList<Integer> getList(int[] array) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++)
            list.add(array[i]);
        return list;
    }

    private void swap(int[] array, int left, int i) {
        int temp = array[left];
        array[left] = array[i];
        array[i] = temp;
    }

}
