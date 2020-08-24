package com.github.andreysum;

import java.util.HashMap;
import java.util.Map;

class SubstringSearch {
    static int find(char[] t, char[] s) {
        if (s.length == 0 || t.length == 0) {
            return -1;
        }
        Map<Character, Integer> sFreqs = new HashMap<>();
        for (int i = 0; i < s.length; i++) {
            char nextS = s[i];
            if (sFreqs.containsKey(nextS)) {
                sFreqs.put(nextS, sFreqs.get(nextS) + 1);
            } else {
                sFreqs.put(nextS, 1);
            }
        }

        int progress = 0;
        Map<Character, Integer> subFreqs = new HashMap<>();
        for (int i = 0; i < t.length; i++) {
            char nextT = t[i];
            if (sFreqs.containsKey(nextT)) {
                if (subFreqs.containsKey(nextT)) {
                    subFreqs.put(nextT, subFreqs.get(nextT) + 1);
                } else {
                    subFreqs.put(nextT, 1);
                }
                if (subFreqs.get(nextT) == sFreqs.get(nextT)) {
                    progress++;
                }
            } else {
                subFreqs.clear();
                progress = 0;
            }
            if (progress == sFreqs.keySet().size()) {
                return i + 1 - s.length;
            }
        }
        return -1;
    }
}
