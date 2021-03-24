package org.learn.preparation.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class TwoCities {

    class DistanceComparator implements Comparator<int[]> {
        @Override
        public int compare(int[] o1, int[] o2) {
            int diff1 = Math.abs(o1[0] - o1[1]);
            int diff2 = Math.abs(o2[0] - o2[1]);
            return diff2 - diff1;
        }
    }

    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, new DistanceComparator());
        int B = costs.length / 2;
        int A = costs.length / 2;
        int cost = 0;
        for (int i = 0; i < costs.length; i++) {
            int[] curr = costs[i];

            if (A < 0) {
                cost += curr[1];
                continue;
            }

            if (B < 0) {
                cost += curr[0];
                continue;
            }
            if (curr[0] < curr[1]) {
                cost += curr[0];
                A--;
            } else {
                B--;
                cost += curr[1];
            }
        }
        return cost;
    }

    public int cost(int[][] costs){
        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o1[1] - (o2[0] - o2[1]);
            }
        });

        int total = 0;
        int n = costs.length / 2;
        // To optimize the company expenses,
        // send the first n persons to the city A
        // and the others to the city B
        for (int i = 0; i < n; ++i) total += costs[i][0] + costs[i + n][1];
        return total;
    }

    public static void main(String[] args) {
        TwoCities twoCities = new TwoCities();
        //[[259,770],[448,54],[926,667],[184,139],[840,118],[577,469]]
        int[][] costs = {
                //{10, 20}, {30, 200}, {400, 50}, {30, 20}
                {259, 770}, {448, 54}, {926, 667}, {184, 139}, {840, 118}, {577, 469}

        };
        System.out.println("cost:" + twoCities.cost(costs));
    }
}
