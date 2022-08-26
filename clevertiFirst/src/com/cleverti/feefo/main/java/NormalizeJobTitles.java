package com.cleverti.feefo.main.java;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class NormalizeJobTitles{

    private static double compare(String s1, String s2){
        String longer = s1, shorter = s2;
        if (s1.length() < s2.length()) {
            longer = s2; shorter = s1;
        }
        int longerLength = longer.length();
        if (longerLength == 0) {
            return 1.0;
        }

        return (longerLength - qualityScore(longer, shorter)) / (double) longerLength;
    }

    private static int qualityScore(String s1, String s2){
        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();

        int[] costs = new int[s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            int lastValue = i;
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0)
                    costs[j] = j;
                else {
                    if (j > 0) {
                        int newValue = costs[j - 1];
                        if (s1.charAt(i - 1) != s2.charAt(j - 1))
                            newValue = Math.min(Math.min(newValue, lastValue), costs[j]) + 1;
                        costs[j - 1] = lastValue;
                        lastValue = newValue;
                    }
                }
            }
            if (i > 0) {
                costs[s2.length()] = lastValue;
            }
        }
        return costs[s2.length()];
    }

    public static String normalise(String s){
        NormalizedJobTitlesEnum normalizedJobTitlesEnum[] = NormalizedJobTitlesEnum.values();
        HashMap<Double, String> map = new HashMap<>();

        for (NormalizedJobTitlesEnum jobTitlesEnum : normalizedJobTitlesEnum){
            map.put(NormalizeJobTitles.compare(s, jobTitlesEnum.toString()), jobTitlesEnum.toString());
        }

        Double maxValueInMap = Collections.max(map.keySet());
        for (Map.Entry<Double, String> entry : map.entrySet()){
            if (entry.getKey() == maxValueInMap) {
                return entry.getValue();
            }
        }
        return null;

    }
}
