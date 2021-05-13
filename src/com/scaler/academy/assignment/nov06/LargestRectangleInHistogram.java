package com.scaler.academy.assignment.nov06;

import java.util.Stack;

// Question: https://www.interviewbit.com/problems/largest-rectangle-in-histogram/

public class LargestRectangleInHistogram {

    public static void main(String[] args) {
        LargestRectangleInHistogram obj = new LargestRectangleInHistogram();
        int[] array = {3, 2, 4, 1, 5, 2};
        System.out.println(obj.largestRectangleArea(array));
    }

    /*
    The idea is to use stack to solve the problem.
    For each histogram, we check on to its left and right and find the next smallest histogram on either sides, it could form the rectangle
    with its height with the boundaries that we got.
    Ex: In the below example, if we consider 4 as a length of rectangle, we could go with widths as 2 at the max (adding a[1], a[2] for rectangle)
    So, max height would be 2 * 2 = 4 or including just that single bar of height 4 =? 4 * 1 = 4
    Similarly if we can find the next immediate smallest for each bar on its left and right, we can find the max among them
                        ||
                  ||    ||
            ||    ||    ||
            || || ||    || ||
            || || || || || ||
    ---------------------------
            3  2  4  1  5  2

     We can use stack to keep track of the next immediate smallest on its left and right.
     Whenever we find any element greater than the top of the stack, we will add it to the stack. Once we encounter an element which is less than
     the top of the stack, then for the top of the stack, current index would be its right most boundary (i.e immediate smallest element)
     To find the next smallest on its left, we can see the element which is present below it in the stack (this always works because the stack
     always will be in sorted order as we are pushing only if we encounter greater number)
     Once we get the indices, we can calculate the area using the below formula
     height of the current bar (a[i]) * (RIGHT - LEFT - 1) => a[i] * (i - tos - 1)
     If the stack is empty, then its quite obvious that there is no boundary on its left and right boundary would be the current index (i).

     */
    public int largestRectangleArea(int[] A) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0, i = 0;
        while (i < A.length) {
            if (stack.isEmpty() || A[i] >= A[stack.peek()])
                stack.push(i++);
            else {
                int top = stack.pop();
                int area = 0;
                if (stack.isEmpty())
                    area = A[top] * i;
                else
                    area = A[top] * (i - stack.peek() - 1);
                maxArea = Math.max(maxArea, area);
            }
        }
        while (!stack.isEmpty()) {
            int top = stack.pop();
            int area = 0;
            if (stack.isEmpty())
                area = A[top] * i;
            else
                area = A[top] * (i - stack.peek() - 1);
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }

}
