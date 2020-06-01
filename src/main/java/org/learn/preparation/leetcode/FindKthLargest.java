package org.learn.preparation.leetcode;

import java.util.LinkedHashMap;
import java.util.PriorityQueue;

public class FindKthLargest {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int i = 0;
        while (i < k) {
            queue.add(nums[i]);
            i++;
        }
        while (i < nums.length) {
            if (queue.peek() < nums[i]) {
                queue.poll();
                queue.add(nums[i]);
            }
            i++;
        }
        return queue.poll();
    }

    public static void main(String[] args) {

        FindKthLargest findKthLargest = new FindKthLargest();
        System.out.println("out: " + findKthLargest.findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
    }
}
