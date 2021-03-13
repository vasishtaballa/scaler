package com.scaler.academy.homework.oct16;

// Question: https://leetcode.com/problems/corporate-flight-bookings/

import com.scaler.academy.assignment.util.ArrayUtils;

import java.util.ArrayList;
import java.util.List;


public class FlightRangeBookings {

    public static void main(String[] args) {
        FlightRangeBookings obj = new FlightRangeBookings();
        int[][] bookings = {
                {1, 2, 10},
                {2, 3, 20},
                {2, 5, 25}
        };
        List<Integer> result = obj.solve(5, (ArrayList<ArrayList<Integer>>) ArrayUtils.getListFromMatrix(bookings));
        for (Integer integer : result)
            System.out.println(integer);
    }

    public ArrayList<Integer> solve(int A, ArrayList<ArrayList<Integer>> B) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < A + 1; i++)
            result.add(0);
        for (int i = 0; i < B.size(); i++) {
            ArrayList<Integer> flightBookings = B.get(i);
            result.set(flightBookings.get(0) - 1, result.get(flightBookings.get(0) - 1) + flightBookings.get(2));
            result.set(flightBookings.get(1), result.get(flightBookings.get(1)) - flightBookings.get(2));
        }
        for (int i = 1; i < result.size(); i++)
            result.set(i, result.get(i - 1) + result.get(i));
        result.remove(result.size() - 1);
        return result;
    }
}
