package com.scaler.academy.homework.oct14;

// Question: https://www.interviewbit.com/problems/kth-permutation-sequence/

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class KthPermutationSequence {

    int globalTarget = 0;

    public static void main(String[] args) {
        KthPermutationSequence obj = new KthPermutationSequence();
        System.out.println(obj.getPermutation(3, 5));
    }

    public String getPermutation(int A, int B) {
        ArrayList<Integer> list = getInitList(A);
        ArrayList<Integer> aux = new ArrayList<>();
        HashSet<Integer> hashSet = new HashSet<>();
        return getPermutationUtil(list, aux, 0, hashSet, B);
    }

    private String getPermutationUtil(ArrayList<Integer> list, ArrayList<Integer> aux, int index, HashSet<Integer> hashSet, int target) {
        if (index == list.size()) {
            globalTarget++;
            if (globalTarget == target)
                return getStringFrmList((List<Integer>) aux.clone());
        }
        for (int i = 0; i < list.size(); i++) {
            if (!hashSet.contains(list.get(i))) {
                hashSet.add(list.get(i));
                aux.add(list.get(i));
                String ans = getPermutationUtil(list, aux, index + 1, hashSet, target);
                if (ans != null)
                    return ans;
                hashSet.remove(list.get(i));
                aux.remove(aux.size() - 1);
            }
        }
        return null;
    }

    private String getStringFrmList(List<Integer> list) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++)
            sb.append(list.get(i));
        return sb.toString();
    }

    private ArrayList<Integer> getInitList(int size) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < size; i++)
            list.add(i + 1);
        return list;
    }
}
