package com.example;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

class RabinKarpTest {

    // step1 tests

    @Test
    void centermatch() {
        SubstringSearchStrategy rabinKarp = new RabinKarp();
        assertTrue(rabinKarp.search("hello", "ll"));
    }

    @Test
    void nomatch1() {
        SubstringSearchStrategy rabinKarp = new RabinKarp();
        assertFalse(rabinKarp.search("hello", "world"));
    }

    @Test
    void nomatch2() {
        SubstringSearchStrategy rabinKarp = new RabinKarp();
        assertFalse(rabinKarp.search("abcabc", "cb"));
    }

    @Test
    void dividedstrmatch1() {
        SubstringSearchStrategy rabinKarp = new RabinKarp();
        assertTrue(rabinKarp.search("hello world", "lo wo"));
    }

    @Test
    void dividedstrmatch2() {
        SubstringSearchStrategy rabinKarp = new RabinKarp();
        assertFalse(rabinKarp.search("this is a test", "is test"));
    }

    @Test
    void dividedstrnomatch() {
        SubstringSearchStrategy rabinKarp = new RabinKarp();
        assertFalse(rabinKarp.search("programming is fun", "fun is"));
    }

    @Test
    void reversdividedstrnomatch() {
        SubstringSearchStrategy rabinKarp = new RabinKarp();
        assertFalse(rabinKarp.search("hello world", "world hello"));
    }

    @Test
    void dividedstrmatch3() {
        SubstringSearchStrategy rabinKarp = new RabinKarp();
        assertTrue(rabinKarp.search("programming is fun", "ming is fu"));
    }

    // Prefix function tests

    @Test
    void arrmatch1() {
        RabinKarp rabinKarp = new RabinKarp();
        assertEquals(rabinKarp.PrefixFunction("hello", "ll"), new ArrayList<>(Arrays.asList(2)));
    }

    @Test
    void arrnomatch1() {
        RabinKarp rabinKarp = new RabinKarp();
        assertEquals(rabinKarp.PrefixFunction("hello", "world"), new ArrayList<>());
    }

    @Test
    void arrmatch2() {
        RabinKarp rabinKarp = new RabinKarp();
        assertEquals(rabinKarp.PrefixFunction("abcabca", "ca"), new ArrayList<>(Arrays.asList(2, 5)));
    }

    @Test
    void arrnomatch2() {
        RabinKarp rabinKarp = new RabinKarp();
        assertEquals(rabinKarp.PrefixFunction("abcabc", "cb"), new ArrayList<>());
    }

    // comparetext tests

    @Test
    void indexmatch1() {
        RabinKarp rabinKarp = new RabinKarp();
        assertTrue(rabinKarp.CompareText("hello", 2, "ll"));
    }

    @Test
    void indexnomatch1() {
        RabinKarp rabinKarp = new RabinKarp();
        assertFalse(rabinKarp.CompareText("hello", 2, "wo"));
    }

    @Test
    void indexnomatch2() {
        RabinKarp rabinKarp = new RabinKarp();
        assertFalse(rabinKarp.CompareText("hello", 4, "ro"));
    }

    @Test
    void indexmatch2() {
        RabinKarp rabinKarp = new RabinKarp();
        assertTrue(rabinKarp.CompareText("abcabc", 0, "ab"));
    }
}
