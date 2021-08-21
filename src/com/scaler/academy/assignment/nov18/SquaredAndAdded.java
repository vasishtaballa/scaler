package com.scaler.academy.assignment.nov18;

/*

Squared and added
Problem Description

You are given an array A of length N. Divide the elements of the array into two groups G1 and G2.

The power of a group is the square of the sum of all the elements. The total power is the sum of powers of both the groups.

Find the maximum possible total power. Return the answer modulo 109 + 7.



Problem Constraints
1 <= N <= 105

-109 <= A[i] <= 109



Input Format
The first and only argument given is the integer array A.



Output Format
Return the maximum value of total power.



Example Input
Input 1:

 A = [1, -3, 7, 1]
Input 2:

 A = [1, 1, 2, 2]


Example Output
Output 1:

 90
Output 2:

 36


Example Explanation
Explanation 1:

 group1 = [1, 7, 1]
 group2 = [-3]
Explanation 2:

 group1 = [1, 1, 2, 2]
 group2 = []

 */

import com.scaler.academy.assignment.util.ArrayUtils;

import java.util.ArrayList;

public class SquaredAndAdded {

    public static void main(String[] args) {
        SquaredAndAdded obj = new SquaredAndAdded();
        int[] array = new int[]{-996, 434, 29, -503, -238, -128, -920, 823, 388, -34, -816, 97, 750, 983, 16, -455, -197, 259, 426, 193, -735, 737, 634, -329, -766, 524, -40, -972, 955, 444, 795, -40, 845, 924, 414, 288, -142, 509, -937, -150, 905, 285, -1, 89, -268, 984, -137, -761, 675, 606, -154, -592, -271, 776, -292, -911, 305, 495, -510, -615, 470, 547, 975, -294, -345, 740, 147, -499, 786, 979, -553, 627, 792, 517, -59, -785, 435, -193, -992, 61, 740, 188, -838, 659, -962, -406, -233, 727, 860, -32, -81, 153, -502, -279, -834, -184, -845, -814, 412, 363};
        System.out.println(obj.solve((ArrayList<Integer>) ArrayUtils.getListFromArray(array)));
    }

    public int solve(ArrayList<Integer> A) {
        int sum1 = 0, sum2 = 0, MOD = 1000000007;
        for (Integer integer : A) {
            if (integer < 0)
                sum1 = sum1 % MOD + integer % MOD;
            else
                sum2 = sum2 % MOD + integer % MOD;
        }
        long result1 = sum1 * sum1;
        long result2 = sum2 * sum2;
        return (int) ((result1 % MOD + result2 % MOD) % MOD);
    }

}
