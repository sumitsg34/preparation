package org.learn.preparation.leetcode;

import java.util.Arrays;

public class FirstUniqueChar {


    public int firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        String sorted = new String(chars);
        for (int i = 0; i < sorted.length()-1; i++) {
            if(sorted.charAt(i) != sorted.charAt(i+1)){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        FirstUniqueChar firstUniqueChar = new FirstUniqueChar();
        System.out.println("out:" + firstUniqueChar.firstUniqChar("loveleetcode"));
    }
}
