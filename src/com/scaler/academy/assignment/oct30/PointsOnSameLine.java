package com.scaler.academy.assignment.oct30;

// Question: https://www.geeksforgeeks.org/count-maximum-points-on-same-line/

import com.scaler.academy.assignment.util.ArrayUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PointsOnSameLine {

    public static void main(String[] args) {
        PointsOnSameLine obj = new PointsOnSameLine();
        int[] array1 = {6, -5, 3, -6, 3, -9, -8, -7};
        int[] array2 = {5, 0, -8, 1, -1, 6, 3, -3};
        System.out.println(
                obj.solve(
                        (ArrayList<Integer>) ArrayUtils.getListFromArray(array1),
                        (ArrayList<Integer>) ArrayUtils.getListFromArray(array2)));
    }

    public int solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        int maximumPoints = Integer.MIN_VALUE;
        if (A.size() < 2)
            return 0;
        // For every point, check slope of every other point and check where slopes are getting equal
        // If the slope of this point with some other points are equal, then this point is collinear with those points (lies on same line)
        // Let's have slope to count of points map for each point.
        for (int i = 0; i < A.size(); i++) {
            int samePoints = 0, verticalPoints = 0, currentMax = Integer.MIN_VALUE;
            Map<List<Integer>, Integer> slopeToCountMap = new HashMap<>();
            for (int j = i + 1; j < A.size(); j++) {
                // Check if both the points are exactly equal, if so no need to calculate slope etc. We can count it as on same line
                int x1 = A.get(i), y1 = B.get(i), x2 = A.get(j), y2 = B.get(j);
                if (isSamePoint(x1, y1, x2, y2))
                    samePoints++;
                    // Check if both x co-ordinates are same. If same slope would be infinity slope(m) = (y2 - y1)/(x2 - x1)
                else if (A.get(i) == A.get(j))
                    verticalPoints++;
                /* Check slope of ith point for this jth point and store in map. Since slope would be in double which might loose
                precision, Let's reduce both numerator and denominator of slope to smaller number by dividing both of them with
                their gcd */
                else {
                    int xDiff = A.get(j) - A.get(i);
                    int yDiff = B.get(j) - B.get(i);
                    int gcd = gcd(xDiff, yDiff);
                    xDiff /= gcd;
                    yDiff /= gcd;
                    List<Integer> list = new ArrayList<>();
                    list.add(xDiff);
                    list.add(yDiff);
                    if (slopeToCountMap.get(list) != null)
                        slopeToCountMap.put(list, slopeToCountMap.get(list) + 1);
                    else
                        slopeToCountMap.put(list, 1);
                    currentMax = Math.max(currentMax, slopeToCountMap.get(list));
                }
                /* Checking if the points on the same line are greater than that of single vertical line
                (basically any line which is parallel to any axis) */
                currentMax = Math.max(currentMax, verticalPoints);
            }
            slopeToCountMap.clear();
            maximumPoints = Math.max(maximumPoints, currentMax + samePoints + 1);
        }
        return maximumPoints;
    }

    private int gcd(int a, int b) {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }

    private boolean isSamePoint(int x1, int y1, int x2, int y2) {
        return x1 == x2 && y1 == y2;
    }
}
