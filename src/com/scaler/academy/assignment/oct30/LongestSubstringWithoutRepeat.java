package com.scaler.academy.assignment.oct30;

import java.util.HashSet;
import java.util.Set;

// Question: https://www.interviewbit.com/problems/longest-substring-without-repeat/

public class LongestSubstringWithoutRepeat {
    public static void main(String[] args) {
        LongestSubstringWithoutRepeat obj = new LongestSubstringWithoutRepeat();
        System.out.println(obj.lengthOfLongestSubstring("abcabcbb"));
    }

    public int lengthOfLongestSubstring(String A) {
        Set<Character> set = new HashSet<>();
        int maxLength = Integer.MIN_VALUE, left = 0;
        for (int i = 0; i < A.length(); i++) {
            // Iterating each character in string and remove the character if duplicate in the current window
            while (set.contains(A.charAt(i))) {
                set.remove(A.charAt(left));
                left++;
            }
            set.add(A.charAt(i));
            maxLength = Math.max(maxLength, set.size());
        }
        return maxLength;
    }
}
