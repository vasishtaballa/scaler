package com.scaler.academy.homework.oct23;

import com.scaler.academy.assignment.util.ArrayUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/*
Set Matrix Zeros
Given a matrix, A of size M x N of 0s and 1s. If an element is 0, set its entire row and column to 0.

Note: This will be evaluated on the extra memory used. Try to minimize the space and time complexity.



Input Format:

The first and the only argument of input contains a 2-d integer matrix, A, of size M x N.
Output Format:

Return a 2-d matrix that satisfies the given conditions.
Constraints:

1 <= N, M <= 1000
0 <= A[i][j] <= 1
Examples:

Input 1:
    [   [1, 0, 1],
        [1, 1, 1],
        [1, 1, 1]   ]

Output 1:
    [   [0, 0, 0],
        [1, 0, 1],
        [1, 0, 1]   ]

Input 2:
    [   [1, 0, 1],
        [1, 1, 1],
        [1, 0, 1]   ]

Output 2:
    [   [0, 0, 0],
        [1, 0, 1],
        [0, 0, 0]   ]
 */

public class SetMatrixZeros {
    public static void main(String[] args) {
        SetMatrixZeros obj = new SetMatrixZeros();
        int[][] matrix = {
                {0, 1},
                {0, 1}
        };
        ArrayList<ArrayList<Integer>> matrixList = (ArrayList<ArrayList<Integer>>) ArrayUtils.getListFromMatrix(matrix);
        obj.setZeroes(matrixList);
        for (ArrayList<Integer> list : matrixList)
            System.out.println(list);
    }

    public void setZeroes(ArrayList<ArrayList<Integer>> a) {
        Set<Integer> rowSet = new HashSet<>(), colSet = new HashSet<>();
        for (int i = 0; i < a.size(); i++) {
            for (int j = 0; j < a.get(i).size(); j++) {
                if (a.get(i).get(j) == 0) {
                    rowSet.add(i);
                    colSet.add(j);
                }
            }
        }
        for (int i = 0; i < a.size(); i++) {
            boolean zeroRow = rowSet.contains(i);
            for (int j = 0; j < a.get(i).size(); j++) {
                if (zeroRow || colSet.contains(j))
                    a.get(i).set(j, 0);
            }
        }
    }
}
