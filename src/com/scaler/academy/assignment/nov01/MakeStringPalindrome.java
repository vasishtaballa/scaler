package com.scaler.academy.assignment.nov01;

// Question: https://www.interviewbit.com/problems/minimum-characters-required-to-make-a-string-palindromic/

public class MakeStringPalindrome {

    public static void main(String[] args) {
        MakeStringPalindrome obj = new MakeStringPalindrome();
        System.out.println(obj.solve("hqghumeaylnlfdxfi"));
    }

    /*
    The idea is to use KMP string pattern searching algorithm. Refer below links for brushing up KMP algorithm.
    https://www.geeksforgeeks.org/kmp-algorithm-for-pattern-searching/
    https://www.youtube.com/watch?v=GTJr8OvyEVQ

    We need to get largest suffix of the reversed string that matches the prefix of the original string. Because observe the below examples.
    Example1: madami -> If we want to make the string palindrome, since there is already a palindrome in the string, we just need to prepend 'i'
    in front. Ans: imadami -> 1 character
    Example2: aamadami -> If we want to make the string palindrome, since there is already a palindrome in the string, but this time its just
    prepending 'i' in front will not help. Ans: imadamaamadami -> we need to add palindrome again as prefix to get valid output, the reason
    being there are two more 'a's in front of the palindrome. This is nothing but adding i,m,a,d,a,m in front of the input to make the string
    palindrome.
    So, we need to find the largest suffix of the reversed string that matches the prefix of the original string.
    In Example1, the largest suffix is: madam. 'madam' is the largest suffix of the reversed string that matches prefix of the original string.
    We need to add 1 character apart from this 'madam'
    In Example2, the largest suffix is: aa. aa is the largest suffix of the reversed string that matches prefix of the original string.
    We need to add 6 characters apart from this 'aa'
     */
    public int solve(String A) {
        /*To find the largest suffix of the reversed string that matches the prefix of the original string, let's concat the original string with
        the reverse of the string (with one special char) and find the largest suffix using KMP algorithm. We are interested in the last value of the lps
        (longest prefix suffix) array, as that gives the largest suffix of the reversed string that matches the prefix of the original string.*/
        StringBuilder input = new StringBuilder(A);
        StringBuilder inputConcatReverse = input.append("$").append(new StringBuilder(A).reverse());
        int[] lpsArray = getLPSArray(inputConcatReverse.toString());
        return 0;
    }

    private int[] getLPSArray(String toString) {
        int[] lpsArray = new int[toString.length()];

        return lpsArray;
    }

}
