package org.learn.preparation.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/two-sum/
 */
public class TwoSum {

     /**
     * n*n solution
     * for i=0; i<length; i++
     *   for j=i+1; j<length; j++
     *     // if [i]+[j] == target
     *          breaks both loop and return these indices
     *
     * Runtime: 18 ms, faster than 35.65% of Java online submissions for Two Sum.
     * Memory Usage: 37.3 MB, less than 98.95% of Java online submissions for Two Sum.
     *
     *
     */
    public int[] twoSum_v1(int[] nums, int target) {
        int firstIndex=0,secondIndex=0;
        boolean found =false;
        for(int i=0; i<nums.length;i++){
            for(int j=i+1; j<nums.length;j++){
                if(nums[i] + nums[j] == target){
                    firstIndex=i;
                    secondIndex=j;
                    found=true;
                    break;
                }
            }
            if(found){
                break;
            }
        }
        return new int[]{firstIndex,secondIndex};
    }

    /**
     * Given nums = [2, 7, 11, 15], target = 9,
     * Given nums = [2, 3, 7, 11, 15], target = 14
     *
     * Runtime: 2 ms, faster than 98.86% of Java online submissions for Two Sum.
     * Memory Usage: 37.2 MB, less than 98.95% of Java online submissions for Two Sum.
     */
    public int[] twoSum_v2(int[] nums, int target) {

        /**
         * n*n solution
         * seen number: {}
         * for each no: check if target-currentNumer is seen
         *   if seen, go back and find that no. position
         *
         * Success #stdin #stdout 0.1s 36004KB
         *                 0.1s 36008KB
         *
         *                 3 2 4 =6
         */
        int secondIndex=0;
        int otherNumber=0;
        HashMap<Integer,Integer> seenNumbers = new HashMap<>();
        for(int i=0; i<nums.length;i++){
            otherNumber = target - nums[i];
            if(seenNumbers.get(otherNumber)!=null){
                secondIndex=i;
                break;
            }else{
                seenNumbers.put(nums[i], i);
            }
        }
        return new int[]{seenNumbers.get(otherNumber),secondIndex};
    }


    public static void main(String[] args) {
        int[] nums = {3,2,4};
        int[] out= new TwoSum().twoSum_v2(nums, 6);
        System.out.println("Output: "+ Arrays.toString(out));
    }

}
