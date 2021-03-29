package com.scaler.academy.assignment.oct23;

// Question: https://www.interviewbit.com/problems/longest-consecutive-sequence/

import com.scaler.academy.assignment.util.ArrayUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        LongestConsecutiveSequence obj = new LongestConsecutiveSequence();
        int[] array = {100, 4, 200, 1, 3, 2};
        System.out.println(obj.longestConsecutive(ArrayUtils.getListFromArray(array)));
    }

    public int longestConsecutive(final List<Integer> A) {
        int maxLength = Integer.MIN_VALUE;
        Map<Integer, Integer> occurrenceCount = new HashMap<>();
        for (int i = 0; i < A.size(); i++) {
            int number = A.get(i), prevNumber = number - 1, nextNumber = number + 1;
            int length1 = occurrenceCount.getOrDefault(prevNumber, 0), length2 = occurrenceCount.getOrDefault(nextNumber, 0);
            if (occurrenceCount.containsKey(number))
                continue;
            int currentLength = length1 + length2 + 1;
            occurrenceCount.put(number, currentLength);
            maxLength = Math.max(maxLength, currentLength);
            if (length1 > 0)
                occurrenceCount.put(number - length1, occurrenceCount.get(number));
            if (length2 > 0)
                occurrenceCount.put(number + length2, occurrenceCount.get(number));
        }
        return maxLength;
    }
}
