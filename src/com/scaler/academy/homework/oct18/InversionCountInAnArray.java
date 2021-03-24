package com.scaler.academy.homework.oct18;

// Question: https://www.interviewbit.com/problems/inversions/

import com.scaler.academy.assignment.util.ArrayUtils;

import java.util.ArrayList;

public class InversionCountInAnArray {

    final static int MOD_VAL = 1000000007;

    public static void main(String[] args) {
        InversionCountInAnArray obj = new InversionCountInAnArray();
        int[] array = {28, 18, 44, 49, 41, 14};
        System.out.println(obj.solve((ArrayList<Integer>) ArrayUtils.getListFromArray(array)));
    }

    public int solve(ArrayList<Integer> A) {
        return mergeSort(A, 0, A.size() - 1);
    }

    private int mergeSort(ArrayList<Integer> list, int low, int high) {
        if (low >= high) return 0;
        int mid = low + (high - low) / 2;
        int count = mergeSort(list, low, mid) + mergeSort(list, mid + 1, high);
        count += merge(list, low, mid, high);
        count %= MOD_VAL;
        return count;
    }

    private int merge(ArrayList<Integer> list, int low, int mid, int high) {
        int leftPartSize = mid - low + 1, rightPartSize = high - mid, index = 0, count = 0;
        int[] leftPart = new int[leftPartSize], rightPart = new int[rightPartSize];
        for (int i = low; i <= mid; i++)
            leftPart[index++] = list.get(i);
        index = 0;
        for (int i = mid + 1; i <= high; i++)
            rightPart[index++] = list.get(i);
        index = low;
        int leftIndex = 0, rightIndex = 0, rightTempIdx = 0;
        while (leftIndex < leftPartSize && rightIndex < rightPartSize) {
            if (leftPart[leftIndex] <= rightPart[rightIndex]) {
                list.set(index++, leftPart[leftIndex]);
                leftIndex += 1;
            } else {
                list.set(index++, rightPart[rightIndex]);
                count += (leftPartSize - leftIndex);
                count %= MOD_VAL;
                rightIndex += 1;
            }
        }
        while (leftIndex < leftPartSize) {
            list.set(index++, leftPart[leftIndex]);
            leftIndex += 1;
        }
        while (rightIndex < rightPartSize) {
            list.set(index++, rightPart[rightIndex]);
            rightIndex += 1;
        }
        return count % MOD_VAL;
    }
}
