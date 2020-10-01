import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.*;

class Main {
    int[][] d;
    public static void main(String[] args) {
        Main m = new Main();
        m.run();
    }

    void run() {
        Scanner s = null;
        try {
            s = new Scanner(new File("input.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
//        Scanner s = new Scanner(System.in);
        int w = s.nextInt();
        int n = s.nextInt();
        int[] ws = new int[n];
        for (int i = 0; i < n; i++) {
            ws[i] = s.nextInt();
        }
        d = new int[w+1][n+1];
        for (int i = 0; i <= w; i++) {
            d[i][0] = 0;
        }
        for (int i = 0; i <= n; i++) {
            d[0][i] = 0;
        }
        for (int i = 1; i <= w; i++) {
            for (int j = 1; j <= n; j++) {
                d[i][j] = d[i][j-1];
                int wj = ws[j-1];
                if (wj <= i) {
                    d[i][j] = Math.max(d[i-wj][j-1] + wj, d[i][j]);
                }
            }
        }
        System.out.println(d[w][n]);
    }

    void print(int w, int n) {
        for (int i = 0; i <= w; i++) {
            for (int j = 0; j <= n; j++) {
                System.out.print(d[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
