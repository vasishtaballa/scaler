package com.scaler.academy.homework.oct23;

// Question: https://www.interviewbit.com/problems/valid-sudoku/

import com.scaler.academy.assignment.util.ArrayUtils;

import java.util.*;

public class ValidSudoku {
    public static void main(String[] args) {
        ValidSudoku obj = new ValidSudoku();
        String[] array = {
                "..4...63.", ".........", "5......9.", "...56....", "4.3.....1", "...7.....", "...5.....", ".........", "........."
        };
        System.out.println(obj.isValidSudoku(ArrayUtils.getListFromArray(array)));
    }

    public int isValidSudoku(final List<String> A) {
        Map<Character, Set<Integer>> rows = new HashMap<>();
        Map<Character, Set<Integer>> cols = new HashMap<>();
        for (int i = 0; i < A.size(); i++) {
            String row = A.get(i);
            for (int j = 0; j < 9; j++) {
                char cellValue = row.charAt(j);
                if (cellValue == '.')
                    continue;
                if (rows.containsKey(cellValue)) {
                    if (rows.get(cellValue).contains(i))
                        return 0;
                    else
                        rows.get(cellValue).add(i);
                } else {
                    HashSet<Integer> set = new HashSet<>();
                    set.add(i);
                    rows.put(cellValue, set);
                }
                if (cols.containsKey(cellValue)) {
                    if (cols.get(cellValue).contains(j))
                        return 0;
                    else
                        cols.get(cellValue).add(j);
                } else {
                    HashSet<Integer> set = new HashSet<>();
                    set.add(j);
                    cols.put(cellValue, set);
                }
                if (!checkSurroundings(A, i, j, cellValue))
                    return 0;
            }
        }
        return 1;
    }

    private boolean checkSurroundings(List<String> board, int row, int col, char cellValue) {
        int startRow = (row / 3) * 3, startCol = (col / 3) * 3, endRow = startRow + 3, endCol = startCol + 3;
        for (int i = startRow; i < endRow; i++) {
            for (int j = startCol; j < endCol; j++) {
                if (i != row && j != col && board.get(i).charAt(j) == cellValue)
                    return false;
            }
        }
        return true;
    }
}
