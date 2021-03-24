package org.learn.preparation.leetcode;

import java.util.Arrays;

public class ThreeSumSmaller {

    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < nums.length && nums[i] <= target; i++) {
            int low = i + 1;
            int high = nums.length - 1; //[-2,0,1,3]
            while (low < high) {
                int sum = nums[i] + nums[low] + nums[high];
                if (sum <= target) {
                    count++;
                    low++;
                } else {
                    break;
                }
            }
        }
        return count;
    }
}
