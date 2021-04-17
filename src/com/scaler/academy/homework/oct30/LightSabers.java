package com.scaler.academy.homework.oct30;

/*
Lightsabers
Given two array of integers A and B of size N and M respectively.

The goal is to select some continuous interval in A such that there are exactly B[0] elements with value 1, B[1] elements with value 2 and so on ending with B[m-1] elements with value m.

However, it is not always possible to select such an interval form the given array therefore it is allowed to remove some elements from A in order to achieve the goal.

Find and return the minimum number of elements to be removed from A in order to achieve the goal. If it is not possible to achieve the goal return -1 instead.


Input Format

The first argument given is the integer array A.
The second argument given is the integer array B.
Output Format

Return the minimum number of elements to be removed from A in order to achieve the goal and
if it is not possible to achieve the goal return -1 instead.
Constraints

1 <= N, M <= 100000
1 <= A[i] <= M
0 <= B[i] <= N
For Example

Input 1:
    A = [1, 2, 3, 4, 1]
    B = [2, 1, 1, 0]
Output 1:
    1   (Reomve element 4 and consider all the remaining elements).

Input 2:
    A = [1, 1, 2, 2, 2]
    B = [1, 2, 1]
Output 2:
    -1
 */

import com.scaler.academy.assignment.util.ArrayUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LightSabers {

    public static void main(String[] args) {
        LightSabers obj = new LightSabers();
        int[] array1 = {3, 3, 3, 3, 3, 4, 2, 1, 1, 3, 1, 2, 1, 1, 4, 4, 1, 1, 1, 2, 1, 2, 3, 3, 3, 2, 2, 2, 4};
        int[] array2 = {2, 0, 4, 0};
        System.out.println(
                obj.solve(
                        (ArrayList<Integer>) ArrayUtils.getListFromArray(array1),
                        (ArrayList<Integer>) ArrayUtils.getListFromArray(array2)));
    }

    public int solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        int reqTotalCount = B.stream().reduce(Integer::sum).get(); // Total number of elements that are required in the result
        int left = 0, right = 0, currentCount = 0, result = Integer.MAX_VALUE;
        for (; right < A.size(); right++) {
            int noOfIndElementsRequired = B.get(A.get(right) - 1); // How many number of this elements are required in the result
            if (noOfIndElementsRequired != 0) {
                // If this element is required in the result, then update the map that we have encountered one such element so far
                frequencyMap.put(A.get(right), frequencyMap.getOrDefault(A.get(right), 0) + 1);
                // If all the elements are already considered in the result, don't contribute to the currentCount
                if (frequencyMap.get(A.get(right)) <= noOfIndElementsRequired)
                    currentCount++;
            }
            // If we have covered all the required elements in the window, then check if we can shrink the window
            while (left < right && currentCount == reqTotalCount) {
                if (result > right - left + 1)
                    result = right - left + 1;
                // Shrink from left side
                // If left side element is required in the result, then only process, else we can simply skip this element
                if (B.get(A.get(left) - 1) != 0) {
                    // If this element is already encountered in the result required number of times, if we shrink we should reduce the count
                    if (frequencyMap.get(A.get(left)) == B.get(A.get(left) - 1))
                        currentCount--;
                    frequencyMap.put(A.get(left), frequencyMap.get(A.get(left)) - 1);
                }
                left++;
            }
        }
        return result == Integer.MAX_VALUE ? -1 : result - reqTotalCount;
    }

}
