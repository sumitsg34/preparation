package org.learn.preparation.leetcode;

public class PickARandomNoWithWeight {
    private int[] prefixSums;
    private int totalSum;

    public PickARandomNoWithWeight(int[] w) {
        this.prefixSums = new int[w.length];

        int prefixSum = 0;
        for (int i = 0; i < w.length; ++i) {
            prefixSum += w[i];
            this.prefixSums[i] = prefixSum;
        }
        this.totalSum = prefixSum;
    }

    public int pickIndex() {
        double target = this.totalSum * Math.random();
        int i = 0;
        // run a linear search to find the target zone
        for (; i < this.prefixSums.length; ++i) {
            if (target < this.prefixSums[i])
                return i;
        }
        // to have a return statement, though this should never happen.
        return i - 1;
    }

    public static void main(String[] args) {
        PickARandomNoWithWeight picker = new PickARandomNoWithWeight(new int[]{1, 2, 3});
        for (int i = 0; i < 6; i++)
            System.out.println(picker.pickIndex());
    }
}
