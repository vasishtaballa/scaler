package com.scaler.academy.assignment.nov18;

/*
Area under the hills

Problem Description

Rishik likes to draw a lot. He starts at origin and chooses a single Y ordinate of each abscissa in [1-N] given in array A and then chooses 0 for N+1. He then joins each consecutive point with a straight line and found that he has drawn a masterpiece. But, It is incomplete without coloring.

So, he wants you to tell him the area of hills that he will color.



Problem Constraints
1 <= N <= 2e5

1 <= A[i] <= 2e9



Input Format
First and only argument of input contains a single integer array A.



Output Format
Return a string denoting area of hills(with truncated/rounded down decimal).



Example Input
Input 1:

 [2, 1, 3]
Input 2:

 [10]


Example Output
Output 1:

 "6"
Output 2:

 "10"
* */

public class AreaUnderTheHills {

    public static void main(String[] args) {
        AreaUnderTheHills obj = new AreaUnderTheHills();
        int[] array = new int[]{2, 1, 3};
        System.out.println(obj.solve(array));
    }

    /*
        The idea is to imagine the given picture and draw vertical lines to convert the plot into various triangles, and we can see that if we sum up the areas of the triangles that are formed
        will give the total area of the plot.
        Two variants of triangles will be formed (few left aligned and few right aligned). Sum of the individual areas will be 1/2 * (sum of elements)
        Area of the triangle: 1/2 * b * h. In one variant, base would be A[i] and height would be 1. In another variant height would be A[i] and base would be 1. Hence, area would be same in both
        If we carefully observe the pattern it would be nothing but sum of all the elements in the given array
     */
    public String solve(int[] A) {
        long sum = 0;
        for (int i = 0; i < A.length; i++) sum += A[i];
        return Long.toString(sum);
    }

}
