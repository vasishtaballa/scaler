package com.scaler.academy.assignment.oct18;

// Question: https://leetcode.com/problems/reverse-pairs/

import com.scaler.academy.assignment.util.ArrayUtils;

import java.util.ArrayList;

public class ReversePairs {
    public static void main(String[] args) {
        ReversePairs obj = new ReversePairs();
        int[] array = {1, 3, 2, 3, 1};
        System.out.println(obj.solve((ArrayList<Integer>) ArrayUtils.getListFromArray(array)));
    }

    public int solve(ArrayList<Integer> A) {
        return mergeSort(A, 0, A.size() - 1);
    }

    private int mergeSort(ArrayList<Integer> list, int low, int high) {
        if (low >= high) return 0;
        int mid = low + (high - low) / 2;
        int count = mergeSort(list, low, mid) + mergeSort(list, mid + 1, high);
        int i = low, j = mid + 1;
        while (i <= mid && j <= high) {
            if (list.get(i) > 2 * list.get(j)) {
                count += mid - i + 1;
                j++;
            } else
                i++;
        }
        merge(list, low, mid, high);
        return count;
    }

    private void merge(ArrayList<Integer> list, int low, int mid, int high) {
        ArrayList<Integer> temp = new ArrayList<>(high - low + 1);
        int i = low, j = mid + 1, k = 0, tempSize = high - low + 1;
        while (i <= mid && j <= high) {
            if (list.get(i) < list.get(j)) {
                temp.add(list.get(i));
                i++;
            } else {
                temp.add(list.get(j));
                j++;
            }
        }
        while (i <= mid) {
            temp.add(list.get(i));
            i++;
        }
        while (j <= high) {
            temp.add(list.get(j));
            j++;
        }
        int index = 0;
        for (i = low; i <= high; i++)
            list.set(i, temp.get(index++));
    }
}
