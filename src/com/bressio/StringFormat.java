package com.bressio;

import java.util.Collections;

public final class StringFormat {

    private StringFormat() {}

    public static boolean isValid(String str, String pattern) {
        return str.matches(pattern);
    }

    public static char getChar(String str) {
        return str.charAt(0);
    }

    public static int getInt(String str) {
        return Integer.parseInt(str.substring(2));
    }

    public static String repeat(String str, int n) {
        return String.join("", Collections.nCopies(n, str));
    }

    public static int countUniqueCharacters(String input) {
        return (int) input.chars()
                .distinct()
                .count();
    }
}
