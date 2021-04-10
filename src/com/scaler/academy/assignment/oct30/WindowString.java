package com.scaler.academy.assignment.oct30;

import java.util.HashMap;
import java.util.Map;

public class WindowString {
    public static void main(String[] args) {
        WindowString obj = new WindowString();
        System.out.println(obj.minWindow("AAAAAA", "AA"));
    }

    /**
     * Sliding window approach
     *
     * @param A
     * @param B
     * @return
     */
    public String minWindow(String A, String B) {
        if (A.length() < B.length())
            return "";
        Map<Character, Integer> frequencyMap = getFrequencyMap(B); // Getting frequency map
        int start = 0, head = 0, charsCovered = 0, minLength = Integer.MAX_VALUE;
        for (int tail = 0; tail < A.length(); tail++) {
            if (!frequencyMap.containsKey(A.charAt(tail)))
                continue;
            frequencyMap.put(A.charAt(tail), frequencyMap.get(A.charAt(tail)) - 1);
            // To check if some values are there in map and not relevant for us
            // Example: If 3As are there in string B and we encountered 4th A, then we don't need to count this in charsCovered
            if (frequencyMap.get(A.charAt(tail)) >= 0)
                charsCovered += 1;
            if (charsCovered == B.length()) {
                while (!frequencyMap.containsKey(A.charAt(head)) || frequencyMap.get(A.charAt(head)) < 0) {
                    if (frequencyMap.containsKey(A.charAt(head))) {
                        frequencyMap.put(A.charAt(head), frequencyMap.get(A.charAt(head)) + 1);
                    }
                    head++;
                }
                if (minLength > tail - head + 1) {
                    minLength = tail - head + 1;
                    start = head;
                }
            }
        }
        if (minLength == Integer.MAX_VALUE)
            return "";
        return A.substring(start, start + minLength);
    }

    private Map<Character, Integer> getFrequencyMap(String B) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (int i = 0; i < B.length(); i++) {
            if (frequencyMap.containsKey(B.charAt(i)))
                frequencyMap.put(B.charAt(i), frequencyMap.get(B.charAt(i)) + 1);
            else
                frequencyMap.put(B.charAt(i), 1);
        }
        return frequencyMap;
    }

}
