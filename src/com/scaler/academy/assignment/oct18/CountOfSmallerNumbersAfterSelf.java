package com.scaler.academy.assignment.oct18;

// Question: https://leetcode.com/problems/count-of-smaller-numbers-after-self/

import com.scaler.academy.assignment.util.ArrayUtils;

import java.util.ArrayList;
import java.util.List;

public class CountOfSmallerNumbersAfterSelf {
    public static void main(String[] args) {
        CountOfSmallerNumbersAfterSelf obj = new CountOfSmallerNumbersAfterSelf();
        int[] array = {1, 5, 4, 2, 1};
        List<Integer> result = obj.solve((ArrayList<Integer>) ArrayUtils.getListFromArray(array));
        System.out.println(result.toString());
    }

    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < A.size(); i++) {
            int count = 0;
            for (int j = i + 1; j < A.size(); j++) {
                if (A.get(j) < A.get(i))
                    count++;
            }
            result.add(count);
        }
        return result;
    }
}
