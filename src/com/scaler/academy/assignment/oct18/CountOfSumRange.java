package com.scaler.academy.assignment.oct18;

// Question: https://leetcode.com/problems/count-of-range-sum/

import com.scaler.academy.assignment.util.ArrayUtils;

import java.util.ArrayList;

public class CountOfSumRange {

    public static void main(String[] args) {
        CountOfSumRange obj = new CountOfSumRange();
        int[] array = {5, -2, 3, 1, -4, 6};
        System.out.println(obj.solve((ArrayList<Integer>) ArrayUtils.getListFromArray(array), -564, 3863));
    }

    public int solve(ArrayList<Integer> A, int B, int C) {
        int[] prefixSum = new int[A.size() + 1];
        prefixSum[0] = 0;
        for (int i = 1; i < prefixSum.length; i++)
            prefixSum[i] = prefixSum[i - 1] + A.get(i - 1);
        return mergeSort(prefixSum, 0, prefixSum.length - 1, B, C);
    }

    private int mergeSort(int[] prefixSum, int low, int high, int lower, int higher) {
        if (low >= high) return 0;
        int mid = low + (high - low) / 2;
        int count = mergeSort(prefixSum, low, mid, lower, higher) + mergeSort(prefixSum, mid + 1, high, lower, higher);
        int i = mid + 1, j = mid + 1;
        for (int k = low; k < mid; k++) {
            while (i <= high && prefixSum[i] - prefixSum[k] <= lower) i++;
            while (j <= high && prefixSum[j] - prefixSum[k] <= higher) j++;
            count += j - i;
        }
        merge(prefixSum, low, mid, high);
        return count;
    }

    private void merge(int[] prefixSum, int low, int mid, int high) {
        int leftPartSize = mid - low + 1, rightPartSize = high - mid, index = 0;
        int[] leftPart = new int[leftPartSize], rightPart = new int[rightPartSize];
        for (int i = low; i <= mid; i++)
            leftPart[index++] = prefixSum[i];
        index = 0;
        for (int i = mid + 1; i <= high; i++)
            rightPart[index++] = prefixSum[i];
        index = low;
        int leftIndex = 0, rightIndex = 0;
        while (leftIndex < leftPartSize && rightIndex < rightPartSize) {
            if (leftPart[leftIndex] <= rightPart[rightIndex]) {
                prefixSum[index++] = leftPart[leftIndex];
                leftIndex += 1;
            } else {
                prefixSum[index++] = rightPart[rightIndex];
                rightIndex += 1;
            }
        }
        while (leftIndex < leftPartSize) {
            prefixSum[index++] = leftPart[leftIndex];
            leftIndex += 1;
        }
        while (rightIndex < rightPartSize) {
            prefixSum[index++] = rightPart[rightIndex];
            rightIndex += 1;
        }
    }


}
