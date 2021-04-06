package com.scaler.academy.assignment.oct30;

// Question: https://leetcode.com/problems/palindrome-pairs/

import com.scaler.academy.assignment.util.ArrayUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PalindromePairs {
    public static void main(String[] args) {
        PalindromePairs obj = new PalindromePairs();
        String[] array = {"abcd", "dcba", "lls", "s", "sssll", "abc"};
        List<ArrayList<Integer>> result = obj.solve((ArrayList<String>) ArrayUtils.getListFromArray(array));
        for (ArrayList<Integer> list : result)
            System.out.println(list);
    }

    public ArrayList<ArrayList<Integer>> solve(ArrayList<String> A) {
        Map<String, Integer> map = new HashMap<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int i = 0; i < A.size(); i++)
            map.put(A.get(i), i);
        for (int i = 0; i < A.size(); i++) {
            String string = A.get(i);
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < string.length(); j++) {
                sb.append(string.charAt(j));
                StringBuilder reverse = new StringBuilder(sb);
                reverse = reverse.reverse();
                if (map.containsKey(reverse.toString())) {
                    // reverse is present & now check if rest of the elements forms a palindrome.
                    if (isRestPalindrome(string, j) && i != map.get(reverse.toString())) {
                        ArrayList<Integer> pair = new ArrayList<>();
                        pair.add(i);
                        pair.add(map.get(reverse.toString()));
                        result.add(pair);
                    }
                }
            }

        }
        return result;
    }

    private boolean isRestPalindrome(String string, int from) {
        for (int i = from, j = string.length() - 1; i <= string.length() / 2; i++, j--) {
            if (string.charAt(i) != string.charAt(j))
                return false;
        }
        return true;
    }


}
