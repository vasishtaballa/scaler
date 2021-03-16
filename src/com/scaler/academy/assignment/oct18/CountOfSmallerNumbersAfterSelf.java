package com.scaler.academy.assignment.oct18;

// Question: https://leetcode.com/problems/count-of-smaller-numbers-after-self/

import com.scaler.academy.assignment.util.ArrayUtils;

import java.util.ArrayList;
import java.util.List;

public class CountOfSmallerNumbersAfterSelf {

    static class Item {
        int data;
        int index;

        public Item(int data, int index) {
            this.data = data;
            this.index = index;
        }
    }

    public static void main(String[] args) {
        CountOfSmallerNumbersAfterSelf obj = new CountOfSmallerNumbersAfterSelf();
        int[] array = {140, 476, 248, 160, 248, 120};
        List<Integer> result = obj.solve((ArrayList<Integer>) ArrayUtils.getListFromArray(array));
        System.out.println(result.toString());
    }

    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        ArrayList<Item> items = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < A.size(); i++) {
            items.add(new Item(A.get(i), i));
            result.add(0);
        }
        mergeSort(items, 0, A.size() - 1, result);
        return result;
    }

    private void mergeSort(ArrayList<Item> items, int low, int high, ArrayList<Integer> result) {
        if (low < high) {
            int mid = low + (high - low) / 2;
            mergeSort(items, low, mid, result);
            mergeSort(items, mid + 1, high, result);
            merge(items, low, mid, high, result);
        }
    }

    private void merge(ArrayList<Item> list, int low, int mid, int high, ArrayList<Integer> result) {
        int leftPartSize = mid - low + 1, rightPartSize = high - mid, index = 0;
        Item[] leftPart = new Item[leftPartSize], rightPart = new Item[rightPartSize];
        for (int i = low; i <= mid; i++)
            leftPart[index++] = list.get(i);
        index = 0;
        for (int i = mid + 1; i <= high; i++)
            rightPart[index++] = list.get(i);
        index = low;
        int leftIndex = 0, rightIndex = 0, count = 0;
        while (leftIndex < leftPartSize && rightIndex < rightPartSize) {
            if (leftPart[leftIndex].data <= rightPart[rightIndex].data) {
                result.set(leftPart[leftIndex].index, result.get(leftPart[leftIndex].index) + count);
                list.set(index++, leftPart[leftIndex]);
                leftIndex += 1;
            } else {
                count += 1;
                list.set(index++, rightPart[rightIndex]);
                rightIndex += 1;
            }
        }
        while (leftIndex < leftPartSize) {
            result.set(leftPart[leftIndex].index, result.get(leftPart[leftIndex].index) + count);
            list.set(index++, leftPart[leftIndex]);
            leftIndex += 1;
        }
        while (rightIndex < rightPartSize) {
            list.set(index++, rightPart[rightIndex]);
            rightIndex += 1;
        }
    }
}
