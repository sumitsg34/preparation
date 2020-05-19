package org.learn.preparation.hackerrank;

import java.util.HashSet;
import java.util.Set;

/*
 * https://www.hackerrank.com/challenges/minimum-swaps-2/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays
 */
public class MinimumSwaps {



    static int minimumSwaps(int[] arr) {

        int swaps = 0;
        Set<Integer> visited = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            if (!visited.contains(i)) {
                visited.add(i);
                int start = i;
                int next = arr[i] - 1;
                //System.out.print("" + i);
                while (start != next) {
                    System.out.print(" -->" + next);
                    visited.add(next);
                    next = arr[next] - 1;
                    swaps++;
                }
                //System.out.println();
            }
        }
        return swaps;
    }

    public static void main(String[] args) {
        System.out.println("count:" + minimumSwaps(new int[]{6, 3, 8, 10, 7, 4, 5, 2, 1, 9}));
    }


}
