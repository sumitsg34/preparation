package org.learn.preparation.hackerrank;

import java.util.HashMap;
import java.util.Map;

/*
* https://www.hackerrank.com/challenges/new-year-chaos/forum?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays
 */
public class NewYearChaos {


    static void minimumBribes(int[] q) {

        int bribe = 0;
        Map<Integer, Integer> counts = new HashMap<>();
        boolean isValid = true;
        for (int i = 0; i < q.length; i++) {
            for (int j = 0; j < q.length-1; j++) {
                if (q[j] > q[j + 1]) {
                    int count = 0;
                    if (counts.containsKey(q[j])) {
                        count = counts.get(q[j]);
                    }
                    if (count < 2) {
                        counts.put(q[j], count + 1);
                        int temp = q[j + 1];
                        q[j + 1] = q[j];
                        q[j] = temp;
                        bribe++;
                    } else {
                        isValid = false;
                        break;
                    }
                }
            }
        }
        if (!isValid) {
            System.out.println("Too chaotic");
        } else {
            System.out.println(bribe);
        }
    }

    public static void main(String[] args) {
        int[] q = {2, 5, 1, 3, 4};
        minimumBribes(q);

    }
}
