package com.scaler.academy.homework.oct16;

import com.scaler.academy.assignment.util.ArrayUtils;

import java.util.ArrayList;
import java.util.Collections;

// Question: https://www.geeksforgeeks.org/chocolate-distribution-problem/

public class ChocolateDistribution {

    public static void main(String[] args) {
        ChocolateDistribution obj = new ChocolateDistribution();
        int[] array = {3, 4, 1, 9, 56, 7, 9, 12};
        System.out.println(obj.solve((ArrayList<Integer>) ArrayUtils.getListFromArray(array), 5));
    }

    public int solve(ArrayList<Integer> A, int B) {
        if (B == 0 || A.size() == 0)
            return 0;
        int result = Integer.MAX_VALUE;
        Collections.sort(A);
        for (int i = 0, j = B - 1; j < A.size(); i++, j++)
            result = Math.min(A.get(j) - A.get(i), result);
        return result;
    }

}
