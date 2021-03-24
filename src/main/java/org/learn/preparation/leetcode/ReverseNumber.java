package org.learn.preparation.leetcode;

public class ReverseNumber {

    public static int reverse(int x) {
        int rev = 0;
        int max = Integer.MAX_VALUE / 10;
        int min = Integer.MIN_VALUE / 10;
        while (x != 0) {
            int temp = x % 10;
            x /= 10;

            //positive
            if (rev > max || (rev == max && temp > 7))
                return 0;
            //negative
            if (rev < min || (rev == -min && temp < -8))
                return 0;

            rev = rev * 10 + temp;

        }
        return rev;
    }


    public static void main(String[] args) {
        //int x = 9646324351;
        System.out.println("out:" + reverse(1534236469));
    }

}
