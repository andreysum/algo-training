package com.github.andreysum;

public class Merge {
    static void mergeSort(int[] arr, int p, int r) {
        if (p < r) {
            int q = (int) Math.floor((p + r) / 2);
            mergeSort(arr, p, q);
            mergeSort(arr, q + 1, r);
            merge(arr, p, q, r);
        }
    }

    static void merge(int[] arr, int p, int q, int r) {
        int n1 = q - p + 1;
        int n2 = r - q;
        int[] lArr = new int[n1 + 1];
        int[] rArr = new int[n2 + 1];
        for (int i = 0; i < n1; i++) {
            lArr[i] = arr[p + i];
        }
        for (int j = 0; j < n2; j++) {
            rArr[j] = arr[q + j + 1];
        }
        lArr[n1] = Integer.MAX_VALUE;
        rArr[n2] = Integer.MAX_VALUE;
        int i = 0;
        int j = 0;
        for (int k = p; k < r; k++) {
            if (lArr[i] <= rArr[j]) {
                arr[k] = lArr[i];
                i++;
            } else {
                arr[k] = rArr[j];
                j++;
            }
        }
    }
}
