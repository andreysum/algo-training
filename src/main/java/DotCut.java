import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

class DotCut {

    public static final int BOUND = 500;
//    int deep;
    static String resStraight = "";
    static String resSmart = "";
    static int efforts = 1;

    public static void main(String[] args) {
        final DotCut main = new DotCut();
        while (Objects.equals(resStraight, resSmart)) {
            System.out.println("effort: " + efforts);
            main.generate();
            main.run();
            main.runStraight();
            System.out.flush();
            efforts++;
        }
        System.out.println("Bad with " +  efforts + " effort");
        System.out.println("straight: " + resStraight);
        System.out.println("smart: " + resSmart);
    }

    private void generate() {
        FileWriter fileOut = null;
        try {
            fileOut = new FileWriter("input.txt");
            fileOut.append(String.valueOf(BOUND)).append(" ").append(String.valueOf(BOUND)).append("\n");
            Random sr = new Random();
            Random er = new Random();
            Random dr = new Random();
            List<Integer[]> cs = new ArrayList<>();
            List<Integer> ds = new ArrayList<>();
            for (int i = 0; i < BOUND; i++) {
                //                int s = -25000;
                //                int e = 25000;
                //                cs.add(new Integer[]{ s, e });
                //                ds.add(0);
                int s = sr.nextInt(BOUND + 1);
                int e = s + er.nextInt(BOUND - s + 1);
                cs.add(new Integer[]{ s, e });
                ds.add(dr.nextInt(BOUND + 1));
            }
            fileOut.append(cs.stream().map(c -> c[0] + " " +c[1]).collect(Collectors.joining("\n")));
            fileOut.append("\n");
            fileOut.append(ds.stream().map(String::valueOf).collect(Collectors.joining(" ")));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileOut.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void runStraight() {
        Scanner s = null;
        try {
            s = new Scanner(new File("input.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int cutsCount = s.nextInt();
        int dotsCount = s.nextInt();
        int[][] cuts = new int[cutsCount][]; // starts
        for (int i = 0; i < cutsCount; i++) {
            int[] cut = new int[2];
            cuts[i] = cut;
            cut[0] = s.nextInt();
            cut[1] = s.nextInt();
        }
        int[] ds = new int[dotsCount]; // dots
        for (int i = 0; i < dotsCount; i++) {
            ds[i] = s.nextInt();
        }
        int[] counts = new int[ds.length];
        for (int i = 0; i < ds.length; i++) {
            int d = ds[i];
            for (int[] cut : cuts) {
                if (d <= cut[1] && d >= cut[0]) {
                    counts[i] = counts[i] + 1;
                }
            }
        }
        resStraight = Arrays.stream(counts).mapToObj(String::valueOf).collect(Collectors.joining(" "));
    }

    void run() {
        Scanner s = null;
        try {
            s = new Scanner(new File("input.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        long startTime = System.currentTimeMillis();
        int cutsCount = s.nextInt();
        int dotsCount = s.nextInt();
        int[] ss = new int[cutsCount]; // starts
        int[] es = new int[cutsCount]; // ends
        for (int i = 0; i < cutsCount; i++) {
            ss[i] = s.nextInt();
            es[i] = s.nextInt();
        }
        int[] ds = new int[dotsCount]; // dots
        for (int i = 0; i < dotsCount; i++) {
            ds[i] = s.nextInt();
        }
        int[] dso = new int[dotsCount];  // dots original
        System.arraycopy(ds, 0, dso, 0, dotsCount);
        System.out.println(Arrays.toString(ss));
        qs(ss, 0, ss.length - 1);
        System.out.println(Arrays.toString(ss));
        System.out.println(Arrays.toString(es));
        qs(es, 0, es.length - 1);
        System.out.println(Arrays.toString(es));
        System.out.println(Arrays.toString(ds));
        qs(ds, 0, ds.length - 1);
        System.out.println(Arrays.toString(ds));
        Map<Integer, Integer> cs = new HashMap<>(dotsCount); // counts
        int sc = 0; // start count
        int ec = 0; // end count
        int ld = Integer.MIN_VALUE;
        for (int d = 0, st = 0, e = 0; d < ds.length; d++) {
            if (ds[d] == ld) {
                continue;
            }
            ld = ds[d];
            while (st < ss.length && ss[st] <= ds[d]) {
                sc++;
                st++;
            }
            while (e < es.length && es[e] < ds[d]) {
                ec++;
                e++;
            }
            cs.put(ds[d], sc - ec);
            while (e < es.length && es[e] == ds[d]) {
                ec++;
                e++;
            }
        }
        resSmart = Arrays.stream(dso).map(cs::get).mapToObj(String::valueOf).collect(Collectors.joining(" "));
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
//        System.out.println(deep + " recursive calls");
    }

    void qs(int[] a, int l, int r) {
//        deep++;
        while (l < r) {
            int[] p = part(a, l, r);
            if (p[0] - 1 - l < r - p[1] + 1) {
                qs(a, l, p[0] - 1);
                l = p[1] + 1;
            } else {
                qs(a, p[1] + 1, r);
                r = p[0] - 1;
            }
        }
    }

    int[] part(int[] a, int l, int r) {
        int p = l + new Random().nextInt(r - l + 1);
//        System.out.println("pivot: " + p);
        swap(a, p, l);
        int j = l;
        int k = l;
        int x = a[l];
        for (int i = l + 1; i <= r; i++) {
            if (a[i] < x) {
                swap(a, i, ++j);
                swap(a, j, ++k);
            } else if (a[i] == x) {
                swap(a, i, ++j);
            }
        }
        swap(a, l, k);
        return new int[]{ k, j };
    }

    void swap(int[] a, int s, int t) {
        int sv = a[s];
        a[s] = a[t];
        a[t] = sv;
    }
}
