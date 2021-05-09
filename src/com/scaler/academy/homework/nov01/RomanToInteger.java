package com.scaler.academy.homework.nov01;

// Question: https://www.interviewbit.com/problems/roman-to-integer/

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    public static void main(String[] args) {
        RomanToInteger obj = new RomanToInteger();
        System.out.println(obj.romanToInt("MMMDCCCLXIV"));
    }

    public int romanToInt(String A) {
        Map<Character, Integer> initMap = getInitMap();
        int result = 0;
        for (int i = 0; i < A.length(); i++) {
            int value = initMap.get(A.charAt(i));
            if (i + 1 < A.length()) {
                // If there exists any number to its right, then check whether we need to subtract or add
                int nextValue = initMap.get(A.charAt(i + 1));
                if (value >= nextValue)
                    result += value; // do normal addition
                else {
                    // do subtraction and then addition
                    result += (nextValue - value);
                    i++;
                }
            } else
                result += value; // for just last character, add the digit
        }
        return result;
    }

    private Map<Character, Integer> getInitMap() {
        Map<Character, Integer> initMap = new HashMap<>();
        initMap.put('M', 1000);
        initMap.put('D', 500);
        initMap.put('C', 100);
        initMap.put('L', 50);
        initMap.put('X', 10);
        initMap.put('V', 5);
        initMap.put('I', 1);
        return initMap;
    }

}
