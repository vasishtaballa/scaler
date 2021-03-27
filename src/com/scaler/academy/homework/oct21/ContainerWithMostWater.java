package com.scaler.academy.homework.oct21;

// Question: https://leetcode.com/problems/container-with-most-water/

import com.scaler.academy.assignment.util.ArrayUtils;

import java.util.ArrayList;

public class ContainerWithMostWater {

    public static void main(String[] args) {
        ContainerWithMostWater obj = new ContainerWithMostWater();
        int[] array = {1, 5, 4, 3};
        System.out.println(obj.maxArea((ArrayList<Integer>) ArrayUtils.getListFromArray(array)));
    }

    public int maxArea(ArrayList<Integer> A) {
        if (A.size() <= 1)
            return 0;
        int maxArea = Integer.MIN_VALUE, left = 0, right = A.size() - 1;
        while (left < right) {
            maxArea = Math.max(maxArea, (right - left) * Math.min(A.get(left), A.get(right)));
            if (A.get(left) <= A.get(right)) left++;
            else right--;
        }
        return maxArea;
    }
}
