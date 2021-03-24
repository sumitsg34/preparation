package org.learn.preparation.leetcode;

public class ArrangeCoins {

    public static int arrangeCoins(int n) {

        if (n < 2)
            return n;

        int l = 1;
        int h = n; // staircase

        while (l <= h) {

            int pivot = (l + h) / 2;
            // check how many coins are required at this pivot
            int coinsRequired = (pivot * (pivot + 1) / 2);

            // now if given coins are more than required coins
            // go to higher halve,
            System.out.println("l:" + l + " h:" + h + " p:" + pivot + " required:" + coinsRequired);
            if (coinsRequired == n)
                return pivot;

            if (coinsRequired < n)
                l = l + 1;
            else
                h = h - 1;

        }
        System.out.println("l:" + l + " h:" + h);
        return h;
    }

    public static void main(String[] args) {
        System.out.println("out:" + arrangeCoins(1804289383));
    }
}

