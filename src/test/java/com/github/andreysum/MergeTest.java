package com.github.andreysum;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class MergeTest {
    @Test
    public void testMergeSort() {
        // g
        int[] arr = new int[] { 5, 7, 5, 3, 8, 50 , 1, 4 };
        int s = 0;
        int e = 5;

        // w
        Merge.mergeSort(arr, s, e);

        // t
        assertArrayEquals(arr, new int[] { 3, 5, 5, 7, 8, 50, 1, 4 } );
    }
}