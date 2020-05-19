package org.learn.preparation.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KidWithHighestCandies {


    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxCandies = 0;
        for (int i = 0; i < candies.length; i++) {
            if (maxCandies < candies[i]) {
                maxCandies = candies[i];
            }
        }
        List<Boolean> hasHighestCandies = new ArrayList<>();
        for (int i = 0; i < candies.length; i++) {
            if (candies[i] + extraCandies >= maxCandies) {
                hasHighestCandies.add(true);
            } else {
                hasHighestCandies.add(false);
            }
        }
        return hasHighestCandies;
    }

    public static void main(String[] args) {
        int[] candis = {2, 3, 5, 1, 3};
        KidWithHighestCandies kidWithHighestCandies = new KidWithHighestCandies();
        System.out.println(" output: " + Arrays.toString(kidWithHighestCandies.kidsWithCandies(candis, 3).toArray()));
    }

}
