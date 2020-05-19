package org.learn.preparation.sort;

import java.util.Arrays;

public class SelectionSort {

    // find minimum no and move it to front

    public static void sort(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            int min = nums[i];
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (nums[j] < min) {
                    min = nums[j];
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                int temp = nums[i];
                nums[i] = nums[minIndex];
                nums[minIndex] = temp;
            }

            System.out.println("iteration: " + Arrays.toString(nums));
        }
    }

    public static void main(String[] args) {
        sort(new int[]{23, 56, 12, 33, 67, 24, 11});
    }


}
