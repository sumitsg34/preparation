package org.learn.preparation.leetcode;

import java.util.HashSet;
import java.util.Set;

/*
https://leetcode.com/problems/jewels-and-stones/
 */
public class NumJewelsInStones {

    public int numJewelsInStones(String J, String S) {
        Set<Character> stones = new HashSet<>();
        for (int i = 0; i < J.length(); i++) {
            stones.add(J.charAt(i));
        }
        int mine = 0;
        for (int i = 0; i < S.length(); i++) {
            if (stones.contains(S.charAt(i))) {
                mine++;
            }
        }
        return mine;
    }

    public int numJewelsInStones2(String J, String S) {
        char[] jewels = new char[58];
        for (int i = 0; i < J.length(); i++) {
            jewels[J.charAt(i) - 65] = 1;
        }
        int mine = 0;
        for (int i = 0; i < S.length(); i++) {
            if (jewels[S.charAt(i) - 65] == 1) {
                mine++;
            }
        }
        return mine;
    }

    public int numJewelsInStones3(String J, String S) {
        int res=0;
        for(char c : S.toCharArray()){
            if(J.indexOf(c) != -1){
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        NumJewelsInStones numJewelsInStones = new NumJewelsInStones();
        long s1 = System.nanoTime();
        //System.out.println("out: " + numJewelsInStones.numJewelsInStones2("aA", "aAAbbbb"));
        System.out.println("Time take: " + (System.nanoTime() - s1));

        long s2 = System.nanoTime();
        System.out.println("out: " + numJewelsInStones.numJewelsInStones3("aA", "aAAbbbb"));
        System.out.println("Time take: " + (System.nanoTime() - s2));
    }
}
