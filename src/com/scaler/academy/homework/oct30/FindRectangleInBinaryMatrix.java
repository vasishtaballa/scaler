package com.scaler.academy.homework.oct30;

// Question: https://www.geeksforgeeks.org/find-rectangle-binary-matrix-corners-1/

import com.scaler.academy.assignment.util.ArrayUtils;

import java.util.*;

public class FindRectangleInBinaryMatrix {

    static class Pair {
        int a;
        int b;

        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return a == pair.a && b == pair.b;
        }

        @Override
        public int hashCode() {
            return Objects.hash(a, b);
        }
    }

    public static void main(String[] args) {
        FindRectangleInBinaryMatrix obj = new FindRectangleInBinaryMatrix();
        int[][] matrix = {
                {1, 0, 0, 1, 0},
                {0, 0, 1, 0, 1},
                {0, 0, 0, 1, 0},
                {1, 0, 1, 0, 1}
        };
        System.out.println(obj.solve(ArrayUtils.getListFromMatrix(matrix)));
    }

    /*
    The idea is to iterate each row and identify 1's column index in each row and store them in a map with key as row index and value as list of column-indexes
    We will use this map and iterate this again and for each key in the map, form set of each pair of 1s and if we encounter the same pair again,
    then there is a possible rectangle/square in the given matrix.
    Example:
    1. Map will look like this for the above input:
        0th row -> 0, 3
        1st row -> 2, 4
        2nd row -> 3
        3rd row -> 0, 2, 4
     We will iterate this map and check if any pair of columns has come twice.. In this case pair (2, 4) is there twice, hence rectangle is possible
     */
    public int solve(final List<ArrayList<Integer>> A) {
        // Iterate each row in the input and form the map of row index to column indexes with 1 as value
        Map<Integer, List<Integer>> rowToCol1CountMap = new HashMap<>();
        for (int i = 0; i < A.size(); i++) {
            ArrayList<Integer> row = A.get(i);
            for (int j = 0; j < row.size(); j++) {
                if (A.get(i).get(j) == 1) {
                    if (rowToCol1CountMap.containsKey(i))
                        rowToCol1CountMap.get(i).add(j);
                    else {
                        ArrayList<Integer> list = new ArrayList<>();
                        list.add(j);
                        rowToCol1CountMap.put(i, list);
                    }
                }
            }
        }
        // Iterate the map that is formed and form pairs for each value in map and store those pairs in set
        Set<Pair> pairs = new HashSet<>();
        for (Map.Entry<Integer, List<Integer>> entry : rowToCol1CountMap.entrySet()) {
            List<Integer> list = entry.getValue();
            for (int i = 0; i < list.size() - 1; i++) {
                for (int j = i + 1; j < list.size(); j++) {
                    Pair pair = new Pair(list.get(i), list.get(j));
                    if (pairs.contains(pair))
                        return 1;
                    pairs.add(pair);
                }
            }
        }
        return 0;
    }

}
