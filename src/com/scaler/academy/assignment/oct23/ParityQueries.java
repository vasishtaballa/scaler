package com.scaler.academy.assignment.oct23;

/*
Parity Queries
Problem Description

Given an empty multiset of integers initially and N queries to perform on it.

+ X — add non-negative integer X to the multiset. Note that there may be many occurrences of the same integer.

- X — delete a single occurrence of non-negative integer X from the multiset. It's guaranteed that there is at least one X in the multiset.

? S — count the number of integers in the multiset (with repetitions) that match some pattern S consisting of 0 and 1.

In the pattern, 0 stands for the even digits, while 1 stands for the odd. Integer X matches the pattern S if the parity of the ith from the right digit in decimal notation matches the ith from the right digit of the pattern.

If the pattern is shorter than this integer, it's supplemented with 0's from the left. Similarly, if the integer is shorter than the pattern, its decimal notation is supplemented with the 0's from the left.

For example, if the pattern is S = 010, then integers 92, 2212, 50, and 414 matches the pattern, while integers 3, 110, 25, and 1030 do not.

Given an array of characters A and an array of Strings B (representing the value of X for each query) of size N each, perform the queries and return the result for every third query in the form of an array of integers.



Problem Constraints
1 <= N <= 105

A[i] = {'+', '-', '?'}

0 <= B[i] <= 1018 (given in the form of string)



Input Format
The first argument given is the character array A.

The second argument given is the String array B.



Output Format
Return the answer for every third query in the form of an array of integers.



Example Input
Input 1:

 A = ['+', '+', '-', '?']
 B = [200, 200, 200, 0]
Input 2:

 A = ['+', '+', '?', '+', '-', '?']
 B = [1, 241, 1, 361, 241, 101]


Example Output
Output 1:

 [1]
Output 2:

 [2, 1]


Example Explanation
Explanation 1:

 Multiset after operation 1 : {200}
 Multiset after operation 2 : {200, 200}
 Multiset after operation 3 : {200}
 As only 1 element i.e. 200 in the multiset matches the pattern 0, thus answer is 1.
Explanation 2:

 Multiset after operation 1 : {1}
 Multiset after operation 2 : {1, 241}
 As both the elements i.e. 1 and 241 in the multiset match the pattern 1, thus answer is 2.
 Multiset after operation 3 : {1, 241, 361}
 Multiset after operation 1 : {1, 361}
 As only 1 element i.e. 361 in the multiset matches the pattern 101, thus answer is 1.
 */

import com.scaler.academy.assignment.util.ArrayUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParityQueries {
    public static void main(String[] args) {
        ParityQueries obj = new ParityQueries();
        char[] charArray = {'?', '+', '?', '?', '+', '+', '?', '+', '+', '+', '-', '+', '+', '?'};
        String[] stringArray = {"00", "99", "0", "10", "48", "17", "0", "89", "41", "63", "99", "83", "23", "00"};
        List<Integer> result = obj.solve((ArrayList<Character>) ArrayUtils.getListFromArray(charArray), (ArrayList<String>) ArrayUtils.getListFromArray(stringArray));
        System.out.println(result.toString());
    }

    public ArrayList<Integer> solve(ArrayList<Character> A, ArrayList<String> B) {
        Map<Long, Integer> map = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < A.size(); i++) {
            char operation = A.get(i);
            String operand = B.get(i);
            switch (operation) {
                case '+':
                    long encodedValue = getEncodedValue(operand);
                    if (map.containsKey(encodedValue))
                        map.put(encodedValue, map.get(encodedValue) + 1);
                    else
                        map.put(encodedValue, 1);
                    break;
                case '-':
                    encodedValue = getEncodedValue(operand);
                    map.put(encodedValue, map.get(encodedValue) - 1);
                    break;
                case '?':
                    long decodedValue = getDecimalFromBinary(operand);
                    result.add(map.getOrDefault(decodedValue, 0));
                    break;
                default:
                    System.out.println("Invalid input");
            }
        }
        return result;
    }

    private Long getEncodedValue(String operand) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < operand.length(); i++) {
            int remainder = Integer.valueOf(operand.charAt(i)) % 2;
            sb.append(remainder);
        }
        return getDecimalFromBinary(sb.toString());
    }

    private Long getDecimalFromBinary(String binaryNumber) {
        return Long.parseLong(binaryNumber, 2);
    }
}
