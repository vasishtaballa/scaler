package com.scaler.academy.assignment.oct21;

// Question: https://www.geeksforgeeks.org/count-pairs-with-given-sum-set-2/

import com.scaler.academy.assignment.util.ArrayUtils;

import java.util.ArrayList;

public class CountOfPairsWithGivenSum {
    public static void main(String[] args) {
        CountOfPairsWithGivenSum obj = new CountOfPairsWithGivenSum();
        int[] array = {1, 4, 4, 5, 5, 5, 6, 6, 11};
        System.out.println(obj.solve((ArrayList<Integer>) ArrayUtils.getListFromArray(array), 10));
    }

    public int solve(ArrayList<Integer> A, int B) {
        int count = 0;
        int left = 0, right = A.size() - 1;
        while (left < right) {
            int sum = A.get(left) + A.get(right);
            if (sum > B)
                right--;
            else if (sum < B)
                left++;
            else {
                if (A.get(left) == A.get(right)) {
                    count += nCr(right - left + 1, 2);
                    break;
                } else {
                    int leftIndex = left, rightIndex = right;
                    while (A.get(left) == A.get(leftIndex)) left++;
                    while (A.get(right) == A.get(rightIndex)) right--;
                    count += (left - leftIndex) * (rightIndex - right);
                }
            }
        }
        return count;
    }

    private int nCr(int n, int r) {
        return factorial(n) / (factorial(n - r) * factorial(r));
    }

    private int factorial(int number) {
        int factorial = 1;
        while (number >= 2) {
            factorial *= number;
            number--;
        }
        return factorial;
    }
}
