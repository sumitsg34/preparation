package org.learn.preparation.leetcode;

public class CoinChange2 {
    int[] solutions;
    int[] coins;
    int amount;
    int count = 0;

    public int coinChange(int[] coins, int amount) {
        this.coins = coins;
        this.amount = amount;
        this.solutions = new int[amount];
        coinChange(amount);
        return count;
    }

    private int coinChange(int currChange) {

        if (currChange < 0) {
            return -1;
        }

        if (currChange == 0) {
            count++;
            return 0;
        }

        if (solutions[currChange - 1] != 0) {
            if (solutions[currChange - 1] != -1)
                count++;
            return solutions[currChange - 1];
        }

        int min = Integer.MAX_VALUE;
        for (int i = coins.length - 1; i >= 0; i--) {
            int out = coinChange(currChange - coins[i]);
            if (out >= 0 && out < min) {
                min = out + 1;
            }
        }

        solutions[currChange - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return solutions[currChange - 1];
    }


    public static void main(String[] args) {
        CoinChange2 coinChange = new CoinChange2();
        long start = System.nanoTime();
        System.out.println("ans:" + coinChange.coinChange(new int[]{1, 2, 5}, 5));
        System.out.println("time:" + (System.nanoTime() - start));

    }


}
