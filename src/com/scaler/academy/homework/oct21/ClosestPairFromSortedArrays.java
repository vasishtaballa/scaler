package com.scaler.academy.homework.oct21;

import com.scaler.academy.assignment.util.ArrayUtils;

import java.util.ArrayList;
import java.util.List;

// Question: https://www.geeksforgeeks.org/given-two-sorted-arrays-number-x-find-pair-whose-sum-closest-x/

public class ClosestPairFromSortedArrays {

    public static void main(String[] args) {
        ClosestPairFromSortedArrays obj = new ClosestPairFromSortedArrays();
        int[] array1 = {1};
        int[] array2 = {2, 4};
        List<Integer> result = obj.solve((ArrayList<Integer>) ArrayUtils.getListFromArray(array1), (ArrayList<Integer>) ArrayUtils.getListFromArray(array2), 4);
        System.out.println(result.toString());
    }

    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B, int C) {
        int minDiff = Integer.MAX_VALUE;
        int left = 0, right = B.size() - 1;
        ArrayList<Integer> result = new ArrayList<>();
        result.add(null);
        result.add(null);
        while (left < A.size() && right >= 0) {
            int diff = Math.abs(A.get(left) + B.get(right) - C);
            if (diff < minDiff) {
                minDiff = diff;
                result.set(0, A.get(left));
                result.set(1, B.get(right));
            } else if (diff == minDiff && result.get(0) == A.get(left))
                result.set(1, B.get(right));
            if (A.get(left) + B.get(right) < C) left++;
            else right--;
        }
        return result;
    }
}
