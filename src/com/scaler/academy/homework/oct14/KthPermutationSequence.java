package com.scaler.academy.homework.oct14;

// Question: https://www.interviewbit.com/problems/kth-permutation-sequence/

import java.util.ArrayList;
import java.util.List;

public class KthPermutationSequence {

    int globalTarget = 0;

    public static void main(String[] args) {
        KthPermutationSequence obj = new KthPermutationSequence();
        System.out.println("Result: " + obj.getPermutation(3, 5));
    }

    public String getPermutation(int A, int B) {
        List<Integer> list = getInitList(A);
        return getPermutationUtil(list, 0, B);
    }

    private String getPermutationUtil(List<Integer> list, int index, int target) {
        if (index == list.size()) {
            globalTarget++;
        }
        for (int i = index; i < list.size(); i++) {

        }
        return null;
    }

    private String getStringFrmList(List<Integer> list) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++)
            sb.append(list.get(i));
        return sb.toString();
    }

    private List<Integer> getInitList(int size) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < size; i++)
            list.add(i + 1);
        return list;
    }
}
