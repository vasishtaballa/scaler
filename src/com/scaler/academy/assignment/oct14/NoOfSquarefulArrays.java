package com.scaler.academy.assignment.oct14;

// Question: https://leetcode.com/problems/number-of-squareful-arrays/

import com.scaler.academy.assignment.util.ArrayUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class NoOfSquarefulArrays {

    int count = 0;

    public static void main(String[] args) {
        NoOfSquarefulArrays obj = new NoOfSquarefulArrays();
        int[] array = {428, 56, 88, 12};
        System.out.println(obj.solve((ArrayList<Integer>) ArrayUtils.getListFromArray(array)));
    }

    public int solve(ArrayList<Integer> A) {
        if (A.size() == 1)
            return 0;
        Collections.sort(A);
        solveUtil(A, 0);
        return count;
    }

    private void solveUtil(ArrayList<Integer> list, int index) {
        if (index == list.size()) {
            count++;
            return;
        }
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = index; i < list.size(); i++) {
            if (areTwoSquareful(list, index - 1, i) && !hashSet.contains(list.get(i))) {
                hashSet.add(list.get(i));
                Collections.swap(list, i, index);
                solveUtil(list, index + 1);
                Collections.swap(list, i, index);
            }
        }
    }

    private boolean areTwoSquareful(ArrayList<Integer> list, int index1, int index2) {
        if (index1 == -1)
            return true;
        return areSquareful(list.get(index1), list.get(index2));
    }

    private boolean areSquareful(Integer number1, Integer number2) {
        int temp = number1 + number2;
        int root = (int) Math.sqrt(temp);
        return root * root == temp;
    }
}
