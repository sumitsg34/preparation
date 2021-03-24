package org.learn.preparation;

public class StockPrice {

    // {5,7,2,4,6}
    public static int findMaxProfile(int[] prices) {

        if (prices == null || prices.length == 0)
            return 0;

        int lastMin = prices[0];
        int profit = 0;
        //boolean possible = true;
        // [7,1,5,3,6,4]
        for (int i = 1; i < prices.length; i++) {
            if (lastMin < prices[i]) {
                int temp = prices[i] - lastMin;
                if (temp > profit)
                    profit = temp;
            }

            if (lastMin > prices[i])
                lastMin = prices[i];
        }


        if (profit <= 0)
            return 0;
        else
            return profit;

    }

    public static void main(String[] args) {
        System.out.println(findMaxProfile(new int[]{7, 1, 5, 3, 6, 4}));
    }
}
