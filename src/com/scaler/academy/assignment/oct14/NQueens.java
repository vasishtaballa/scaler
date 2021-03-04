package com.scaler.academy.assignment.oct14;

// Question: https://www.interviewbit.com/problems/nqueens/

import java.util.ArrayList;
import java.util.stream.Collectors;

public class NQueens {
    public static void main(String[] args) {
        NQueens obj = new NQueens();
        ArrayList<ArrayList<String>> result = obj.solveNQueens(4);
        for (ArrayList<String> list : result)
            System.out.println(list.toString());
    }

    public ArrayList<ArrayList<String>> solveNQueens(int a) {
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        ArrayList<ArrayList<Character>> aux = getInitList(a);
        solveNQueensUtil(a, aux, result);
        return result;
    }

    private void solveNQueensUtil(int size, ArrayList<ArrayList<Character>> aux, ArrayList<ArrayList<String>> result) {
        if (size == 0) {
            result.add(getStringFromChars(aux));
            return;
        }
        for (int i = 0; i < aux.get(0).size(); i++) {
            if (isSafe(aux, aux.size() - size, i)) {
                aux.get(aux.size() - size).set(i, 'Q');
                solveNQueensUtil(size - 1, aux, result);
                aux.get(aux.size() - size).set(i, '.');
            }
        }
    }

    private boolean isSafe(ArrayList<ArrayList<Character>> aux, int row, int col) {
        // Overflow cases
        if (row < 0 || row > aux.size() || col < 0 || col > aux.get(0).size()) {
            return false;
        }
        // UPPER LEFT
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (aux.get(i).get(j) == 'Q')
                return false;
        }
        // UP
        for (int i = row; i >= 0; i--) {
            if (aux.get(i).get(col) == 'Q')
                return false;
        }
        // UPPER RIGHT
        for (int i = row, j = col; i >= 0 && j < aux.get(0).size(); i--, j++) {
            if (aux.get(i).get(j) == 'Q')
                return false;
        }
        return true;
    }

    private ArrayList<String> getStringFromChars(ArrayList<ArrayList<Character>> aux) {
        ArrayList<String> board = new ArrayList<>();
        for (ArrayList<Character> chars : aux)
            board.add(chars.stream().map(String::valueOf).collect(Collectors.joining()));
        return board;
    }

    private ArrayList<ArrayList<Character>> getInitList(int size) {
        ArrayList<ArrayList<Character>> aux = new ArrayList<>();
        ArrayList<Character> row = new ArrayList<>();
        for (int i = 0; i < size; i++)
            row.add('.');
        for (int i = 0; i < size; i++)
            aux.add((ArrayList<Character>) row.clone());
        return aux;
    }
}
