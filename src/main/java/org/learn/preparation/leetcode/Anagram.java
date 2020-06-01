package org.learn.preparation.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Anagram {

    public boolean areAnagram(int[] chars, String second) {
        int a = 'a';
        int[] seen = Arrays.copyOf(chars,chars.length);
        for (int i = 0; i < second.length(); i++) {
            int index = second.charAt(i) - a;
            if (seen[index] == 0) {
                return false;
            }
            seen[index] = seen[index] - 1;
        }
        return true;
    }

    public List<List<String>> groupAnagrams(String[] strs) {

        int[] found = new int[strs.length];
        List<List<String>> groups = new ArrayList<>();

        int i = 0;
        while (i < strs.length) {
            if (found[i] == 0) {
                String curr = strs[i];

                List<String> group = new ArrayList<>();
                group.add(curr);

                int[] chars = new int[26];
                for (int k = 0; k < curr.length(); k++) {
                    int index = curr.charAt(k) - 'a';
                    chars[index] = chars[index] + 1;
                }

                int j = i + 1;
                while (j < strs.length) {
                    if (found[j] == 0 && curr.length() == strs[j].length()) {
                        if (areAnagram(chars, strs[j])) {
                            group.add(strs[j]);
                            found[j] = 1;
                        }
                    }
                    j++;
                }
                groups.add(group);
            }
            i++;
        }
        return groups;
    }

    public static void main(String[] args) {
        Anagram anagram = new Anagram();
        anagram.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
    }
}
