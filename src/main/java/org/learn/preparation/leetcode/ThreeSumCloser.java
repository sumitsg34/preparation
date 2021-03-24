package org.learn.preparation.leetcode;

import java.util.Arrays;

public class ThreeSumCloser {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;       // 1 1 1 1    -100
        for (int i = 0; i < nums.length && diff != 0; i++) {
            int low = i + 1;
            int high = nums.length - 1;
            while (low < high) {
                int sum = nums[i] + nums[low] + nums[high];
                if (Math.abs(target - sum) < Math.abs(diff)) {
                    diff = target - sum;
                }
                if (sum < target) {
                    low++;
                } else {
                    high--;
                }
            }

        }
        return target - diff;
    }

    public static void main(String[] args) {
        ThreeSumCloser threeSum = new ThreeSumCloser();
        System.out.println(threeSum.threeSumClosest(new int[]{1, 1, 1, 1}, -100));
    }
}
