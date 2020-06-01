package org.learn.preparation.interviewbit;

import java.util.Arrays;
import java.util.List;

public class MaxSumContiguousSubarray {

    public int maxSubArray(final List<Integer> a) {
        int maxSum = Integer.MIN_VALUE;
        int max = 0;
        int start = 0;
        int end = 0;
        for (int i = 0; i < a.size(); i++) {
            max = max + a.get(i);
            if (max < a.get(i)) {
                max = a.get(i);
                start = i;
            }
            if (maxSum < max) {
                end = i;
                maxSum = max;
            }
        }
        System.out.println("Start: " + start + " end: " + end);
        return maxSum;
    }

    public static void main(String[] args) {

        int result = 0;
        result = 31 * result + "fasdfads".hashCode();

        System.out.println("row: " + "fasdfads".hashCode());
        System.out.println("-->" + result);
        Integer[] nums = {-2, -3, 4, -1, -2, 1, 5, -3};
        //Integer[] nums = {1, 2, 3, 4};

        MaxSumContiguousSubarray maxSumContiguousSubarray = new MaxSumContiguousSubarray();
        System.out.println("sum: " + maxSumContiguousSubarray.maxSubArray(Arrays.asList(nums)));

    }
}
