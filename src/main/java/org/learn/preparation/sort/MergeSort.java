package org.learn.preparation.sort;

import java.util.Arrays;

public class MergeSort {


    public static void sort(int[] nums, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;  //
            sort(nums, low, mid);
            sort(nums, mid + 1, high);
            merge(nums, low, mid, high);
        }
    }

    private static void merge(int[] nums, int low, int mid, int high) {
        // we have two arrays which are sorted
        System.out.println("Merging from :" + low + " to :" + high);
        int n1 = mid - low + 1;
        int n2 = high - mid;


        int[] first = new int[n1];
        int[] second = new int[n2];

        for (int p = 0; p < n1; p++) {
            first[p] = nums[low + p];
        }

        for (int p = 0; p < n2; p++) {
            second[p] = nums[mid + p + 1];
        }

        int i = 0, j = 0;
        int k = low;
        while (i < n1 && j < n2) {
            if (first[i] <= second[j]) {
                nums[k] = first[i];
                i++;
            } else {
                nums[k] = second[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            nums[k] = first[i];
            i++;
            k++;
        }

        while (j < n2) {
            nums[k] = second[j];
            j++;
            k++;
        }

        System.out.println("arrays :" + Arrays.toString(nums));
    }

    public static void main(String[] args) {
        sort(new int[]{23, 56, 12, 33, 67, 24, 11}, 0, 6);
    }
}
