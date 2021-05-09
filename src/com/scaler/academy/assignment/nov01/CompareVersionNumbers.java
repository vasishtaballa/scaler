package com.scaler.academy.assignment.nov01;

// Question: https://leetcode.com/problems/compare-version-numbers/

public class CompareVersionNumbers {
    public static void main(String[] args) {
        CompareVersionNumbers obj = new CompareVersionNumbers();
        System.out.println(obj.compareVersion("4444371174137455", "5.168"));
    }

    public int compareVersion(String A, String B) {
        // Splitting the string based on '.' character
        String[] ATokens = A.split("\\.");
        String[] BTokens = B.split("\\.");
        int i = 0, j = 0;
        // Iterating each token in the version and comparing two string's tokens
        for (; i < ATokens.length && j < BTokens.length; i++, j++) {
            String AToken = ATokens[i], BToken = BTokens[j];
            int result = compareEachToken(AToken, BToken);
            if (result != 0)
                return result;
        }
        while (i < ATokens.length) {
            int AValue = compareEachToken(ATokens[i]);
            if (AValue != 0)
                return 1;
            i++;
        }
        while (j < BTokens.length) {
            int BValue = compareEachToken(BTokens[i]);
            if (BValue != 0)
                return -1;
            j++;
        }
        return 0;
    }

    private int compareEachToken(String token) {
        int i = 0;
        while (i < token.length() && token.charAt(i) == '0')
            i++;
        if (i == token.length())
            return 0;
        return 1;
    }

    private int compareEachToken(String aToken, String bToken) {
        int i = 0, j = 0;
        // If Leading Zeroes are there, we should not include them in comparison. Hence, moving both the pointers till leading zeroes were there
        while (i < aToken.length() && aToken.charAt(i) == '0')
            i++;
        while (j < bToken.length() && bToken.charAt(j) == '0')
            j++;
        // If aToken's length is greater than bToken's length, then we can assume that aToken is greater than bToken
        // Minus i operation is to get rid of the leading zeroes
        if (aToken.length() - i > bToken.length() - j)
            return 1;
        else if (aToken.length() - i < bToken.length() - j)
            return -1;
        // If both the token's length are equal, then iterate each character and compare each other
        while (i < aToken.length() && j < bToken.length()) {
            if (aToken.charAt(i) < bToken.charAt(j))
                return -1;
            else if (aToken.charAt(i) > bToken.charAt(j))
                return 1;
            i++;
            j++;
        }
        return 0;
    }
}
