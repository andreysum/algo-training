package com.github.andreysum;

import org.junit.Test;

import java.util.Scanner;

/**
 * Created by andreysum @ 06.11.19
 */
public class MainTest {
    @Test
    public void main() {
        StringBuilder sb = new StringBuilder("0001");
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb.toString());
    }
}
