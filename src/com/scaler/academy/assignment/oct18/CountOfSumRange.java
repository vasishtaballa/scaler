package com.scaler.academy.assignment.oct18;

// Question: https://leetcode.com/problems/count-of-range-sum/

import com.scaler.academy.assignment.util.ArrayUtils;

import java.util.ArrayList;

public class CountOfSumRange {
    public static void main(String[] args) {
        CountOfSumRange obj = new CountOfSumRange();
        int[] array = {-2147483647,0,-2147483647,2147483647};
        System.out.println(obj.solve((ArrayList<Integer>) ArrayUtils.getListFromArray(array), -564, 3863));
    }

    public int solve(ArrayList<Integer> A, int B, int C) {
        int result = 0;
        for (int i = 0; i < A.size(); i++) {
            Long sum = new Long(0);
            for (int j = i; j < A.size(); j++) {
                sum += A.get(j);
                if (sum >= B && sum <= C)
                    result += 1;
            }
        }
        return result;
    }
}
