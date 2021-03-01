package com.scaler.academy.assignment.oct09;

// Question: https://www.interviewbit.com/problems/subset/

import com.scaler.academy.assignment.util.ArrayUtils;

import java.util.ArrayList;
import java.util.Collections;

public class Subset {

    public static void main(String[] args) {
        Subset obj = new Subset();
        int[] array = {1, 2, 3, 3};
        ArrayList<ArrayList<Integer>> result = obj.subsets((ArrayList<Integer>) ArrayUtils.getListFromArray(array));
        for (ArrayList<Integer> list : result)
            System.out.println(list.toString());
    }

    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        Collections.sort(A);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> aux = new ArrayList<>();
        result.add(aux);
        subsetsUtil(A, 0, result, aux);
        return result;
    }

    private void subsetsUtil(ArrayList<Integer> list, int index, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> aux) {
        if (index == list.size()) {
            return;
        }
        for (int i = index; i < list.size(); i++) {
            aux.add(list.get(i));
            result.add((ArrayList<Integer>) aux.clone());
            subsetsUtil(list, i + 1, result, aux);
            aux.remove(aux.size() - 1);
        }
    }
}
