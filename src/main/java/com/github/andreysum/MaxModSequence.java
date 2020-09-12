package com.github.andreysum;

import java.util.Scanner;

class MaxModSequence {
    public static void main(String[] args) {
        final MaxModSequence main = new MaxModSequence();
        main.run();
    }

    void run() {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = s.nextInt();
        }
        s.close();
        int[] d = new int[n];
        for (int i = 0; i < n; i++) {
            d[i] = 1;
            for (int j = 0; j < i; j++) {
                if (a[i] % a[j] == 0 && d[j] + 1 > d[i]) {
                    d[i] = d[j] + 1;
                }
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (d[i] > max) {
                max = d[i];
            }
        }
        System.out.println(max);
    }
}
