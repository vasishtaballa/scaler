package com.scaler.academy.assignment.sep25;

/*Question:
	
Scooby has 3 three integers A, B and C. 
Scooby calls a positive integer special if it is divisible by B and it is divisible by C.
You need to tell number of special integers less than or equal to A.
Input:
12
3
2
Output:
2
Explanation:
The two integers divisible by 2 and 3 and less than or equal to 12 are 6,12.*/

public class DivisorGame {
	public static void main(String[] args) {
		DivisorGame obj = new DivisorGame();
		System.out.println(obj.solve(12, 3, 2));
	}

	public int solve(int A, int B, int C) {
		int gcd = gcd(B, C);
		int lcm = B * C / gcd;
		return A / lcm;
	}

	public int gcd(int A, int B) {
		if (A < B)
			return gcdUtil(A, B);
		return gcdUtil(B, A);
	}

	public int gcdUtil(int A, int B) {
		if (A == 0)
			return B;
		return gcdUtil(B % A, A);
	}
}
