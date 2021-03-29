package com.scaler.academy.assignment.oct23;

// Question: https://www.interviewbit.com/problems/equal/

import com.scaler.academy.assignment.util.ArrayUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Equal {

    static class Pair {
        int a;
        int b;

        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    public static void main(String[] args) {
        Equal obj = new Equal();
        int[] array = {9, 5, 4, 9, 3, 6, 8, 7, 1, 2, 8, 7, 2, 9, 7, 1, 3, 9, 7, 8, 1, 0, 5, 5};
        List<Integer> result = obj.equal((ArrayList<Integer>) ArrayUtils.getListFromArray(array));
        System.out.println(result.toString());
    }

    public ArrayList<Integer> equal(ArrayList<Integer> A) {
        Map<Integer, Pair> map = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < A.size(); i++) {
            for (int j = i + 1; j < A.size(); j++) {
                if (i != j) {
                    int sum = A.get(i) + A.get(j);
                    if (map.containsKey(sum))
                        updateResult(result, i, j, map.get(sum));
                    else
                        map.put(sum, new Pair(i, j));
                }
            }
        }
        if (result.size() == 4)
            return result;
        result.clear();
        return result;
    }

    private void updateResult(ArrayList<Integer> result, int a, int b, Pair pair) {
        ArrayList<Integer> temp = new ArrayList<>();
        if (pair.a >= a || pair.b == a || pair.b == b)
            return;
        if (result.size() == 0) {
            result.add(pair.a);
            result.add(pair.b);
            result.add(a);
            result.add(b);
            return;
        } else {
            temp.add(pair.a);
            temp.add(pair.b);
            temp.add(a);
            temp.add(b);
        }
        if (isSmallest(temp, result)) {
            result.set(0, temp.get(0));
            result.set(1, temp.get(1));
            result.set(2, temp.get(2));
            result.set(3, temp.get(3));
        }
    }

    private boolean isSmallest(ArrayList<Integer> temp, ArrayList<Integer> result) {
        for (int i = 0; i < 4; i++) {
            if (temp.get(i) > result.get(i))
                return false;
            if (temp.get(i) < result.get(i))
                return true;
        }
        return true;
    }

}
