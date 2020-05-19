package org.learn.preparation.amazon;

import java.util.HashMap;

public class Test1 {

    public int solution(int[] A) {
        // write your code in Java SE 8
        if (A.length == 0) {
            return 0;
        }

        HashMap<Integer, Integer> visitedNumbers = new HashMap<>();
        int pairs = 0;
        for (int i = 0; i < A.length; i++) {
            int num = A[i];
            if (visitedNumbers.containsKey(num)) {
                int count = visitedNumbers.get(num);
                pairs = count + pairs;
                if (pairs == 1000000000) {
                    break;
                }
                visitedNumbers.put(num, count+1);
            } else {
                visitedNumbers.put(num, 1);
            }
        }
        return pairs;
    }

    public static void main(String[] args) {
        int[] a = { 3,5,6,3,3,3,5};
        System.out.println("count "+ new Test1().solution(a));

    }
}
