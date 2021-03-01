package com.scaler.academy.assignment.oct09;

// Question: https://www.interviewbit.com/problems/combination-sum/

import com.scaler.academy.assignment.util.ArrayUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class CombinationSum {

    public static void main(String[] args) {
        CombinationSum obj = new CombinationSum();
        int[] array = {1, 1, 1, 1, 1};
        ArrayList<ArrayList<Integer>> result = obj.combinationSum((ArrayList<Integer>) ArrayUtils.getListFromArray(array), 5);
        for (ArrayList<Integer> list : result)
            System.out.println(list.toString());
    }

    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> aux = new ArrayList<>();
        Collections.sort(A);
        A = removeDuplicates(A);
        combinationSumUtil(A, B, aux, result, 0);
        return result;
    }

    public void combinationSumUtil(ArrayList<Integer> list, int target, ArrayList<Integer> aux, ArrayList<ArrayList<Integer>> result, int index) {
        if (target == 0) {
            result.add((ArrayList<Integer>) aux.clone());
            return;
        }
        if (target < 0 || (aux.size() > 0 && aux.get(aux.size() - 1) > target))
            return;
        for (int i = index; i < list.size(); i++) {
            aux.add(list.get(i));
            combinationSumUtil(list, target - list.get(i), aux, result, i);
            aux.remove(aux.size() - 1);
        }
    }

    private ArrayList<Integer> removeDuplicates(ArrayList<Integer> list) {
        Set<Integer> set = new HashSet<>();
        ArrayList<Integer> uniqueElemList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (!set.contains(list.get(i))) {
                set.add(list.get(i));
                uniqueElemList.add(list.get(i));
            }
        }
        return uniqueElemList;
    }
}
