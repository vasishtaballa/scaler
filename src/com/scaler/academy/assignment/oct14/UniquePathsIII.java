package com.scaler.academy.assignment.oct14;

// Question: https://www.interviewbit.com/problems/grid-unique-paths/

import com.scaler.academy.assignment.util.ArrayUtils;

import java.util.ArrayList;

public class UniquePathsIII {

    int count = 0;
    int[] start = null;

    public static void main(String[] args) {
        UniquePathsIII obj = new UniquePathsIII();
        int[][] matrix = {
                {0, 1},
                {2, 0}
        };
        System.out.println(obj.solve((ArrayList<ArrayList<Integer>>) ArrayUtils.getListFromMatrix(matrix)));
    }

    public int solve(ArrayList<ArrayList<Integer>> A) {
        boolean[][] visitedMatrix = new boolean[A.size()][A.get(0).size()];
        start = getStartPoint(A);
        solveUtil(A, visitedMatrix, start[0], start[1]);
        return count;
    }

    private void solveUtil(ArrayList<ArrayList<Integer>> matrix, boolean[][] visitedMatrix, int xIdx, int yIdx) {
        if (xIdx >= 0 && xIdx < matrix.size() && yIdx >= 0 && yIdx < matrix.get(0).size() && matrix.get(xIdx).get(yIdx) == 2 && areAllCellsVisited(matrix, visitedMatrix))
            count++;
        if (isSafe(matrix, visitedMatrix, xIdx, yIdx)) {
            visitedMatrix[xIdx][yIdx] = true;
        } else {
            return;
        }
        solveUtil(matrix, visitedMatrix, xIdx - 1, yIdx); // UP
        solveUtil(matrix, visitedMatrix, xIdx, yIdx + 1); // RIGHT
        solveUtil(matrix, visitedMatrix, xIdx + 1, yIdx); // DOWN
        solveUtil(matrix, visitedMatrix, xIdx, yIdx - 1); // LEFT
        visitedMatrix[xIdx][yIdx] = false;
    }

    private boolean isSafe(ArrayList<ArrayList<Integer>> matrix, boolean[][] visitedMatrix, int xIdx, int yIdx) {
        // Matrix overflow cases
        if (xIdx < 0 || xIdx >= matrix.size() || yIdx < 0 || yIdx >= matrix.get(0).size()) {
            return false;
        }
        // Blocker cells cases
        if (matrix.get(xIdx).get(yIdx) == -1)
            return false;
        if (matrix.get(xIdx).get(yIdx) == 0 && !visitedMatrix[xIdx][yIdx])
            // Already visited cases & walk possible
            return true;
        if (xIdx == start[0] && yIdx == start[1] && !visitedMatrix[xIdx][yIdx])
            return true;
        return false;
    }

    private boolean areAllCellsVisited(ArrayList<ArrayList<Integer>> matrix, boolean[][] visitedMatrix) {
        int rows = visitedMatrix.length, cols = visitedMatrix[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix.get(i).get(j) == 0 && !visitedMatrix[i][j])
                    return false;
            }
        }
        return true;
    }

    private int[] getStartPoint(ArrayList<ArrayList<Integer>> list) {
        int[] start = new int[2];
        for (int i = 0; i < list.size(); i++) {
            ArrayList<Integer> row = list.get(i);
            for (int j = 0; j < row.size(); j++) {
                if (row.get(j) == 1) {
                    start[0] = i;
                    start[1] = j;
                }
            }
        }
        return start;
    }

}
