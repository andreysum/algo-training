package com.github.andreysum;

import java.util.Scanner;

class MaxStairs {
    int[] d;
    public static void main(String[] args) {
        MaxStairs m = new MaxStairs();
        m.run();
    }

    void run() {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] ws = new int[n];
        for (int i = 0; i < n; i++) {
            ws[i] = s.nextInt();
        }
        d = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            d[i] = 0;
        }
        d[0] = 0;
        d[1] = ws[0];
        for (int i = 2; i <= n; i++) {
            d[i] = d[i - 1] + ws[i - 1];
            if (i - 2 >= 0) {
                d[i] = Math.max(d[i], d[i - 2] + ws[i - 1]);
            }
        }
        System.out.println(d[n]);
    }
}

