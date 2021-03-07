package com.scaler.academy.assignment.oct16;

// Question: https://leetcode.com/problems/k-closest-points-to-origin/

import com.scaler.academy.assignment.util.ArrayUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BClosestPointsToOrigin {

    public static void main(String[] args) {
        BClosestPointsToOrigin obj = new BClosestPointsToOrigin();
        int[][] points = {
                {1, 3},
                {-2, 2}
        };
        ArrayList<ArrayList<Integer>> result = obj.solve((ArrayList<ArrayList<Integer>>) ArrayUtils.getListFromMatrix(points), 1);
        for (ArrayList<Integer> list : result)
            System.out.println(list.toString());
    }

    public ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> A, int B) {
        List<Integer> distances = new ArrayList<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (ArrayList<Integer> point : A)
            distances.add(getDistanceFromOrigin(point));
        Collections.sort(distances);
        int kthMaxDistance = distances.get(B - 1);
        for (ArrayList<Integer> point : A) {
            int distance = getDistanceFromOrigin(point);
            if (distance <= kthMaxDistance)
                result.add(point);
        }
        return result;
    }

    private int getDistanceFromOrigin(ArrayList<Integer> point) {
        return point.get(0) * point.get(0) + point.get(1) * point.get(1);
    }
}
