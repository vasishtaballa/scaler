package com.scaler.academy.assignment.nov06;

import java.util.Stack;

// Question: https://www.interviewbit.com/problems/max-rectangle-in-binary-matrix/

public class MaximumRectangle {

    public static void main(String[] args) {
        MaximumRectangle obj = new MaximumRectangle();
        int[][] matrix = {{0, 1, 1, 1}, {0, 0, 1, 0}, {0, 1, 0, 0}, {0, 1, 1, 1}, {1, 0, 1, 1},
                {0, 0, 0, 1}, {0, 0, 0, 1}, {1, 1, 0, 1}, {1, 0, 0, 0}};
        System.out.println(obj.solve(matrix));
    }

    /*
    The idea is similar to using the same technique that we need to solve the LargestRectangleInHistogram problem
    For each row in the matrix, we imagine the each row on towards its top as a histogram. If the current element in a row is zero, then histogram
    is not possible. If it is non-zero, then find the height of the histogram so far using some temporary array.
    For each row, repeat the LargestRectangleInHistogram step then find the maximum area
     */
    public int solve(int[][] A) {
        int rows = A.length, columns = A[0].length, area = 0;
        int[] temp = new int[columns];
        for (int i = 0; i < rows; i++) {
            temp = updateTempArray(A, temp, i);
            area = Math.max(maxAreaFromRow(temp), area);
        }
        return area;
    }

    private int maxAreaFromRow(int[] array) {
        int maxArea = 0, index = 0;
        Stack<Integer> stack = new Stack<>();
        while (index < array.length) {
            if (stack.isEmpty() || array[stack.peek()] <= array[index])
                stack.push(index++);
            else {
                int top = stack.pop();
                int area = 0;
                if (stack.isEmpty())
                    area = array[top] * index;
                else
                    area = array[top] * (index - stack.peek() - 1);
                maxArea = Math.max(area, maxArea);
            }
        }
        while (!stack.isEmpty()) {
            int top = stack.pop();
            int area = 0;
            if (stack.isEmpty())
                area = array[top] * index;
            else
                area = array[top] * (index - stack.peek() - 1);
            maxArea = Math.max(area, maxArea);
        }
        return maxArea;
    }

    private int[] updateTempArray(int[][] matrix, int[] temp, int rowNum) {
        if (rowNum == 0) {
            for (int i = 0; i < temp.length; i++)
                temp[i] = matrix[rowNum][i];
        } else {
            for (int i = 0; i < temp.length; i++) {
                if (matrix[rowNum][i] == 0)
                    temp[i] = 0;
                else
                    temp[i] += matrix[rowNum][i];
            }
        }
        return temp;
    }

}
