package com.scaler.academy.homework.nov01;

// Question: https://www.interviewbit.com/problems/pretty-json/

import java.util.ArrayList;
import java.util.List;

public class PrettyJson {

    public static void main(String[] args) {
        PrettyJson obj = new PrettyJson();
        String[] result = obj.prettyJSON("{\"attributes\":[{\"nm\":\"ACCOUNT\",\"lv\":[{\"v\":{\"Id\":null,\"State\":null},\"vt\":\"java.util.Map\",\"cn\":1}],\"vt\":\"java.util.Map\",\"status\":\"SUCCESS\",\"lmd\":13585},{\"nm\":\"PROFILE\",\"lv\":[{\"v\":{\"Party\":null,\"Ads\":null},\"vt\":\"java.util.Map\",\"cn\":2}],\"vt\":\"java.util.Map\",\"status\":\"SUCCESS\",\"lmd\":41962}]}");
        for (String str : result) {
            System.out.println(str);
        }
    }

    public String[] prettyJSON(String A) {
        List<String> result = new ArrayList<>();
        String[] tokens = A.split(",");
        int tabs = 0;
        boolean isSameLineComma = false;
        StringBuilder onGoingString = new StringBuilder();
        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i].trim();
            isSameLineComma = false;
            if (!token.isEmpty()) {
                int index = 0;
                while (index < token.length()) {
                    char ch = token.charAt(index);
                    if (ch == '{' || ch == '[') {
                        if (onGoingString.length() > 0) {
                            String withTabs = prefixWithTabs(onGoingString.toString(), tabs);
                            if (!withTabs.isEmpty())
                                result.add(withTabs);
                            onGoingString.delete(0, onGoingString.length());
                        }
                        String withTabs = prefixWithTabs(String.valueOf(ch), tabs);
                        if (!withTabs.isEmpty())
                            result.add(withTabs);
                        tabs++;
                    } else if (ch == '}' || ch == ']') {
                        if (onGoingString.length() > 0) {
                            String withTabs = prefixWithTabs(onGoingString.toString(), tabs);
                            if (!withTabs.isEmpty())
                                result.add(withTabs);
                            onGoingString.delete(0, onGoingString.length());
                        }
                        tabs--;
                        String withTabs = prefixWithTabs(String.valueOf(ch), tabs);
                        if (index < token.length() - 1 && (token.charAt(index + 1) == '}' || token.charAt(index + 1) == ']')) {
                            index++;
                        } else if (i < tokens.length - 1 && (tokens[i + 1].charAt(0) != '}' && tokens[i + 1].charAt(0) != ']')) {
                            withTabs = withTabs + ',';
                            isSameLineComma = true;
                        }
                        if (!withTabs.isEmpty())
                            result.add(withTabs);
                    } else {
                        onGoingString.append(ch);
                    }
                    index++;
                }
                if (i != tokens.length - 1 && !isSameLineComma)
                    onGoingString.append(",");
                String withTabs = prefixWithTabs(onGoingString.toString(), tabs);
                if (!withTabs.isEmpty() && !isSameLineComma)
                    result.add(withTabs);
                onGoingString.delete(0, onGoingString.length());
            }
        }
        String[] array = new String[result.size()];
        int i = 0;
        for (String s : result)
            array[i++] = s;
        return array;
    }

    private String prefixWithTabs(String value, int tabs) {
        StringBuilder builder = new StringBuilder();
        while (tabs-- > 0)
            builder.append("\t");
        builder.append(value);
        return builder.toString();
    }
}
