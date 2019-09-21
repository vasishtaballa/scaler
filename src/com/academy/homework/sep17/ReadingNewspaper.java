package com.academy.homework.sep17;

/*Question: 
You have a newspaper which has A lines to read. You decided to start reading the 1st line from Monday. You are given a schedule, B, where B[i] = number of lines you can read on that day. You are very strict in reading the newspaper and you will read as much as you can every day. Determine and return, which day of the week you will read the last line of the newspaper
Input Format:
The first argument contains the single integer A — the number of lines in the newspaper.
The second argument is an array B, of size 7 and those integers represent how many lines you can read on Monday, Tuesday, Wednesday, Thursday, Friday, Saturday and Sunday correspondingly.

Note: It is guaranteed that at least one of the number in B[i] is larger than zero.*/

/*Input 1:
    A = 100  
    B = [15, 20, 20, 15, 10, 30, 45]

Output 1:
    6

Explanation 1:
    By the end of Monday and therefore, by the beginning of Tuesday, you will have 85 lines left. You have 65 lines left by Wednesday, 45 by Thursday, 30 by Friday, 20 by Saturday and on Saturday, you will finish reading the newspaper.*/

public class ReadingNewspaper {
	public static void main(String[] args) {
		ReadingNewspaper obj = new ReadingNewspaper();
		int[] array = { 15, 20, 20, 15, 10, 30, 45 };
		System.out.println(obj.solve(100, array));
	}

	public int solve(int A, int[] B) {
		int count = 0;
		while (count < A) {
			for (int i = 0; i < B.length; i++) {
				count += B[i];
				if (count >= A)
					return i + 1;
			}
		}
		return 0;
	}
}
