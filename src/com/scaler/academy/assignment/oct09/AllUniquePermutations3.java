package com.scaler.academy.assignment.oct09;

// Question: https://www.interviewbit.com/problems/all-unique-permutations/

import com.scaler.academy.assignment.util.ArrayUtils;

import java.util.ArrayList;

public class AllUniquePermutations3 {

    public static void main(String[] args) {
        AllUniquePermutations2 obj = new AllUniquePermutations2();
        int[] array = {1, 2, 2};
        ArrayList<ArrayList<Integer>> result = obj.permute((ArrayList<Integer>) ArrayUtils.getListFromArray(array));
        for (ArrayList<Integer> integers : result)
            System.out.println(integers.toString());
    }

    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        return result;
    }
}
