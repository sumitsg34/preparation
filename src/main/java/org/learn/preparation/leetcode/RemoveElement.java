package org.learn.preparation.leetcode;

import java.util.Arrays;

//https://leetcode.com/problems/remove-element/submissions/
public class RemoveElement {

    public static int removeElement(int[] nums, int val) {

        //[0,1,2,2,3,0,4,2]
        int i = 0;
        int j = nums.length - 1;

        if (j == 0 && nums[0] == val) {
            return j;
        }

        while (i < j) {
            if (nums[i] == val) {
                //find correct j
                while (nums[j] == val && j >= 0) {
                    j--;
                }
                //swap
                nums[i] = nums[j];
                j--;
            }
            i++;
        }
        return j + 1;
    }

    public static void main(String[] args) {
        int[] nums = {1};

        System.out.println("result: " + removeElement(nums, 1));
        System.out.println(Arrays.toString(nums));

    }


}
