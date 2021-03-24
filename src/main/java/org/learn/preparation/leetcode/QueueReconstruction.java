package org.learn.preparation.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class QueueReconstruction {

    public class QueueComparator implements Comparator<int[]> {
        @Override
        public int compare(int[] curr, int[] last) {
            return curr[0] - last[0];
        }

    }

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new QueueComparator());
        int n = people.length;

        List<int[]> res = new ArrayList<>(n);
        for(int[] p : people){
            res.add(p[1], p);
        }

        return res.toArray(new int[n][2]);
    }

    public static void main(String[] args) {
        int[][] people = {
                {7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}
        };
        QueueReconstruction queueReconstruction = new QueueReconstruction();
        System.out.println(Arrays.toString(queueReconstruction.reconstructQueue(people)));
    }


}
