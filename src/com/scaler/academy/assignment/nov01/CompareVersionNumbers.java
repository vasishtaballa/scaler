package com.scaler.academy.assignment.nov01;

// Question: https://leetcode.com/problems/compare-version-numbers/

public class CompareVersionNumbers {
    public static void main(String[] args) {
        CompareVersionNumbers obj = new CompareVersionNumbers();
        System.out.println(obj.compareVersion("1.2", "1.13.4"));
    }

    public int compareVersion(String A, String B) {
        int i = 0, j = 0;
        while (i < A.length() && j < B.length()) {
            if (A.charAt(i) < B.charAt(j))
                return -1;
            else if (A.charAt(i) > B.charAt(j))
                return 1;
            i++;
            j++;
        }
        if (i != A.length())
            return 1;
        if (j != B.length())
            return -1;
        return 0;
    }
}
