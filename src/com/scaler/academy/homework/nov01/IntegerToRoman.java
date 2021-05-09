package com.scaler.academy.homework.nov01;

// Question: https://www.interviewbit.com/problems/integer-to-roman/

import java.util.HashMap;
import java.util.Map;

public class IntegerToRoman {

    public static void main(String[] args) {
        IntegerToRoman obj = new IntegerToRoman();
        System.out.println(obj.intToRoman(556));
    }

    public String intToRoman(int A) {
        Map<Integer, String> initMap = getInitMap();
        int temp = A, index = 0;
        StringBuilder roman = new StringBuilder();
        while (temp > 0) {
            index++;
            int digit = temp % 10;
            temp /= 10;
            String romanDigits = processDigit(digit, initMap, index);
            roman.insert(0, romanDigits);
        }
        return roman.toString();
    }

    private String processDigit(int digit, Map<Integer, String> initMap, int index) {
        String romansAtIndex = initMap.get(index);
        StringBuilder romans = new StringBuilder();
        if (isSpecialDigit(digit)) {
            // If the digit is special i.e. 4 or 9
            if (digit == 4)
                return romansAtIndex.replace(",", "");
            else {
                String romansAtNextIndex = initMap.get(index + 1);
                return romansAtIndex.charAt(0) + "" + romansAtNextIndex.charAt(0);
            }
        } else {
            if (digit > 5) {
                int remaining = digit - 5;
                romans.append(romansAtIndex.charAt(2));
                while (remaining-- > 0)
                    romans.append(romansAtIndex.charAt(0));
                return romans.toString();
            } else if (digit < 5) {
                while (digit-- > 0)
                    romans.append(romansAtIndex.charAt(0));
                return romans.toString();
            } else
                return String.valueOf(romansAtIndex.charAt(2));
        }
    }

    private Map<Integer, String> getInitMap() {
        Map<Integer, String> initMap = new HashMap<>();
        initMap.put(1, "I,V");
        initMap.put(2, "X,L");
        initMap.put(3, "C,D");
        initMap.put(4, "M");
        return initMap;
    }

    private boolean isSpecialDigit(int digit) {
        return digit == 4 || digit == 9;
    }

}
