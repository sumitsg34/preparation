package org.learn.preparation.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        boolean[] merged = new boolean[intervals.length];

        List<int[]> out = new ArrayList<>();
        //{1, 3}, {2, 6}, {8, 10}, {15, 18}
        for (int i = 0; i < intervals.length; i++) {
            int[] temp = intervals[i];
            if (!merged[i]) {
                for (int j = i + 1; j < intervals.length; j++) {
                    if (merged[j])
                        continue;
                    if (temp[0] <= intervals[j][0] && temp[1] >= intervals[j][0]) {
                        temp[1] = intervals[j][1];
                        merged[j] = true;
                    }
                }
                merged[i] = true;
                out.add(temp);
            }
        }

        return out.toArray(new int[out.size()][2]);
    }

    public static void main(String[] args) {
        int[][] in = {
                {1, 3}, {2, 6}, {8, 10}, {15, 18}
        };
        MergeIntervals mergeIntervals = new MergeIntervals();
        System.out.println("out: " + Arrays.toString(mergeIntervals.merge(in)));

    }

}
