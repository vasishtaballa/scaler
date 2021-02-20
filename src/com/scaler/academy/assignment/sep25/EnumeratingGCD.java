package com.scaler.academy.assignment.sep25;

/*Question:
Enumerating GCD.
You are given a number P and a number Q. Greatest Common Divisor (GCD) of all numbers 
between P and Q inclusive is taken (GCD(P, P+1, P+2 ... Q)). 
As this problem looks a bit easy, it is given that numbers P and Q can be in the range 
of 10100. You have to return the value of GCD found. Greatest common divisor of 2 numbers 
A and B is the largest number D that divides both A and B perfectly.
Input:
P: 1
Q: 3

Output:
1

Greatest divisor that divides both 1 and 3 is 1.

Input:
P: 3412
Q: 3412


Output:
3412

As both the numbers are the same, greatest divisor that divides 3412 is 3412.*/

public class EnumeratingGCD {
	public static void main(String[] args) {
		EnumeratingGCD obj = new EnumeratingGCD();
		System.out.println(obj.solve("34", "39"));
	}

	public String solve(String A, String B) {
		if (A.equals(B))
			return A;
		return "1";
	}
}
