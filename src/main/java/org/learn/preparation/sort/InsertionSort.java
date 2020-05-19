package org.learn.preparation.sort;

import java.util.Arrays;

public class InsertionSort {

    /**
     * insert element at the correct position
     *
     * @param nums
     */
    public static void sort(int[] nums) {

        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];
            int j = i - 1;

            // 1 2 3 6 8 5
            while (j >= 0 && nums[j] > curr) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = curr;
            System.out.println("iteration: " + Arrays.toString(nums));
        }

    }

    public static void main(String[] args) {
        sort(new int[]{23, 56, 12, 33, 67, 24, 11});
    }
}
