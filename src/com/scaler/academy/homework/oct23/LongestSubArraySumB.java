package com.scaler.academy.homework.oct23;

// Question: https://www.geeksforgeeks.org/longest-sub-array-sum-k/

import com.scaler.academy.assignment.util.ArrayUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LongestSubArraySumB {
    public static void main(String[] args) {
        LongestSubArraySumB obj = new LongestSubArraySumB();
        int[] array = {1, 2, 3, 4, 5};
        System.out.println(obj.solve((ArrayList<Integer>) ArrayUtils.getListFromArray(array), 10));
    }

    public int solve(ArrayList<Integer> A, int B) {
        Map<Integer, Integer> occurrenceIndex = new HashMap<>();
        occurrenceIndex.put(B, -1);
        int maxLength = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < A.size(); i++) {
            sum += A.get(i);
            if (occurrenceIndex.containsKey(sum)) {
                if (i - occurrenceIndex.get(sum) > maxLength) {
                    maxLength = i - occurrenceIndex.get(sum);
                }
            } else {
                
            }
        }
        return 0;
    }
}
