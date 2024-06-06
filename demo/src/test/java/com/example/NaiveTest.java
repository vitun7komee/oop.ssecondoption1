package com.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class NaiveTest {

    // step1 tests

    @Test
    void centermatch() {
        SubstringSearchStrategy naive = new Naive();
        assertTrue(naive.search("hello", "ll"));
    }

    @Test
    void nomatch1() {
        SubstringSearchStrategy naive = new Naive();
        assertFalse(naive.search("hello", "world"));
    }

    @Test
    void nomatch2() {
        SubstringSearchStrategy naive = new Naive();
        assertFalse(naive.search("abcabc", "cb"));
    }

    @Test
    void dividedstrmatch1() {
        SubstringSearchStrategy naive = new Naive();
        assertTrue(naive.search("hello world", "lo wo"));
    }

    @Test
    void dividedstrmatch2() {
        SubstringSearchStrategy naive = new Naive();
        assertFalse(naive.search("this is a test", "is test"));
    }

    @Test
    void dividedstrnomatch() {
        SubstringSearchStrategy naive = new Naive();
        assertFalse(naive.search("programming is fun", "fun is"));
    }

    @Test
    void reversdividedstrnomatch() {
        SubstringSearchStrategy naive = new Naive();
        assertFalse(naive.search("hello world", "world hello"));
    }

    @Test
    void dividedstrmatch3() {
        SubstringSearchStrategy naive = new Naive();
        assertTrue(naive.search("programming is fun", "ming is fu"));
    }

    // naivestringmatchertests

    @Test
    void strmatch1() {
        Naive naive = new Naive();
        assertEquals(naive.NaiveStringMatcher("hello", "ll"), 2);
    }

    @Test
    void strnomatch1() {
        Naive naive = new Naive();
        assertEquals(naive.NaiveStringMatcher("hello", "world"), -1);
    }

    @Test
    void strmatch2() {
        Naive naive = new Naive();
        assertEquals(naive.NaiveStringMatcher("abcabc", "ca"), 2);
    }

    @Test
    void strnomatch2() {
        Naive naive = new Naive();
        assertEquals(naive.NaiveStringMatcher("abcabc", "cb"), -1);
    }
}
