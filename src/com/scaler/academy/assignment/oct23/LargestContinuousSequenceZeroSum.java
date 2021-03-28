package com.scaler.academy.assignment.oct23;

// Question: https://www.interviewbit.com/problems/largest-continuous-sequence-zero-sum/

import com.scaler.academy.assignment.util.ArrayUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LargestContinuousSequenceZeroSum {
    public static void main(String[] args) {
        LargestContinuousSequenceZeroSum obj = new LargestContinuousSequenceZeroSum();
        int[] array = {10, -3, -9, -10, 9, -26, 7, -2, -20, -19, -9, 7, 13, -5, -8, -24, -11, 28, 28, 24};
        // 10   7  -2  -12 -3  -29 -22 -24 -44  -63 -72 -65 -52 -57 -65 -89 -100 -72 -44  20
        List<Integer> result = obj.lszero((ArrayList<Integer>) ArrayUtils.getListFromArray(array));
        System.out.println(result.toString());
    }

    public ArrayList<Integer> lszero(ArrayList<Integer> A) {
        ArrayList<Integer> result = new ArrayList<>();
        Map<Integer, Integer> occurrenceMap = new HashMap<>();
        occurrenceMap.put(0, -1);
        int sum = 0, start = -1, end = -1, maxLength = -1;
        for (int i = 0; i < A.size(); i++) {
            sum += A.get(i);
            if (occurrenceMap.containsKey(sum)) {
                if (i - occurrenceMap.get(sum) > maxLength) {
                    maxLength = (i - occurrenceMap.get(sum));
                    start = occurrenceMap.get(sum) + 1;
                    end = i;
                }
            } else
                occurrenceMap.put(sum, i);
        }
        if (start >= 0 && end >= 0)
            for (int i = start; i <= end; i++) result.add(A.get(i));
        return result;
    }
}
