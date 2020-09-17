package com.github.andreysum;

import java.util.Scanner;

class EditDistance {
    char[] a;
    char[] b;
    int[][] d;

    public static void main(String[] args) {
        EditDistance m = new EditDistance();
        m.run();
    }

    void run() {
        Scanner s = new Scanner(System.in);
        String as = s.next();
        String bs = s.next();
        a = as.toCharArray();
        b = bs.toCharArray();
        d = new int[a.length + 1][b.length + 1];
        for (int i = 0; i <= a.length; i++) {
            d[i][0] = i;
        }
        for (int j = 0; j <= b.length; j++) {
            d[0][j] = j;
        }
        for (int i = 1; i <= a.length; i++) {
            for (int j = 1; j <= b.length; j++) {
                int sub = diff(a[i - 1], b[j - 1]);
                d[i][j] = Math.min(d[i][j - 1] + 1, Math.min(d[i - 1][j] + 1, d[i - 1][j - 1] + sub));
            }
        }
        System.out.println(d[a.length][b.length]);
    }

    int diff(int af, int bf) {
        return af == bf ? 0 : 1;
    }
}
