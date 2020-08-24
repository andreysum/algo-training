package com.github.andreysum;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

class CountingSort {
    static final int M = 11;
    public static void main(String[] args) {
        new CountingSort().run();
    }
    void run() {
        Scanner s = new Scanner(System.in);
        int count = s.nextInt();
        int[] in = new int[count];
        int[] f = new int[M];
        for (int i = 0; i < count; i++) {
            in[i] = s.nextInt();
            f[in[i]] = f[in[i]] + 1;
        }
        for (int i = 1; i < f.length; i++) {
            f[i] = f[i] + f[i - 1];
        }
        int[] r = new int[in.length];
        for (int i = in.length - 1; i >= 0; i--) {
            r[f[in[i]] - 1] = in[i];
            f[in[i]] = f[in[i]] - 1;
        }
        System.out.println(Arrays.stream(r).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
    }
}
