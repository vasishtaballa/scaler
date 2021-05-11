package com.scaler.academy.assignment.dec14;

// Question:

import com.scaler.academy.assignment.util.ArrayUtils;

import java.util.ArrayList;

public class MinimumPicks {

    public static void main(String[] args) {
        MinimumPicks obj = new MinimumPicks();
        int[] array = {5, 17, 100, 1};
        System.out.println(obj.solve((ArrayList<Integer>) ArrayUtils.getListFromArray(array)));
    }

    public int solve(ArrayList<Integer> A) {
        int maxEven = Integer.MIN_VALUE, minOdd = Integer.MAX_VALUE;
        for (int i = 0; i < A.size(); i++) {
            int number = A.get(i);
            if (number % 2 == 0)
                maxEven = Math.max(maxEven, number);
            else
                minOdd = Math.min(minOdd, number);
        }
        return maxEven - minOdd;
    }

}
