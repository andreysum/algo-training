package com.github.andreysum;

import org.junit.Test;

import static org.junit.Assert.*;

public class MaxSubarraySearchTest {
    @Test
    public void shouldFindOnlyDigit() {
        int[] t = new int[]{-2000};
        MaxSubarraySearch.Result res = MaxSubarraySearch.findMaxSubarraySearch(t, 0, 0);
        checkResult(res, 0, 0, -2000);
    }

    @Test
    public void shouldFindTwoArray() {
        int[] t = new int[]{-2000, 2000};
        MaxSubarraySearch.Result res = MaxSubarraySearch.findMaxSubarraySearch(t, 0, 1);
        checkResult(res, 1, 1, 2000);
    }

    @Test
    public void shouldFindSubArray1() {
        int[] t = new int[]{-20, 7, 50, 40, -20, -30, 100, 20, -3};
        MaxSubarraySearch.Result res = MaxSubarraySearch.findMaxSubarraySearch(t, 0, 8);
        checkResult(res, 1, 7, 167);
    }

    @Test
    public void shouldFindSubArray2() {
        int[] t = new int[]{-2, -5, 6, -2, -3, 1, 5, -6};
        MaxSubarraySearch.Result res = MaxSubarraySearch.findMaxSubarraySearch(t, 0, 7);
        checkResult(res, 2, 6, 7);
    }

    @Test
    public void shouldFindSubArray3() {
        int[] t = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        MaxSubarraySearch.Result res = MaxSubarraySearch.findMaxSubarraySearch(t, 0, 7);
        checkResult(res, 3, 6, 6);
    }

    private void checkResult(MaxSubarraySearch.Result res, final int f, final int l, final int sum) {
        assertEquals("Неверный левый индекс:" + res + ". Ожидается: " + f, f, res.first);
        assertEquals("Неверный правый индекс: " + res + ". Ожидается: " + l, l, res.last);
        assertEquals("Неверная сумма: " + res + ". Ожидается: " + sum, sum, res.sum);
    }
}