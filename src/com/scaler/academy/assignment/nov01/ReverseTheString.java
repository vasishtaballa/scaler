package com.scaler.academy.assignment.nov01;

// Question: https://www.interviewbit.com/problems/reverse-the-string/

public class ReverseTheString {

    public static void main(String[] args) {
        ReverseTheString obj = new ReverseTheString();
        System.out.println(obj.solve("       fwbpudnbrozzifml osdt ulc jsx kxorifrhubk ouhsuhf sswz qfho dqmy sn myq igjgip iwfcqq                 "));
    }

    public String solve(String A) {
        // Splitting the string based on space character
        String[] tokens = A.split(" ");
        StringBuilder result = new StringBuilder();
        // Iterating each token from right side and appending it to StringBuilder
        for (int i = tokens.length - 1; i >= 0; i--) {
            String token = tokens[i].trim();
            if (!token.isEmpty())
                result.append(token).append(" ");
        }
        // Removing last space which was added on above line for each word
        result.deleteCharAt(result.length() - 1);
        return result.toString();
    }
}
