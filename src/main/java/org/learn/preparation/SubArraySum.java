package org.learn.preparation;

import java.util.*;

public class SubArraySum {

    private static long sum(List<Integer> arr, int start, int end) {
        Object obj;
        int a;

        Hashtable hashtable;
        LinkedHashMap linkedHashMap;



        long sum = 0;
        for (int i = start; i < end && i < arr.size(); i++) {
            sum += arr.get(i);
            System.out.println("added " + arr.get(i));
        }
        System.out.println("done");
        return sum;
    }

    public static long findsum(List<Integer> arr) {
        int n = arr.size();
        long sum = 0;

        // i = size of sub array
        for (int i = 1; i <= n; i++) {
            int start = 0;
            while (start < n) {
                System.out.println("curr sum" + sum + " start:" + start + " end:" + (start + i) + "sub:" + sum(arr, start, start + i));
                sum += sum(arr, start, start + i);
                start = start + i;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        List<Integer> in = new ArrayList<>();
        in.add(1);
        in.add(2);
        in.add(3);

        System.out.println(findsum(in));
    }

}
