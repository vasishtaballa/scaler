package com.scaler.academy.assignment.nov04;

/*
Sort stack using another stack
Problem Description

Given a stack of integers A, sort it using another stack.

Return the array of integers after sorting the stack using another stack.



Problem Constraints
1 <= |A| <= 5000

0 <= A[i] <= 1000000000



Input Format
The only argument given is the integer array A.



Output Format
Return the array of integers after sorting the stack using another stack.



Example Input
Input 1:

 A = [5, 4, 3, 2, 1]
Input 2:

 A = [5, 17, 100, 11]


Example Output
Output 1:

 [1, 2, 3, 4, 5]
Output 2:

 [5, 11, 17, 100]


Example Explanation
Explanation 1:

 Just sort the given numbers.
Explanation 2:

 Just sort the given numbers.
 */

import java.util.Stack;

public class SortStack {

    public static void main(String[] args) {
        SortStack obj = new SortStack();
        int[] array = {5, 17, 100, 11};
        array = obj.solve(array);
        for (int i = 0; i < array.length; i++)
            System.out.print(array[i] + " ");
    }

    public int[] solve(int[] A) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < A.length; i++)
            stack.push(A[i]);
        stack = sortStack(stack);
        int index = 0;
        while (!stack.isEmpty())
            A[index++] = stack.pop();
        return A;
    }

    private Stack<Integer> sortStack(Stack<Integer> stack) {
        Stack<Integer> tempStack = new Stack<>();
        while (!stack.isEmpty()) {
            int item = stack.pop();
            insertAtPosition(item, tempStack);
        }
        return tempStack;
    }

    private void insertAtPosition(int item, Stack<Integer> stack) {
        if (stack.isEmpty() || stack.peek() > item)
            stack.push(item);
        else {
            int temp = stack.pop();
            insertAtPosition(item, stack);
            stack.push(temp);
        }
    }

}
