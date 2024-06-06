package com.example;

import java.util.LinkedList;

public class KnutaMorrisaPratta implements SubstringSearchStrategy {

    @Override
    public boolean search(String string, String substring) {
        LinkedList<Integer> prefixResult = PrefixFunction(string, substring);
        return !prefixResult.isEmpty();
    }

    public LinkedList<Integer> PrefixFunction(String string, String substring) {
        LinkedList<Integer> borders = FindBorders(substring);
        LinkedList<Integer> result = new LinkedList<>();
        int compareIndex = 0;
        for (int i = 0; i < string.length(); i++) {
            while (compareIndex > 0 && string.charAt(i) != substring.charAt(compareIndex))
                compareIndex = borders.get(compareIndex - 1);

            if (string.charAt(i) == substring.charAt(compareIndex))
                compareIndex++;

            if (compareIndex == substring.length()) {
                result.addLast(i - compareIndex + 1);
                compareIndex = borders.get(substring.length() - 1);
            }
        }
        return result;
    }

    public LinkedList<Integer> FindBorders(String string) {
        LinkedList<Integer> borders = new LinkedList<>();
        for (int i = 0; i < string.length(); i++) {
            borders.add(0);
        }
        int border = 0;
        for (int i = 1; i < string.length(); i++) {
            while (border > 0 && string.charAt(i) != string.charAt(border))
                border = borders.get(border - 1);

            if (string.charAt(i) == string.charAt(border))
                border++;

            borders.set(i, border);
        }
        return borders;
    }
}
