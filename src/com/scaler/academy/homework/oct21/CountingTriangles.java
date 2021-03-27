package com.scaler.academy.homework.oct21;

// Question: https://www.interviewbit.com/problems/counting-triangles/

import com.scaler.academy.assignment.util.ArrayUtils;

import java.util.ArrayList;
import java.util.Collections;

public class CountingTriangles {
    public static void main(String[] args) {
        CountingTriangles obj = new CountingTriangles();
        int[] array = {4, 6, 3, 7};
        System.out.println(obj.nTriang((ArrayList<Integer>) ArrayUtils.getListFromArray(array)));
    }

    public int nTriang(ArrayList<Integer> A) {
        Collections.sort(A);
        int count = 0, MOD_VALUE = 1000000007;
        for (int i = 0; i < A.size(); i++) {
            int k = i + 2;
            for (int j = i + 1; j < A.size(); j++) {
                while (k < A.size() && A.get(i) + A.get(j) > A.get(k)) k++;
                count += (k - j - 1);
                count %= MOD_VALUE;
            }
        }
        return count;
    }
}
