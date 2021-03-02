package com.scaler.academy.homework.oct09;

// Question: https://www.interviewbit.com/problems/subsets-ii/

import com.scaler.academy.assignment.util.ArrayUtils;

import java.util.ArrayList;
import java.util.Collections;

public class SubsetsII {
    public static void main(String[] args) {
        SubsetsII obj = new SubsetsII();
        int[] array = {1, 2, 2};
        ArrayList<ArrayList<Integer>> result = obj.subsetsWithDup((ArrayList<Integer>) ArrayUtils.getListFromArray(array));
        for (ArrayList<Integer> list : result)
            System.out.println(list.toString());
    }

    public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> A) {
        Collections.sort(A);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> aux = new ArrayList<>();
        result.add(new ArrayList<>());
        subsetsWithDupUtil(A, aux, result, 0);
        return result;
    }

    private void subsetsWithDupUtil(ArrayList<Integer> list, ArrayList<Integer> aux, ArrayList<ArrayList<Integer>> result, int index) {
        if (index == list.size())
            return;
        for (int i = index; i < list.size(); i++) {
            if (i != index && list.get(i) == list.get(i - 1))
                continue;
            aux.add(list.get(i));
            result.add((ArrayList<Integer>) aux.clone());
            subsetsWithDupUtil(list, aux, result, i + 1);
            aux.remove(aux.size() - 1);
        }
    }
}
