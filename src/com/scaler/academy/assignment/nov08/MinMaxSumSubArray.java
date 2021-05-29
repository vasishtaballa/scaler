package com.scaler.academy.assignment.nov08;

import java.util.Deque;
import java.util.LinkedList;

// Question: https://www.interviewbit.com/problems/sum-of-minimum-and-maximum-elements-of-all-subarrays-of-size-k/

public class MinMaxSumSubArray {

    public static void main(String[] args) {
        MinMaxSumSubArray obj = new MinMaxSumSubArray();
        int[] array = {2, -1, 3};
        System.out.println(obj.solve(array, 2));
    }

    /*
    The idea is to use two queues. One queue to store minimum number so far and another queue to store maximum number so far (to achieve the min and max for each sub-array in an optimal way)
     */

    public int solve(int[] A, int B) {
        long result = 0;
        int modValue = 1000000007;
        Deque<Integer> maxQueue = new LinkedList<>();
        Deque<Integer> minQueue = new LinkedList<>();
        int i = 0;
        // Iterating first B characters and updating the min & max queue
        for (; i < B; i++) {
            /*
            While the last element in max queue is smaller than current element, poll all the elements and at the end push the current element
            This is because, if any smaller numbers are there, they will be overridden by the current element while nominating to become max
             */
            while (!maxQueue.isEmpty() && A[i] >= A[maxQueue.peekLast()])
                maxQueue.pollLast();
            maxQueue.add(i);
            while (!minQueue.isEmpty() && A[i] <= A[minQueue.peekLast()])
                minQueue.pollLast();
            minQueue.add(i);
        }
        // Get the min and max for first sub-array of size B and add them to the result
        result += A[maxQueue.peekFirst()] + A[minQueue.peekFirst()];
        result %= modValue;
        // Iterating rest of the elements after B elements
        while (i < A.length) {
            /*
            Poll elements from both the queues which should not be included in the current sub-array
            We can find this by using the ith pointer and subtracting B from i will give the start point of the current sub-array.
            If any of the indexes outside this range are present in any of the queue, we should remove them
             */
            while (!maxQueue.isEmpty() && i - B >= maxQueue.peekFirst())
                maxQueue.pollFirst();
            while (!minQueue.isEmpty() && i - B >= minQueue.peekFirst())
                minQueue.pollFirst();
            while (!maxQueue.isEmpty() && A[i] >= A[maxQueue.peekLast()])
                maxQueue.pollLast();
            maxQueue.add(i);
            while (!minQueue.isEmpty() && A[i] <= A[minQueue.peekLast()])
                minQueue.pollLast();
            minQueue.add(i);
            result += A[maxQueue.peekFirst()] + A[minQueue.peekFirst()];
            result %= modValue;
            i++;
        }
        result += modValue;
        result %= modValue;
        return (int) result;
    }

}
