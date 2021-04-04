package com.scaler.academy.assignment.sep17;

import java.util.Arrays;

public class Beggars {
    public static void main(String[] args) {
        Beggars obj = new Beggars();
        int[][] matrix = {{1, 2, 10}, {2, 3, 20}, {2, 5, 25}};
        int[] result = obj.solve(5, matrix);
        System.out.println(Arrays.toString(result));
    }

    public int[] solve(int numberOfBeggars, int[][] matrix) {
        int[] result = new int[numberOfBeggars];
        for (int i = 0; i < matrix.length; i++) {
            int leftIndex = matrix[i][0] - 1, rightIndex = matrix[i][1] - 1, donation = matrix[i][2];
            result[leftIndex] += donation;
            if (rightIndex + 1 < numberOfBeggars)
                result[rightIndex + 1] -= donation;
        }
        for (int i = 1; i < numberOfBeggars; i++)
            result[i] += result[i - 1];
        return result;
    }
}
