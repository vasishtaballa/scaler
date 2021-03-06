package com.scaler.academy.homework.oct14;

// Question: https://www.interviewbit.com/problems/kth-permutation-sequence/

import java.util.ArrayList;

public class KthPermutationSequence {

    public static void main(String[] args) {
        KthPermutationSequence obj = new KthPermutationSequence();
        System.out.println(obj.getPermutation(3, 4));
    }

    public String getPermutation(int A, int B) {
        ArrayList<Integer> list = getInitList(A);
        StringBuilder sb = new StringBuilder();
        getPermutationUtil(0, A, B - 1, list, sb);
        return sb.toString();
    }

    public String getPermutationUtil(int index, int size, int target, ArrayList<Integer> list, StringBuilder sb) {
        if (index == size)
            return sb.toString();
        int factorial = factorial(size - index - 1, target);
        int idx = factorial == 0 ? 0 : target / factorial; // Which index could be fixed now
        target -= idx * factorial; // Updating the target with already eliminated items
        sb.append(list.get(idx));
        list.remove(list.get(idx));
        return getPermutationUtil(index + 1, size, target, list, sb);
    }

    private int factorial(int num, int target) {
        int factorial = 1;
        while (num > 0) {
            factorial *= num;
            num--;
            if (factorial > target)
                return 0;
        }
        return factorial;
    }

    private ArrayList<Integer> getInitList(int size) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < size; i++)
            list.add(i + 1);
        return list;
    }
}
