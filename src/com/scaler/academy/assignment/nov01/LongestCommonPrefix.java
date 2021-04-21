package com.scaler.academy.assignment.nov01;

// Question: https://www.interviewbit.com/problems/longest-common-prefix/

import com.scaler.academy.assignment.util.ArrayUtils;

import java.util.ArrayList;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        LongestCommonPrefix obj = new LongestCommonPrefix();
        String[] array = {"abcd", "abcd", "efgh"};
        System.out.println(obj.longestCommonPrefix((ArrayList<String>) ArrayUtils.getListFromArray(array)));
    }

    public String longestCommonPrefix(ArrayList<String> A) {
        // Finding the minimum length among all the strings. We can move our pointer till here
        int minLength = A.stream().mapToInt(String::length).min().getAsInt();
        int index = 0;
        boolean flag = false;
        // Moving the index till min length string
        while (index < minLength) {
            // For each index, check all string if the value is same or not, if it is not same for any of the string, break
            for (int i = 1; i < A.size(); i++) {
                char ch = A.get(0).charAt(index);
                if (A.get(i).charAt(index) != ch) {
                    flag = true;
                    break;
                }
                if (index >= minLength) {
                    flag = true;
                    break;
                }
            }
            if (flag)
                break;
            index++;
        }

        return A.get(0).substring(0, index);
    }
}
