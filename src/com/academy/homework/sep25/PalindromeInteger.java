package com.academy.homework.sep25;

// Question: https://www.interviewbit.com/problems/palindrome-integer/

public class PalindromeInteger {

	public static void main(String[] args) {
		PalindromeInteger obj = new PalindromeInteger();
		System.out.println(obj.isPalindrome(1212));
	}

	public int isPalindrome(int A) {
		int result = 0;
		int temp = A;
		if (A < 0)
			return 0;
		while (A > 0) {
			result = result * 10 + A % 10;
			A /= 10;
		}
		return result == temp ? 1 : 0;
	}

}
