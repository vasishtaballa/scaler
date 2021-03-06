package com.scaler.academy.homework.oct14;

// Question: https://www.interviewbit.com/problems/palindrome-partitioning/

import java.util.ArrayList;

public class PalindromePartitioning {

    public static void main(String[] args) {
        PalindromePartitioning obj = new PalindromePartitioning();
        ArrayList<ArrayList<String>> result = obj.partition("ccaabb");
        for (ArrayList<String> list : result)
            System.out.println(list.toString());
    }

    public ArrayList<ArrayList<String>> partition(String a) {
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        ArrayList<String> aux = new ArrayList<>();
        partitionUtil(a, aux, result, 0);
        return result;
    }

    private void partitionUtil(String string, ArrayList<String> aux, ArrayList<ArrayList<String>> result, int index) {
        if (index == string.length()) {
            result.add((ArrayList<String>) aux.clone());
            return;
        }
        for (int i = index; i < string.length(); i++) {
            if (isPalindrome(string, index, i)) {
                aux.add(string.substring(index, i + 1));
                partitionUtil(string, aux, result, i + 1);
                aux.remove(aux.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String string, int start, int end) {
        while (start <= end) {
            if (string.charAt(start) != string.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }

}
