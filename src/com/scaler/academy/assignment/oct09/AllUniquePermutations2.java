package com.scaler.academy.assignment.oct09;

// Question: https://www.interviewbit.com/problems/all-unique-permutations/

import com.scaler.academy.assignment.util.ArrayUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AllUniquePermutations2 {

    public static void main(String[] args) {
        AllUniquePermutations2 obj = new AllUniquePermutations2();
        int[] array = {1, 2, 2};
        ArrayList<ArrayList<Integer>> result = obj.permute((ArrayList<Integer>) ArrayUtils.getListFromArray(array));
        for (ArrayList<Integer> integers : result)
            System.out.println(integers.toString());
    }

    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        permuteUtil(A, 0, result);
        return result;
    }

    private void permuteUtil(ArrayList<Integer> list, int index, ArrayList<ArrayList<Integer>> result) {
        if (index == list.size()) {
            result.add((ArrayList<Integer>) list.clone());
            return;
        }
        Map<Integer, Boolean> occurrenceMap = new HashMap<>();
        for (int i = index; i < list.size(); i++) {
            if (!occurrenceMap.containsKey(list.get(i))) {
                occurrenceMap.put(list.get(i), true);
                swap(list, index, i);
                permuteUtil(list, index + 1, result);
                swap(list, index, i);
            }
        }
    }

    private static void swap(ArrayList<Integer> list, int src, int dest) {
        int temp = list.get(src);
        list.set(src, list.get(dest));
        list.set(dest, temp);
    }
}
