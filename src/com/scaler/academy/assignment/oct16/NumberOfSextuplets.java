package com.scaler.academy.assignment.oct16;

// Question: https://www.geeksforgeeks.org/number-sextuplets-six-values-satisfy-equation/

import com.scaler.academy.assignment.util.ArrayUtils;

import java.util.ArrayList;
import java.util.HashMap;

public class NumberOfSextuplets {

    public static void main(String[] args) {
        NumberOfSextuplets obj = new NumberOfSextuplets();
        int[] array = {13, -25, 9, -27, -5, -23, 19, 1, -21, 25, 15, -29, -3, 21, 3, 23, -15, -17, -1, 0, -19, -11, -9, -7, 5, 17, -13, 11, 27, 7};
        System.out.println(obj.solve((ArrayList<Integer>) ArrayUtils.getListFromArray(array)));
    }

    public int solve(ArrayList<Integer> A) {
        HashMap<Long, Long> map = new HashMap<>();
        for (int i = 0; i < A.size(); i++) {
            for (int j = 0; j < A.size(); j++) {
                for (int k = 0; k < A.size(); k++) {
                    Long value = new Long(A.get(i) * A.get(j) + A.get(k));
                    if (map.containsKey(value)) {
                        Long currentValue = map.get(value);
                        map.put(value, currentValue + 1);
                    } else {
                        map.put(value, new Long(1));
                    }
                }
            }
        }
        Long totalCount = new Long(0), modValue = new Long(1000000007);
        for (int i = 0; i < A.size(); i++) {
            for (int j = 0; j < A.size(); j++) {
                for (int k = 0; k < A.size(); k++) {
                    if (A.get(k) != 0) {
                        Long value = new Long((A.get(i) + A.get(j)) * A.get(k));
                        if (map.containsKey(value)) {
                            totalCount = totalCount + map.get(value);
                            totalCount %= modValue;
                        }
                    }
                }
            }
        }
        return (int) (long) totalCount;
    }

}
