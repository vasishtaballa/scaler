package com.scaler.academy.assignment.oct16;

// Question: https://www.geeksforgeeks.org/sum-subset-differences/

import com.scaler.academy.assignment.util.ArrayUtils;

import java.util.ArrayList;
import java.util.Collections;

public class SumTheDifference {

    public static void main(String[] args) {
        SumTheDifference obj = new SumTheDifference();
        int[] array = {1, 2, 3, 4};
        System.out.println(obj.solve((ArrayList<Integer>) ArrayUtils.getListFromArray(array)));
    }

    public int solve(ArrayList<Integer> A) {
        long smallNumSum = 0, largeNumSum = 0, modValue = 1000000007;
        Collections.sort(A);
        // Converting the equation to simple form to avoid large values
        // Converting from: a1 * 2^n-1 + a2 * 2^n-2 + .....
        // To: 2(2(element) + p) + k & vice-versa for both sums
        for (int i = 0; i < A.size(); i++) {
            smallNumSum = (smallNumSum * 2) + A.get(i);
            smallNumSum %= modValue;
            largeNumSum = A.get(A.size() - i - 1) + 2 * largeNumSum;
            largeNumSum %= modValue;
        }
        return (int) ((largeNumSum - smallNumSum + modValue) % modValue);
    }

}
