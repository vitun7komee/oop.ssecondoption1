package com.example;

public abstract class Template {
    private SubstringSearchStrategy strategy;

    public Template(SubstringSearchStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean isSubstring(String string, String substring) {
        if (string == null || substring == null)
            return false;
        if (string.isEmpty() || substring.isEmpty())
            return false;
        if (substring.length() > string.length())
            return false;
        return strategy.search(string, substring);
    }
}
