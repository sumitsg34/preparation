package org.learn.preparation.leetcode;

import java.util.HashSet;
import java.util.Set;

public class FirstPositiveMissingNumber {

    public static int firstMissingPositive(int[] nums) {

        if (nums.length == 1) {
            return 1;
        }

        Set<Integer> existingNum = new HashSet<>();
        int highest = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                existingNum.add(nums[i]);
                if (nums[i] > highest) {
                    highest = nums[i];
                }
            }
        }
        int i = 0;
        for (; i < highest; i++) {
            if (!existingNum.contains(i)) {
                return i;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 2};
        System.out.println(firstMissingPositive(nums));
    }
}
