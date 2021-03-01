package com.scaler.academy.homework.oct09;

// Question: https://www.interviewbit.com/problems/combination-sum-ii/

import com.scaler.academy.assignment.util.ArrayUtils;

import java.util.ArrayList;
import java.util.Collections;

public class CombinationSumII {

    public static void main(String[] args) {
        CombinationSumII obj = new CombinationSumII();
        int[] array = {2, 1, 3};
        ArrayList<ArrayList<Integer>> result = obj.combinationSum((ArrayList<Integer>) ArrayUtils.getListFromArray(array), 5);
        for (ArrayList<Integer> list : result)
            System.out.println(list.toString());
    }

    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> a, int b) {
        Collections.sort(a);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> aux = new ArrayList<>();
        combinationSumUtil(a, b, aux, result, 0);
        return result;
    }

    private void combinationSumUtil(ArrayList<Integer> list, int target, ArrayList<Integer> aux, ArrayList<ArrayList<Integer>> result, int index) {
        if (target == 0) {
            result.add((ArrayList<Integer>) aux.clone());
            return;
        }
        if (target < 0)
            return;
        for (int i = index; i < list.size(); i++) {
            if (i != index && list.get(i - 1) == list.get(i)) // To check previous and current are same. If same, no need to handle
                continue;
            aux.add(list.get(i));
            combinationSumUtil(list, target - list.get(i), aux, result, i + 1);
            aux.remove(aux.size() - 1);
        }
    }
}
