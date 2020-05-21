package org.learn.preparation.leetcode;

public class NumberOf1 {

    public static int hammingWeight(int n) {

        return Integer.bitCount(n);
        //return counter;
    }

    public static void main(String[] args) {
        System.out.println("output: " + hammingWeight(00000000000000000000000000001011));
    }
}
