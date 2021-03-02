package com.scaler.academy.assignment.oct11;

// Question: https://www.interviewbit.com/problems/all-unique-permutations/

import com.scaler.academy.assignment.util.ArrayUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AllUniquePermutations3 {

    public static void main(String[] args) {
        AllUniquePermutations3 obj = new AllUniquePermutations3();
        int[] array = {0, 0, 0, 1, 9};
        ArrayList<ArrayList<Integer>> result = obj.permute((ArrayList<Integer>) ArrayUtils.getListFromArray(array));
        for (ArrayList<Integer> integers : result)
            System.out.println(integers.toString());
    }

    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Map<Integer, Integer> frequencyMap = getFrequencyMap(A);
        ArrayList<Integer> aux = new ArrayList<>();
        permuteUtil(aux, frequencyMap, result);
        return result;
    }

    private void permuteUtil(ArrayList<Integer> aux, Map<Integer, Integer> frequencyMap, ArrayList<ArrayList<Integer>> result) {
        int zeroCount = 0;
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() == 0)
                zeroCount++;
            else {
                int count = entry.getValue();
                frequencyMap.put(entry.getKey(), count - 1);
                aux.add(entry.getKey());
                permuteUtil(aux, frequencyMap, result);
                frequencyMap.put(entry.getKey(), count);
                aux.remove(aux.size() - 1);
            }
        }
        if (zeroCount == frequencyMap.size()) {
            result.add((ArrayList<Integer>) aux.clone());
            return;
        }
    }

    private Map<Integer, Integer> getFrequencyMap(ArrayList<Integer> list) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (Integer integer : list) {
            if (frequencyMap.containsKey(integer)) {
                int count = frequencyMap.get(integer);
                frequencyMap.put(integer, count + 1);
            } else
                frequencyMap.put(integer, 1);
        }
        return frequencyMap;
    }
}
