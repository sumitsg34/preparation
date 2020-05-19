package org.learn.preparation.leetcode;

public class NumberOf1 {

    public static int hammingWeight(int n) {
        int counter = 0;
        while (n > 0) {
            int lastDigit = n % 10;
            if (lastDigit == 1) {
                counter++;
            }
            n = n / 10;
        }
        //Integer.bitCount()
        return counter;
    }

    public static void main(String[] args) {
        System.out.println("output: " + hammingWeight(00000000000000000000000000001011));
    }
}
