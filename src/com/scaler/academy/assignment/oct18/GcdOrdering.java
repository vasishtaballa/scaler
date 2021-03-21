package com.scaler.academy.assignment.oct18;

// Question: https://www.geeksforgeeks.org/lexicographically-largest-permutation-of-the-array-such-that-ai-ai-1-gcdai-1-ai-2/

import com.scaler.academy.assignment.util.ArrayUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GcdOrdering {
    public static void main(String[] args) {
        GcdOrdering obj = new GcdOrdering();
        int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        List<Integer> result = obj.solve((ArrayList<Integer>) ArrayUtils.getListFromArray(array));
        System.out.println(result.toString());
    }

    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        ArrayList<Integer> result = new ArrayList<>();
        Collections.sort(A);
        if (A.size() < 3) {
            for (int i = A.size() - 1; i >= 0; i--)
                result.add(A.get(i));
            return A;
        }
        boolean isObeying = true;
        int notObeyingIndex = -1;
        for (int i = 2; i < A.size(); i++) {
            if (A.get(i) != A.get(i - 1) + gcd(A.get(i - 1), A.get(i - 2))) {
                isObeying = false;
                notObeyingIndex = i;
                break;
            }
        }
        if (isObeying) {
            // Check for lexicographically largest permutation now
            if (A.get(1) == A.get(0) + gcd(A.get(0), A.get(A.size() - 1))) {
                result.add(A.get(A.size() - 1));
                result.addAll(A);
                result.remove(result.size() - 1);
            } else {
                result.addAll(A);
            }
            return result;
        } else {
            // Need to re-arrange the array to find the permutation
            isObeying = true;
            if (A.get(1) == A.get(0) + gcd(A.get(0), A.get(notObeyingIndex))) {
                for (int i = A.size() - 1; i >= notObeyingIndex + 2; i--) {
                    if (A.get(i) != A.get(i - 1) + gcd(A.get(i - 1), A.get(i - 2))) {
                        isObeying = false;
                        break;
                    }
                }
                if (isObeying && notObeyingIndex < A.size() - 1) {
                    if (A.get(notObeyingIndex + 1) != A.get(notObeyingIndex - 1) + gcd(A.get(notObeyingIndex - 1), A.get(notObeyingIndex - 2)))
                        isObeying = false;
                }
                if (isObeying && notObeyingIndex < A.size() - 2) {
                    if (A.get(notObeyingIndex + 2) != A.get(notObeyingIndex + 1) + gcd(A.get(notObeyingIndex + 1), A.get(notObeyingIndex - 1)))
                        isObeying = false;
                }
                if (isObeying) {
                    result.add(A.get(notObeyingIndex));
                    for (int i = 0; i < A.size(); i++) {
                        if (i != notObeyingIndex)
                            result.add(A.get(i));
                    }
                    return result;
                }
            }
        }
        result.add(-1);
        return result;
    }

    private int gcd(int a, int b) {
        if (a == 0)
            return b;
        if (b == 0)
            return a;
        if (a == b)
            return a;
        if (a > b)
            return gcd(a - b, b);
        return gcd(a, b - a);
    }

}
