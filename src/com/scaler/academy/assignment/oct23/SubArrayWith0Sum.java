package com.scaler.academy.assignment.oct23;

// Question: https://www.geeksforgeeks.org/find-if-there-is-a-subarray-with-0-sum/

import com.scaler.academy.assignment.util.ArrayUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SubArrayWith0Sum {
    public static void main(String[] args) {
        SubArrayWith0Sum obj = new SubArrayWith0Sum();
        int[] array = {5, 17, -22, 11};
        System.out.println(obj.solve((ArrayList<Integer>) ArrayUtils.getListFromArray(array)));
    }

    public int solve(ArrayList<Integer> A) {
        ArrayList<Long> prefixSum = new ArrayList<>();
        prefixSum.add(new Long(A.get(0)));
        Map<Long, Boolean> occurrenceMap = new HashMap<>();
        for (int i = 1; i < A.size(); i++) {
            prefixSum.add(i, prefixSum.get(i - 1) + A.get(i));
            if (occurrenceMap.containsKey(prefixSum.get(i)) || prefixSum.get(i) == 0)
                return 1;
            else
                occurrenceMap.put(prefixSum.get(i), true);
        }
        return 0;
    }
}
