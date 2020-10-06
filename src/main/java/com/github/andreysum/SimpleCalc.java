package com.github.andreysum;

import java.util.Scanner;

class SimpleCalc {
    int[] d;

    public static void main(String[] args) {
        SimpleCalc m = new SimpleCalc();
        m.run();
    }

    void run() {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        d = new int[n + 1];
        Calc[] ops = new Calc[n + 1];
        for (int i = 1; i <= n; i++) {
            d[i] = i - 1;
            ops[i] = new Calc();
        }
        if (n > 1) {
            ops[2].prev = 1;
        }
        for (int i = 1; i <= n; i++) {
            int val1 = i + 1;
            int val2 = i * 2;
            int val3 = i * 3;
            if (val1 <= n && d[i] + 1 < d[val1]) {
                d[val1] = d[i] + 1;
                ops[val1].prev = i;
                ops[val1].val = ops[i].val + 1;
            }
            if (val2 <= n && d[i] + 1 < d[val2]) {
                d[val2] = d[i] + 1;
                ops[val2].prev = i;
                ops[val2].val = ops[i].val * 2;
            }
            if (val3 <= n && d[i] + 1 < d[val3]) {
                d[val3] = d[i] + 1;
                ops[val3].prev = i;
                ops[val3].val = ops[i].val * 3;
            }
        }
        System.out.println(d[n]);
        int[] res = new int[d[n] + 1];
        int k = n;
        int i = d[n];
        while (k > 0) {
            res[i--] = k;
            k = ops[k].prev;
        }
        for (int b = 0; b <= d[n]; b++) {
            System.out.print(res[b] + " ");
        }
    }

    private static class Calc {
        int prev = -1;
        int val = 0;
    }
}

