package org.learn.preparation.leetcode;

import java.util.Arrays;

public class SortColors {
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void sortColors(int[] nums) {

        int low = 0; // this should point to the end of 0's

        int high = nums.length - 1; // this should point to the start of 2's
        int mid = 0;  // this will iterate from low to high

        while (mid <= high) {
            if(nums[mid] == 0) {
                // as low points to the end of 0's, lets swap mid and low
                // System.out.println("m points to 0: low:" + low + " mid:"+ mid);
                swap(nums, low,mid);
                low++;
                mid++;
                // System.out.println(Arrays.toString(nums));
            }

            if(mid<=high && nums[mid] == 1){
                // System.out.println("m points to 1:  mid"+ mid);
                mid++;}

            if(mid < high && nums[mid] == 2 ) {
                // as low points to the end of 0's, lets swap mid and low
                // System.out.println("m points to 2: high:" + high + " mid:"+ mid);
                swap(nums, mid,high);
                high--;
                //System.out.println(Arrays.toString(nums));
            }
        }

    }

    public static void main(String[] args) {
        SortColors sortColors = new SortColors();
        int[] out = new int[]{0,0};
        sortColors.sortColors(out);
        System.out.println(Arrays.toString(out));
    }
}
