package com.scaler.academy.assignment.oct21;

// Question: https://www.interviewbit.com/problems/minimize-the-absolute-difference/

import com.scaler.academy.assignment.util.ArrayUtils;

import java.util.ArrayList;

public class MinimizeTheAbsoluteDifference {
    public static void main(String[] args) {
        MinimizeTheAbsoluteDifference obj = new MinimizeTheAbsoluteDifference();
        int[] array1 = {1, 4, 5, 8, 10};
        int[] array2 = {6, 9, 15};
        int[] array3 = {2, 3, 6, 6};
        System.out.println(
                obj.solve(
                        (ArrayList<Integer>) ArrayUtils.getListFromArray(array1),
                        (ArrayList<Integer>) ArrayUtils.getListFromArray(array2),
                        (ArrayList<Integer>) ArrayUtils.getListFromArray(array3)
                )
        );
    }

    public int solve(ArrayList<Integer> A, ArrayList<Integer> B, ArrayList<Integer> C) {
        int aPtr = 0, bPtr = 0, cPtr = 0;
        int minDiff = getValue(A.get(0), B.get(0), C.get(0));
        while (aPtr < A.size() && bPtr < B.size() && cPtr < C.size()) {
            minDiff = Math.min(minDiff, getValue(A.get(aPtr), B.get(bPtr), C.get(cPtr)));
            if (getMin(A.get(aPtr), B.get(bPtr), C.get(cPtr)) == A.get(aPtr)) aPtr++;
            else if (getMin(A.get(aPtr), B.get(bPtr), C.get(cPtr)) == B.get(bPtr)) bPtr++;
            else cPtr++;
        }
        return minDiff;
    }

    public int getValue(int a, int b, int c) {
        return getAbsDiff(getMax(a, b, c), getMin(a, b, c));
    }

    public int getAbsDiff(int a, int b) {
        return Math.abs(a - b);
    }

    public int getMin(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }

    public int getMax(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }
}
