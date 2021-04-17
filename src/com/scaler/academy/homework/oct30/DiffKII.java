package com.scaler.academy.homework.oct30;

// Question: https://www.interviewbit.com/problems/diffk-ii/

import com.scaler.academy.assignment.util.ArrayUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DiffKII {

    public static void main(String[] args) {
        DiffKII obj = new DiffKII();
        int[] array = {1, 3, 2};
        System.out.println(obj.diffPossible(ArrayUtils.getListFromArray(array), 0));
    }

    public int diffPossible(final List<Integer> A, int B) {
        // If the size is less than 2 no point of checking further
        if (A.size() < 2)
            return 0;
        Map<Integer, Integer> elementToIdxMap = new HashMap<>();
        // Populating the element to index map
        for (int i = 0; i < A.size(); i++)
            elementToIdxMap.put(A.get(i), i);
        for (int i = 0; i < A.size(); i++) {
            // If the sum of this element and B is already there in map, then return true
            // Second condition is to verify if this is not the same index that we are checking
            if (elementToIdxMap.containsKey(A.get(i) + B) && i != elementToIdxMap.get(A.get(i) + B))
                return 1;
        }
        return 0;
    }
}
