package org.learn.preparation.leetcode;

import java.util.HashMap;
import java.util.Map;

public class GreaterNumber {


    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            int curr = nums2[i];
            boolean found = false;
            for (int j = i + 1; j < nums2.length; j++) {
                if (curr < nums2[j]) {
                    found = true;
                    map.put(curr, nums2[j]);
                    break;
                }
            }
            if (!found) {
                map.put(curr, -1);
            }
        }
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = map.get(nums1[i]);
        }
        return nums1;
    }


}
