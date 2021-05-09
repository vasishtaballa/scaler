package com.scaler.academy.homework.nov01;

// Question: https://leetcode.com/problems/implement-strstr/

public class ImplementStrStr {

    public static void main(String[] args) {
        ImplementStrStr obj = new ImplementStrStr();
        System.out.println(obj.strStr("helloworld", "owo"));
    }

    public int strStr(final String A, final String B) {
        if (A == null || B == null || A.isEmpty() || B.isEmpty())
            return -1;
        int[] lpsArray = getLPSArray(B);
        return getFirstMatchIndex(A, B, lpsArray);
    }

    private int getFirstMatchIndex(String a, String b, int[] lpsArray) {
        int i = 0, j = 0;
        while (i < a.length()) {
            // Match found
            if (j == b.length())
                return i - b.length();
            if (a.charAt(i) == b.charAt(j)) {
                i++;
                j++;
            } else {
                while (true) {
                    if (a.charAt(i) == b.charAt(j))
                        break;
                    if (j == 0) {
                        if (a.charAt(i) != b.charAt(j)) {
                            i++;
                            break;
                        }
                    }
                    j = lpsArray[j - 1];
                }
            }
        }
        // Match found
        if (j == b.length())
            return i - b.length();
        return -1;
    }

    private int[] getLPSArray(String string) {
        int[] lpsArray = new int[string.length()];
        char[] chars = string.toCharArray();
        lpsArray[0] = 0;
        int i = 1, j = 0;
        while (i < chars.length) {
            if (chars[i] != chars[j]) {
                while (true) {
                    if (chars[i] == chars[j]) {
                        lpsArray[i] = j + 1;
                        j++;
                        break;
                    }
                    if (j == 0) {
                        if (chars[i] == chars[j])
                            lpsArray[i] = j + 1;
                        else
                            lpsArray[i] = 0;
                        break;
                    }
                    j = lpsArray[j - 1];
                }
                i++;
            } else {
                lpsArray[i] = j + 1;
                i++;
                j++;
            }
        }
        return lpsArray;
    }

}
