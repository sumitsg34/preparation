package org.learn.preparation.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> triplets = new ArrayList<>(); // -4 -1 -1 0 1 2     [-1,-1,2],[-1,0,1]
        for (int i = 0; i < nums.length && nums[i] <= 0; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                int low = i + 1;                 // 2
                int high = nums.length - 1;      // 5
                while (low < high) {
                    int sum = nums[i] + nums[low] + nums[high];
                    if (sum < 0 || (low > (i + 1) && nums[low] == nums[low - 1])) {
                        low++;
                    } else if (sum > 0 || (high < nums.length - 1 && nums[high] == nums[high + 1])) {
                        high--;
                    } else {
                        List<Integer> triplet = new ArrayList<>();
                        triplet.add(nums[i]);
                        triplet.add(nums[low]);
                        triplet.add(nums[high]);
                        triplets.add(triplet);
                        low++;
                        high--;
                    }
                }
            }
        }
        return triplets;
    }

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        System.out.println(threeSum.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }
}
