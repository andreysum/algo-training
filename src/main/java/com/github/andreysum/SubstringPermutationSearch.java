package com.github.andreysum;
import java.io.*;
import java.util.*;

class SubstringPermutationSearch {
    public static void main(String[] args) throws FileNotFoundException {
        SubstringPermutationSearch m = new SubstringPermutationSearch();
        //        m.generate();
        long start = System.currentTimeMillis();
        m.run();
        long end = System.currentTimeMillis();
        System.out.println(end - start + " ms");
    }

    void generate() throws FileNotFoundException {
        final PrintWriter printWriter = new PrintWriter(new File("input.txt"));
        final Random random = new Random();
        for (int i = 0; i < 10; i++) {
            printWriter.print((char) ('a' + random.nextInt(26)));
        }
        printWriter.println();
        for (int i = 0; i < 8; i++) {
            printWriter.print((char) ('a' + random.nextInt(26)));
        }
        printWriter.close();
    }

    void run() {
        Scanner s = null;
        try {
            s = new Scanner(new File("input.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        char[] str = s.next().toCharArray();
        char[] subStr = s.next().toCharArray();
        int res = search(str, subStr);
        System.out.println(res);
    }

    public int search(char[] str, char[] subStr) {
        if (str.length == 0 || subStr.length == 0 || str.length < subStr.length) {
            return -1;
        }
        Map<Character, Integer> subStrAr = new HashMap<>();
        Map<Character, Integer> subStrCount = new HashMap<>();
        for (char ssc : subStr) {
            subStrAr.compute(ssc, (k, v) -> Objects.isNull(v) ? 1 : v + 1);
        }
        int uc = subStrAr.size();
        int mc = 0;
        for (int i = 0; i < str.length; i++) {
            char in = str[i];
            int outIndex = i - subStr.length;
            int out = outIndex >= 0 ? str[outIndex] : -1;

            if (subStrAr.containsKey(in)) {
                Integer oldVal = subStrCount.getOrDefault(in, -1);
                subStrCount.compute(in, (k, v) -> Objects.isNull(v) ? 1 : v + 1);
                Integer newVal = subStrCount.get(in);
                if (oldVal.equals(subStrAr.get(in))) {
                    mc--;
                } else if (newVal.equals(subStrAr.get(in))) {
                    mc++;
                }
            }
            if (out >= 0) {
                char outc = (char) out;
                if (subStrCount.containsKey(outc) && subStrAr.containsKey(outc)) {
                    Integer oldVal = subStrCount.get(outc);
                    subStrCount.compute(outc, (k, v) -> v - 1);
                    Integer newVal = subStrCount.get(outc);
                    if (oldVal.equals(subStrAr.get(outc))) {
                        mc--;
                    } else if (newVal.equals(subStrAr.get(outc))) {
                        mc++;
                    }
                }
            }
            if (uc == mc) {
                return i - subStr.length + 1;
            }
        }
        return -1;
    }
}
