package org.learn.preparation.leetcode;

import java.util.Arrays;

public class UniquePaths {

    public static int uniquePaths(int m, int n) {

        int[][] path = new int[n][m];
        path[0][0] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0)
                    continue;
                int left = 0;
                if (i - 1 >= 0)
                    left = path[i - 1][j];

                int up = 0;
                if (j - 1 >= 0)
                    up = path[i][j - 1];
                path[i][j] = left + up;
            }
        }

        System.out.println(Arrays.deepToString(path));

        return path[n - 1][m - 1];
    }

    public static void main(String[] args) {
        uniquePaths(7, 3);
    }

}
