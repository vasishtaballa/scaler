package com.scaler.academy.assignment.oct30;

/*
Count Right Triangles
Problem Description

Given two arrays of integers A and B of size N each, where each pair (A[i], B[i]) for 0 <= i < N represents a unique point (x, y) in 2D Cartesian plane.

Find and return the number of unordered triplets (i, j, k) such that (A[i], B[i]), (A[j], B[j]) and (A[k], B[k]) form a right angled triangle with the triangle having one side parallel to the x-axis and one side parallel to the y-axis.

NOTE: The answer may be large so return the answer modulo (109 + 7).



Problem Constraints
1 <= N <= 105

0 <= A[i], B[i] <= 109



Input Format
The first argument given is an integer array A.
The second argument given is the integer array B.



Output Format
Return the number of unordered triplets that form a right angled triangle modulo (109 + 7).



Example Input
Input 1:

 A = [1, 1, 2]
 B = [1, 2, 1]
Input 2:

 A = [1, 1, 2, 3, 3]
 B = [1, 2, 1, 2, 1]


Example Output
Output 1:

 1
Output 2:

 6


Example Explanation
Explanation 1:

 All three points make a right angled triangle. So return 1.
Explanation 2:

 6 quadruplets which make a right angled triangle are: (1, 1), (1, 2), (2, 2)
                                                       (1, 1), (3, 1), (1, 2)
                                                       (1, 1), (3, 1), (3, 2)
                                                       (2, 1), (3, 1), (3, 2)
                                                       (1, 1), (1, 2), (3, 2)
                                                       (1, 2), (3, 1), (3, 2)
 */

import com.scaler.academy.assignment.util.ArrayUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CountRightTriangles {

    public static void main(String[] args) {
        CountRightTriangles obj = new CountRightTriangles();
        int[] array1 = {1, 1, 2, 3, 3};
        int[] array2 = {1, 2, 1, 2, 1};
        System.out.println(
                obj.solve(
                        (ArrayList<Integer>) ArrayUtils.getListFromArray(array1),
                        (ArrayList<Integer>) ArrayUtils.getListFromArray(array2)));
    }

    public int solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        /* Calculating frequency map of all X-CoOrdinates & Y-CoOrdinates array
        Then, for each point in the arrays, check for that x & y, how many lie on the same line (which could make right angle)
        and how many other points could act as third point in a right angled triangle. We can then multiply both of them */
        Map<Integer, Integer> xCoOrdinatesMap = new HashMap<>(), yCoOrdinatesMap = new HashMap<>();
        int rightTrianglesCount = 0;
        getCoOrdinatesMap(A, xCoOrdinatesMap);
        getCoOrdinatesMap(B, yCoOrdinatesMap);
        for (int i = 0; i < A.size(); i++) {
            int x = A.get(i), y = B.get(i);
            int pointsWithXCoOrdinateVal = xCoOrdinatesMap.getOrDefault(x, 0) - 1; // Minus 1 because the same point shouldn't be included twice
            int pointsWithYCoOrdinateVal = yCoOrdinatesMap.getOrDefault(y, 0) - 1;
            rightTrianglesCount += pointsWithXCoOrdinateVal * pointsWithYCoOrdinateVal; // Combinations
        }
        return rightTrianglesCount;
    }

    private void getCoOrdinatesMap(ArrayList<Integer> A, Map<Integer, Integer> xCoOrdinatesMap) {
        // Iterate each item and form occurrence of each item in the array
        for (Integer item : A) {
            if (xCoOrdinatesMap.containsKey(item))
                xCoOrdinatesMap.put(item, xCoOrdinatesMap.get(item) + 1);
            else
                xCoOrdinatesMap.put(item, 1);
        }
    }
}
