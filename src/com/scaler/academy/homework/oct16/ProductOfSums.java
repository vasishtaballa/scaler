package com.scaler.academy.homework.oct16;

// Question:

import com.scaler.academy.assignment.util.ArrayUtils;

import java.util.ArrayList;
import java.util.Collections;

public class ProductOfSums {

    Long modValue = new Long(1000000007);

    public static void main(String[] args) {
        ProductOfSums obj = new ProductOfSums();
        int[] array1 = {3};
        int[] array2 = {10};
        int[] array3 = {11};
        System.out.println(obj.getSum(2, 2, 4, (ArrayList<Integer>) ArrayUtils.getListFromArray(array1), (ArrayList<Integer>) ArrayUtils.getListFromArray(array2), (ArrayList<Integer>) ArrayUtils.getListFromArray(array3)));
    }

    public int getSum(int A, int B, int C, ArrayList<Integer> D, ArrayList<Integer> E, ArrayList<Integer> F) {
        Collections.sort(D);
        Collections.sort(F);
        Long sum = new Long(0);
        int[] prefixSum1 = getPrefixSum(D);
        int[] prefixSum2 = getPrefixSum(F);
        for (int i = 0; i < E.size(); i++) {
            int index1 = getIndexTillMin(D, E.get(i));
            int index2 = getIndexTillMin(F, E.get(i));
            if (index1 != 0 && index2 != 0) {
                sum = sum + getValue(index1, index2, prefixSum1[index1 - 1], prefixSum2[index2 - 1], E.get(i));
                sum %= modValue;
            }
        }
        return (int) (long) sum;
    }

    private Long getValue(int index1, int index2, int sum1, int sum2, Integer key) {
        return (new Long((index1 * key + sum1)) % modValue) * (new Long((index2 * key + sum2)) % modValue);
    }

    private int[] getPrefixSum(ArrayList<Integer> list) {
        int[] prefixSum = new int[list.size()];
        int index = 0;
        prefixSum[index++] = list.get(0);
        for (int i = 1; i < list.size(); i++)
            prefixSum[index++] = list.get(i) + prefixSum[i - 1];
        return prefixSum;
    }

    private int getIndexTillMin(ArrayList<Integer> list, Integer key) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > key)
                return i;
        }
        return list.size();
    }

}
