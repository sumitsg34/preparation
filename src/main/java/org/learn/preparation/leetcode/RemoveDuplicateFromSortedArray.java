package org.learn.preparation.leetcode;

import java.io.Serializable;
import java.nio.file.Files;
import java.util.Arrays;

public class RemoveDuplicateFromSortedArray implements Serializable {

    // [0,1,1,1,2]
    // [0,1,2,1,2
    private static void shiftArrayElementsByOnePosition(int[] nums, int start, int shift) {
        for (int i = start; i < nums.length - shift; i++) {
            nums[i] = nums[i + shift];
        }
    }

    // [1,2,2]
    public static int removeDuplicates(int[] nums) {

        int uniqueNo = 0;
        if(nums.length>=2)
            uniqueNo++;

        int length = nums.length - 1;

        for (int i = 0; i < length; i++) {
            // check if current num == next num
            // A B
            int shift = 0;
            int tmp = i;
            while (tmp<nums.length-1 && nums[tmp] == nums[tmp + 1]) {
                shift++;
                tmp++;
            }
            if (shift > 0)
                shiftArrayElementsByOnePosition(nums, i, shift);
            uniqueNo++;
            length -= shift;
            System.out.println(Arrays.toString(nums));
        }

        return uniqueNo;
    }

    public static void main(String[] args) {
        //int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        //int[] nums = {0, 0};
        int[] nums = {1,2};
        System.out.println(Arrays.toString(nums));

        System.out.println("unique no:" + removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));

    }
}
