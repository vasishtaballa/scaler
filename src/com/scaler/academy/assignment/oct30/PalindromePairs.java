package com.scaler.academy.assignment.oct30;

// Question: https://leetcode.com/problems/palindrome-pairs/

// Follow this article, for more help: https://leetcode.com/problems/palindrome-pairs/discuss/79210/The-Easy-to-unserstand-JAVA-Solution

import com.scaler.academy.assignment.util.ArrayUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PalindromePairs {

    public static void main(String[] args) {
        PalindromePairs obj = new PalindromePairs();
        String[] array = {"abcd", "dcba", "lls", "s", "sssll"};
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
            for (int j = 0; j < string.length(); j++) {
                // For each word, get all substrings and for each substring, check if other part is palindrome and there exists
                // a reverse of the current substring, then they will form a palindrome pair.
                String left = string.substring(0, j + 1);
                String right = string.substring(j + 1);
                if (isPalindrome(left, 0, left.length() - 1)) {
                    String rightRev = new StringBuilder(right).reverse().toString();
                    if (map.containsKey(rightRev)) {
                        if (i != map.get(rightRev)) {
                            ArrayList<Integer> pair = new ArrayList<>();
                            pair.add(map.get(rightRev));
                            pair.add(i);
                            result.add(pair);
                        }
                    }
                }
                if (isPalindrome(right, 0, right.length() - 1)) {
                    String leftRev = new StringBuilder(left).reverse().toString();
                    if (map.containsKey(leftRev)) {
                        if (i != map.get(leftRev)) {
                            ArrayList<Integer> pair = new ArrayList<>();
                            pair.add(i);
                            pair.add(map.get(leftRev));
                            result.add(pair);
                        }
                    }
                }
            }

        }
        return result;
    }

    private boolean isPalindrome(String string, int from, int end) {
        for (int i = from, j = end; i <= j; i++, j--) {
            if (string.charAt(i) != string.charAt(j))
                return false;
        }
        return true;
    }


}
