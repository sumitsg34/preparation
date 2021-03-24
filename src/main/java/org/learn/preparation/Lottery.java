package org.learn.preparation;

import java.util.HashMap;
import java.util.Map;

public class Lottery {

    public static int lotteryCoupons(int n) {
        Map<Integer, Integer> count = new HashMap<>();
        int max = 0;
        for (int i = 1; i <= n; i++) {
            if (i < 10) {
                count.put(i, count.getOrDefault(i, 0) + 1);
            } else {
                int sum = 0;
                int x= i;
                while (x != 0) {
                    int temp = x % 10;
                    sum += temp;
                    x = x / 10;
                }
                count.put(sum, count.getOrDefault(sum, 0) + 1);
            }
        }
        //System.out.println("map is:"+count);
        for (Integer key : count.keySet()) {
            Integer val = count.get(key);
            if (max < val) {
                max = val;
            }
            // System.out.println("max is:"+max);
        }

        int res = 0;
        for (Integer key : count.keySet()) {
            Integer val = count.get(key);
            //System.out.println("val is:"+val);
            if (max == val) {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        lotteryCoupons(12);
    }
}
