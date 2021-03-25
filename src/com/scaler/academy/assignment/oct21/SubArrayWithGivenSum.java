package com.scaler.academy.assignment.oct21;

/*
Subarray with given sum
Problem Description

Given an array of positive integers A and an integer B, find and return first continuous subarray which adds to B.

If the answer does not exist return an array with a single element "-1".

First sub-array means the sub-array for which starting index in minimum.



Problem Constraints
1 <= length of the array <= 100000
1 <= A[i] <= 109
1 <= B <= 109



Input Format
The first argument given is the integer array A.

The second argument given is integer B.



Output Format
Return the first continuous sub-array which adds to B and if the answer does not exist return an array with a single element "-1".



Example Input
Input 1:

 A = [1, 2, 3, 4, 5]
 B = 5
Input 2:

 A = [5, 10, 20, 100, 105]
 B = 110


Example Output
Output 1:

 [2, 3]
Output 2:

 -1


Example Explanation
Explanation 1:

 [2, 3] sums up to 5.
Explanation 2:

 No subarray sums up to required number.
 */

import com.scaler.academy.assignment.util.ArrayUtils;

import java.util.ArrayList;
import java.util.List;

public class SubArrayWithGivenSum {
    public static void main(String[] args) {
        SubArrayWithGivenSum obj = new SubArrayWithGivenSum();
        int[] array = {1, 1000000000};
        List<Integer> result = obj.solve((ArrayList<Integer>) ArrayUtils.getListFromArray(array), 1000000000);
        System.out.println(result.toString());
    }

    public ArrayList<Integer> solve(ArrayList<Integer> A, int B) {
        ArrayList<Integer> result = new ArrayList<>();
        int left = 0, right = 0, sum = 0;
        while (left < A.size() && right < A.size()) {
            while (right < A.size() && sum < B) {
                sum += A.get(right);
                right++;
            }
            while (left < A.size() && sum > B) {
                sum -= A.get(left);
                left++;
            }
            if (sum == B)
                break;
        }
        if (sum == B) {
            while (left < right) {
                result.add(A.get(left));
                left++;
            }
        } else
            result.add(-1);
        return result;
    }
}
