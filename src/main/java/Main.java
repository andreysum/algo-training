import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

class Main {
    public static void main(String[] args) {
        final Main main = new Main();
        main.generate();
        main.run();
    }

    void generate() {

    }

    void run() {
        //        Scanner s = new Scanner(System.in);
        Scanner s = null;
        try {
            s = new Scanner(new FileInputStream("input.txt"));
        } catch (IOException e) {

        }
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
