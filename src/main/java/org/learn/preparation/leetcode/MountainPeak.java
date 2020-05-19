package org.learn.preparation.leetcode;

/**
 * https://leetcode.com/problems/peak-index-in-a-mountain-array/
 */
public class MountainPeak {

    public int peakIndexInMountainArray(int[] A) {
        //[0,2,3,1,0]
        //[0 2 1 0]
        //[0,2,1,2,3]
        // 0 1 0
        int pointer = 0;
        while (pointer < A.length && A[pointer] < A[pointer + 1])
            pointer++;
        return pointer;
    }


    public static void main(String[] args) {
        int[] nums = {0, 2, 1, 0};
        System.out.println("MountainPeak: " + new MountainPeak().peakIndexInMountainArray(nums));

        int[] nums1 = {0, 2, 3, 1, 0};
        System.out.println("MountainPeak: " + new MountainPeak().peakIndexInMountainArray(nums1));

        int[] nums2 = {0, 1, 0};
        System.out.println("MountainPeak: " + new MountainPeak().peakIndexInMountainArray(nums2));

        int[] nums3 = {0, 3, 2, 1, 0};
        System.out.println("MountainPeak: " + new MountainPeak().peakIndexInMountainArray(nums3));
    }
}
