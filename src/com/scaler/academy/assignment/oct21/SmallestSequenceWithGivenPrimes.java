package com.scaler.academy.assignment.oct21;

// Question: https://www.interviewbit.com/problems/smallest-sequence-with-given-primes/

import java.util.ArrayList;
import java.util.List;

public class SmallestSequenceWithGivenPrimes {
    public static void main(String[] args) {
        SmallestSequenceWithGivenPrimes obj = new SmallestSequenceWithGivenPrimes();
        List<Integer> result = obj.solve(3, 11, 7, 50);
        System.out.println(result.toString());
    }

    public ArrayList<Integer> solve(int A, int B, int C, int D) {
        int i = 0, j = 0, k = 0, count = 0;
        ArrayList<Integer> result = new ArrayList<>(D + 1);
        result.add(1);
        while (count < D) {
            int num1 = result.get(i) * A;
            int num2 = result.get(j) * B;
            int num3 = result.get(k) * C;
            int minimum = Math.min(num1, Math.min(num2, num3));
            if (minimum == num1) i++;
            if (minimum == num2) j++;
            if (minimum == num3) k++;
            result.add(minimum);
            count++;
        }
        result.remove(0);
        return result;
    }
}
