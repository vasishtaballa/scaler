package com.scaler.academy.homework.nov01;

// Question: https://www.interviewbit.com/problems/pretty-json/

import java.util.ArrayList;
import java.util.List;

public class PrettyJson {

    public static void main(String[] args) {
        PrettyJson obj = new PrettyJson();
        String[] result = obj.prettyJSON("{\"id\":100,\"firstName\":\"Jack\",\"lastName\":\"Jones\",\"age\":12}");
        for (String str : result)
            System.out.println(str);
    }

    public String[] prettyJSON(String A) {
        List<String> result = new ArrayList<>();
        StringBuilder onGoingString = new StringBuilder();
        int tabs = 0;
        for (int i = 0; i < A.length(); i++) {
            char ch = A.charAt(i);
            if (ch == '{' || ch == '[') {
                if (i < A.length() - 1 && A.charAt(i + 1) != ',') {
                    addToResult(onGoingString.toString(), tabs, result);
                    flushOnGoingString(onGoingString);
                    addToResult(String.valueOf(ch), tabs, result);
                } else if (i < A.length() - 1 && A.charAt(i + 1) == ',') {
                    addToResult(onGoingString.toString() + ',', tabs, result);
                    flushOnGoingString(onGoingString);
                    addToResult(String.valueOf(ch), tabs, result);
                    i++;
                }
                tabs++;
            } else if (ch == '}' || ch == ']') {
                if (i < A.length() - 1 && A.charAt(i + 1) != ',') {
                    addToResult(onGoingString.toString(), tabs, result);
                    flushOnGoingString(onGoingString);
                    tabs--;
                    addToResult(String.valueOf(ch), tabs, result);
                } else if (i < A.length() - 1 && A.charAt(i + 1) == ',') {
                    addToResult(onGoingString.toString(), tabs, result);
                    flushOnGoingString(onGoingString);
                    tabs--;
                    addToResult(String.valueOf(ch) + ',', tabs, result);
                    i++;
                } else {
                    addToResult(onGoingString.toString(), tabs, result);
                    flushOnGoingString(onGoingString);
                    tabs--;
                    addToResult(String.valueOf(ch), tabs, result);
                }
            } else if (ch == ',') {
                onGoingString.append(ch);
                addToResult(onGoingString.toString(), tabs, result);
                flushOnGoingString(onGoingString);
            } else {
                onGoingString.append(ch);
            }
        }
        return getResultInArray(result);
    }

    private void flushOnGoingString(StringBuilder onGoingString) {
        onGoingString.delete(0, onGoingString.length());
    }

    private void addToResult(String string, int tabs, List<String> result) {
        String withTabs = prefixWithTabs(string, tabs);
        if (!withTabs.trim().isEmpty())
            result.add(withTabs);
    }

    private String[] getResultInArray(List<String> result) {
        String[] resultArray = new String[result.size()];
        int index = 0;
        for (String s : result)
            resultArray[index++] = s;
        return resultArray;
    }

    private String prefixWithTabs(String value, int tabs) {
        StringBuilder builder = new StringBuilder();
        while (tabs-- > 0)
            builder.append("\t");
        builder.append(value);
        return builder.toString();
    }
}
