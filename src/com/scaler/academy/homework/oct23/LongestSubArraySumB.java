package com.scaler.academy.homework.oct23;

// Question: https://www.geeksforgeeks.org/longest-sub-array-sum-k/

import com.scaler.academy.assignment.util.ArrayUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LongestSubArraySumB {
    public static void main(String[] args) {
        LongestSubArraySumB obj = new LongestSubArraySumB();
        int[] array = {-4, 0, -3, -2, 3, 2, 5, 0, -2, 4};
        System.out.println(obj.solve((ArrayList<Integer>) ArrayUtils.getListFromArray(array), 2));
    }

    public int solve(ArrayList<Integer> A, int B) {
        Map<Integer, Integer> occurrenceIndex = new HashMap<>();
        occurrenceIndex.put(0, -1);
        int maxLength = -1, sum = 0, start = -1, end = -1;
        for (int i = 0; i < A.size(); i++) {
            sum += A.get(i);
            if (sum == B)
                maxLength = i + 1;
            if (!occurrenceIndex.containsKey(sum))
                occurrenceIndex.put(sum, i);
            if (occurrenceIndex.containsKey(sum - B)) {
                if (i - occurrenceIndex.get(sum - B) > maxLength)
                    maxLength = i - occurrenceIndex.get(sum - B);
            }
        }
        return maxLength;
    }
}
