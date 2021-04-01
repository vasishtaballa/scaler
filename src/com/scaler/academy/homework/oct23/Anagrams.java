package com.scaler.academy.homework.oct23;

// Question: https://www.interviewbit.com/problems/anagrams/

import com.scaler.academy.assignment.util.ArrayUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Anagrams {
    public static void main(String[] args) {
        Anagrams obj = new Anagrams();
        String[] array = {"rat", "tar", "art"};
        List<ArrayList<Integer>> result = obj.anagrams(ArrayUtils.getListFromArray(array));
        for (ArrayList<Integer> list : result)
            System.out.println(list.toString());
    }

    public ArrayList<ArrayList<Integer>> anagrams(final List<String> A) {
        // To Maintain hash map of char and frequency for each string so that if same map comes, update corresponding list
        Map<Map<Character, Integer>, List<Integer>> mapFrequency = new HashMap<>();
        for (int i = 0; i < A.size(); i++) {
            String string = A.get(i);
            Map<Character, Integer> frequencyMap = new HashMap<>();
            // Preparing hashmap of char and count for one string
            for (int j = 0; j < string.length(); j++) {
                char character = string.charAt(j);
                if (frequencyMap.containsKey(character))
                    frequencyMap.put(character, frequencyMap.get(character) + 1);
                else
                    frequencyMap.put(character, 1);
            }
            // If this map is already present in main map, let's update the value (append index to existing map)
            if (mapFrequency.containsKey(frequencyMap))
                mapFrequency.get(frequencyMap).add(i + 1); // (i + 1) because the answer is based on 1-based index and not 0-based
            else {
                List<Integer> indexList = new ArrayList<>();
                indexList.add(i + 1); // (i + 1) because the answer is based on 1-based index and not 0-based
                mapFrequency.put(frequencyMap, indexList);
            }
        }
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        // Iterate the map and prepare ArrayList<ArrayList>
        mapFrequency.forEach((key, value) -> {
            result.add((ArrayList<Integer>) value);
        });
        return result;
    }
}
