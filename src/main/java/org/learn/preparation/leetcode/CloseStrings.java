package org.learn.preparation.leetcode;

import java.util.HashSet;
import java.util.Set;

public class CloseStrings {

    public static boolean closeStrings(String word1, String word2) {

        if(word1 == null || word2 == null)
            return false;

        if(word1.length() != word2.length())
            return false;

        Set<Character> chars = new HashSet<>();

        for (char c : word1.toCharArray())
            chars.add(c);

        Set<Character> chars2 = new HashSet<>();
        for (char c : word2.toCharArray()) {
            if (!chars.contains(c)) {
                return false;
            }
            chars2.add(c);
        }
        return chars2.size() == chars.size() ? true : false;
    }

    public static void main(String[] args) {
        System.out.println(closeStrings("abc", "bca"));
    }


}
