package org.learn.preparation.leetcode;

/**
 * https://leetcode.com/problems/find-numbers-with-even-number-of-digits/
 */
public class NumbersWithEventDigits {

    public int findNumbers(int[] nums) {

        if (nums == null || nums.length == 0)
            return 0;

        int numsWithEventDigits = 0;
        for (int i = 0; i < nums.length; i++) {
            int number = nums[i];
            int digits = 0;
            while (number > 0) {
                number = number / 10; // 0/10 34
                digits++;
            }
            if (digits % 2 == 0) {
                numsWithEventDigits++;
            }
        }

        return numsWithEventDigits;

    }

    public static void main(String[] args) {
        int[] nums = {12,345,2,6,7896,100001};
        System.out.println("Answer: " + new NumbersWithEventDigits().findNumbers(nums));

    }
}
