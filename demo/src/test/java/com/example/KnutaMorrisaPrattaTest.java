package com.example;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

import org.junit.jupiter.api.Test;

class KnutaMorrisaPrattaTest {

    // step1 tests

    @Test
    void centermatch() {
        SubstringSearchStrategy kmp = new KnutaMorrisaPratta();
        assertTrue(kmp.search("hello", "ll"));
    }

    @Test
    void nomatch1() {
        SubstringSearchStrategy kmp = new KnutaMorrisaPratta();
        assertFalse(kmp.search("hello", "world"));
    }

    @Test
    void nomatch2() {
        SubstringSearchStrategy kmp = new KnutaMorrisaPratta();
        assertFalse(kmp.search("abcabc", "cb"));
    }

    @Test
    void dividedstrmatch1() {
        SubstringSearchStrategy kmp = new KnutaMorrisaPratta();
        assertTrue(kmp.search("hello world", "lo wo"));
    }

    @Test
    void dividedstrmatch2() {
        SubstringSearchStrategy kmp = new KnutaMorrisaPratta();
        assertFalse(kmp.search("this is a test", "is test"));
    }

    @Test
    void dividedstrnomatch() {
        SubstringSearchStrategy kmp = new KnutaMorrisaPratta();
        assertFalse(kmp.search("programming is fun", "fun is"));
    }

    @Test
    void reversdividedstrnomatch() {
        SubstringSearchStrategy kmp = new KnutaMorrisaPratta();
        assertFalse(kmp.search("hello world", "world hello"));
    }

    @Test
    void dividedstrmatch3() {
        SubstringSearchStrategy kmp = new KnutaMorrisaPratta();
        assertTrue(kmp.search("programming is fun", "ming is fu"));
    }

    // Prefix function tests

    @Test
    void arrmatch1() {
        KnutaMorrisaPratta kmp = new KnutaMorrisaPratta();
        assertEquals(new ArrayList<>(Arrays.asList(2)), kmp.PrefixFunction("hello", "ll"));
    }

    @Test
    void arrnomatch1() {
        KnutaMorrisaPratta kmp = new KnutaMorrisaPratta();
        assertEquals(new ArrayList<>(), kmp.PrefixFunction("hello", "world"));
    }

    @Test
    void arrmatch2() {
        KnutaMorrisaPratta kmp = new KnutaMorrisaPratta();
        assertEquals(new ArrayList<>(Arrays.asList(2, 5)), kmp.PrefixFunction("abcabca", "ca"));
    }

    @Test
    void arrnomatch2() {
        KnutaMorrisaPratta kmp = new KnutaMorrisaPratta();
        assertEquals(new ArrayList<>(), kmp.PrefixFunction("abcabc", "cb"));
    }

    // Find borders tests

    @Test
    void simplecase() {
        KnutaMorrisaPratta kmp = new KnutaMorrisaPratta();
        assertEquals(createLinkedList(0, 0, 1, 2, 0, 1, 2), kmp.FindBorders("ababcab"));
    }

    @Test
    void norepcase() {
        KnutaMorrisaPratta kmp = new KnutaMorrisaPratta();
        assertEquals(createLinkedList(0, 0, 0, 0, 0, 0), kmp.FindBorders("abcdef"));
    }

    @Test
    void singlecharcase() {
        KnutaMorrisaPratta kmp = new KnutaMorrisaPratta();
        assertEquals(createLinkedList(0), kmp.FindBorders("a"));
    }

    @Test
    void allsamecase() {
        KnutaMorrisaPratta kmp = new KnutaMorrisaPratta();
        assertEquals(createLinkedList(0, 1, 2, 3, 4, 5), kmp.FindBorders("aaaaaa"));
    }

    @Test
    void emptycase() {
        KnutaMorrisaPratta kmp = new KnutaMorrisaPratta();
        assertEquals(createLinkedList(), kmp.FindBorders(""));
    }

    private LinkedList<Integer> createLinkedList(Integer... values) {
        return new LinkedList<>(Arrays.asList(values));
    }
}
