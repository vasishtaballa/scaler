package com.scaler.academy.homework.oct23;

/*
Find pairs in array whose sum is already present
Given an array A of N distinct and positive elements, the task is to find number of unordered pairs whose sum already exists in given array.

Expected Complexity : n^2

CONSTRAINTS

1 <= N <= 1000
1 <= A[i] <= 10^6 + 5
SAMPLE INPUT

A : [ 3, 4, 2, 6 ,7]
SAMPLE OUTPUT

2
EXPLANATION

The pairs following the conditions are :
(2,4) = 6,
(3,4) = 7
 */

import com.scaler.academy.assignment.util.ArrayUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class FindPairsWhoseSumIsPresent {
    public static void main(String[] args) {
        FindPairsWhoseSumIsPresent obj = new FindPairsWhoseSumIsPresent();
        int[] array = {3, 4, 2, 6, 7};
        System.out.println(obj.solve((ArrayList<Integer>) ArrayUtils.getListFromArray(array)));
    }

    public int solve(ArrayList<Integer> A) {
        int count = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < A.size(); i++)
            set.add(A.get(i));
        for (int i = 0; i < A.size(); i++) {
            for (int j = i + 1; j < A.size(); j++) {
                int sum = A.get(i) + A.get(j);
                if (set.contains(sum))
                    count++;
            }
        }
        return count;
    }
}
