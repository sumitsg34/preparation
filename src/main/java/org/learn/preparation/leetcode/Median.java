package org.learn.preparation.leetcode;

public class Median {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int len1 = nums1.length;
        int len2 = nums2.length;

        // {1,2,3,4,5} : 5/2=2
        int finalLen = ((len1 + len2) / 2) + 1;
        int[] temp = new int[finalLen];

        int first = 0;
        int second = 0;

        int i = 0;
        while (i < finalLen && first < len1 && second < len2) {
            if (nums1[first] < nums2[second]) {
                temp[i] = nums1[first++];
            } else {
                temp[i] = nums2[second++];
            }
            i++;
        }

        while (i < finalLen && first < len1) {
            temp[i] = nums1[first++];
            i++;
        }
        while (i < finalLen && second < len2) {
            temp[i] = nums2[second++];
            i++;
        }
        // now check if odd or even
        if ((len1 + len2) % 2 == 0) {
            // {1,2,3,4,5,6} 6/2=3
            return ((double) temp[finalLen - 2] + temp[finalLen - 1]) / 2;
        } else {
            return temp[finalLen - 1];
        }

    }

    public static void main(String[] args) {
        int[] num1 = new int[]{1, 2};
        int[] num2 = new int[]{3};
        Median median = new Median();
        System.out.println("out:" + median.findMedianSortedArrays(num1, num2));
    }
}
