package org.learn.preparation.hackerrank;

import java.util.List;
import java.util.Queue;

/*
 * https://www.hackerrank.com/challenges/queries-with-fixed-length
 */
public class QueriesWithFixedLength {

    static int[] solve(int[] arr, int[] queries) {
        int length = queries.length;
        int[] ouput = new int[length];

        for (int i = 0; i < length; i++) {
            int window = queries[i];
            int globalMin = Integer.MAX_VALUE;
            int j = 0;
            while (window <= arr.length) {
                //max under one window
                int max = Integer.MIN_VALUE;
                //window
                int k = j;
                while (k < window) {
                    if (max < arr[k]) {
                        max = arr[k];
                    }
                    k++;
                }

                if (max < globalMin) {
                    globalMin = max;
                }
                window++;
                j++;
            }
            ouput[i] = globalMin;
        }
        return ouput;
    }

    static int[] solve2(int[] arr, int[] queries) {
        int length = queries.length;
        int[] ouput = new int[length];

        for (int i = 0; i < length; i++) {
            // create first window

            // then for each next window, just consider newly added
            

        }
        return ouput;
    }

    public static void main(String[] args) {
        int[] arr = {33, 11, 44, 11, 55};
        int[] q = {1, 2, 3, 4, 5};
        solve(arr, q);
    }
}
