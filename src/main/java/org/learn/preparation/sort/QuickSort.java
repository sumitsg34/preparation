package org.learn.preparation.sort;

import java.util.Arrays;

public class QuickSort {

    public static void sort(int[] nums, int low, int high) {
        if (low < high) {
            int p = partition(nums, low, high);
            sort(nums, low, p - 1);
            sort(nums, p + 1, high);
        }
    }

    private static int partition(int[] nums, int low, int high) {
        int pivot = nums[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (nums[j] <= pivot) {
                i++;
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
            }
        }
        nums[high] = nums[i + 1];
        nums[i + 1] = pivot;
        System.out.println("Array for low: " + low + " high: " + high + " " + Arrays.toString(nums));
        System.out.println("returning pivot as " + (i + 1));
        return i + 1;
    }

    public static void main(String[] args) {
        sort(new int[]{23, 56, 12, 33, 67, 24, 11}, 0, 6);
    }

}
