package com.scaler.academy.homework.oct16;

// Question:

import com.scaler.academy.assignment.util.ArrayUtils;

import java.util.ArrayList;
import java.util.Collections;

public class ProductOfSums {

    Long modValue = new Long(1000000007);

    public static void main(String[] args) {
        ProductOfSums obj = new ProductOfSums();
        int[] array1 = {1, 2};
        int[] array2 = {4, 4};
        int[] array3 = {2, 3, 4, 5};
        System.out.println(obj.getSum(2, 2, 4, (ArrayList<Integer>) ArrayUtils.getListFromArray(array1), (ArrayList<Integer>) ArrayUtils.getListFromArray(array2), (ArrayList<Integer>) ArrayUtils.getListFromArray(array3)));
    }

    public int getSum(int A, int B, int C, ArrayList<Integer> D, ArrayList<Integer> E, ArrayList<Integer> F) {
        Collections.sort(D);
        Collections.sort(E);
        Collections.sort(F);
        Long sum = new Long(0);
        for (int i = 0; i < E.size(); i++) {
            for (int j = 0; j < D.size(); j++) {
                for (int k = 0; k < F.size(); k++) {
                    if (D.get(j) <= E.get(i) && F.get(k) <= E.get(i)) {
                        sum = sum + getValue(new Long(D.get(j)), new Long(E.get(i)), new Long(F.get(k)));
                        sum %= modValue;
                    }
                }
            }
        }
        return (int) (long) sum;
    }

    private Long getValue(Long A, Long B, Long C) {
        return (((A + B) % modValue) * ((B + C) % modValue)) % modValue;
    }
}
