package com.github.andreysum;

import org.junit.Test;

import static org.junit.Assert.*;

public class SubstringSearchTest {
    @Test
    public void noSubstring() {
        // given
        char[] t = new char[] {'a', 'n', 'd', 'r', 'e', 'w'};
        char[] s = new char[] {'e', 'r', 'r'};

        // when
        int res = SubstringSearch.find(t, s);

        // then
        assertEquals(-1, res);
    }

    @Test
    public void emptyString() {
        // given
        char[] t = new char[] {'a', 'n', 'd', 'r', 'e', 'w'};
        char[] s = new char[] {'e', 'r', 'r'};

        // when
        int res = SubstringSearch.find(t, s);

        // then
        assertEquals(-1, res);
    }
}