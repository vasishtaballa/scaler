package com.scaler.academy.assignment.oct16;

// Question: NA

import com.scaler.academy.assignment.util.ArrayUtils;

import java.util.ArrayList;
import java.util.Collections;

public class MaximumDifference {

    public static void main(String[] args) {
        MaximumDifference obj = new MaximumDifference();
        int[] array = {5, 17, 100, 11};
        System.out.println(obj.solve((ArrayList<Integer>) ArrayUtils.getListFromArray(array), 3));
    }

    public int solve(ArrayList<Integer> A, int B) {
        Collections.sort(A);
        int totalSum = A.stream().mapToInt(Integer::intValue).sum();
        int leftSum = 0, rightSum = 0;
        for (int i = 0, j = A.size() - 1; i < B; i++, j--) {
            leftSum += A.get(i);
            rightSum += A.get(j);
        }
        return Math.max(Math.abs(totalSum - 2 * leftSum), Math.abs(totalSum - 2 * rightSum));
    }
}
