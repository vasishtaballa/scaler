package com.scaler.academy.homework.oct14;

// Question: https://www.interviewbit.com/problems/sudoku/

import com.scaler.academy.assignment.util.ArrayUtils;

import java.util.ArrayList;

public class Sudoku {

    public static void main(String[] args) {
        Sudoku obj = new Sudoku();
        char[][] board = {
                {'.', '.', '.', '.', '.', '.', '.', '6', '.'},
                {'.', '.', '.', '.', '.', '1', '.', '2', '.'},
                {'7', '4', '.', '.', '8', '.', '.', '.', '9'},
                {'1', '.', '5', '.', '7', '.', '9', '.', '4'},
                {'.', '.', '.', '.', '.', '9', '2', '.', '.'},
                {'.', '.', '.', '.', '3', '.', '.', '5', '.'},
                {'4', '.', '.', '.', '.', '2', '7', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '3', '.', '6', '9', '.', '.', '.', '.'}
        };
        ArrayList<ArrayList<Character>> sudokuBoard = ArrayUtils.getListFromMatrix(board);
        obj.solveSudoku(sudokuBoard);
        for (ArrayList<Character> row : sudokuBoard) {
            System.out.println(row);
        }
    }

    public void solveSudoku(ArrayList<ArrayList<Character>> a) {
        if (solveSudokuUtil(a, 0))
            return;
    }

    private boolean solveSudokuUtil(ArrayList<ArrayList<Character>> board, int row) {
        if (row >= 9)
            return true;
        for (int i = 0; i < 9; i++) {
            if (i == 8 && board.get(row).get(i) != '.')
                return solveSudokuUtil(board, row + 1);
            if (board.get(row).get(i) == '.') {
                for (char ch = '1'; ch <= '9'; ch++) {
                    if (isSafe(board, row, i, ch)) {
                        board.get(row).set(i, ch);
                        if (solveSudokuUtil(board, row))
                            return true;
                        else
                            board.get(row).set(i, '.');
                    }
                }
                return false;
            }
        }
        return false;
    }

    private boolean isSafe(ArrayList<ArrayList<Character>> board, int row, int col, char number) {
        // check in row
        for (int i = 0; i < 9; i++) {
            if (board.get(row).get(i) == number)
                return false;
        }
        // check in col
        for (int i = 0; i < 9; i++) {
            if (board.get(i).get(col) == number)
                return false;
        }
        // each 3 X 3 box conditions
        if (!isSafeInCurrent3X3Board(board, row, col, number))
            return false;
        return true;
    }

    private boolean isSafeInCurrent3X3Board(ArrayList<ArrayList<Character>> board, int row, int col, char number) {
        int startRow = (row / 3) * 3, startCol = (col / 3) * 3, endRow = startRow + 3, endCol = startCol + 3;
        for (int i = startRow; i < endRow; i++) {
            for (int j = startCol; j < endCol; j++) {
                if (board.get(i).get(j) == number)
                    return false;
            }
        }
        return true;
    }

}
