package org.learn.preparation.greeks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ArrayLeader {

    public static void getArrayLeader(Integer[] nums) {
        List<Integer> leaders = new ArrayList<>();
        //last element is always leader
        leaders.add(nums[nums.length - 1]);
        //lets start from the end
        for (int i = nums.length - 2; i >= 0; i--) {
            //get the last leader
            int lastLeader = leaders.get(leaders.size() - 1);
            if (nums[i] >= lastLeader) {
                leaders.add(nums[i]);
            }
        }
        Collections.reverse(leaders);
        leaders.forEach(leader -> System.out.print(leader + " "));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        List<List<Integer>> list = new ArrayList<>(t);
        while (t > 0) {
            int n = sc.nextInt();
            System.out.println("reading next:" + n);
            List<Integer> nums = new ArrayList<>(n);
            while (n > 0) {
                int temp = sc.nextInt();
                nums.add(temp);
                n--;
                System.out.println("read: " + temp);
            }
            list.add(nums);
            t--;
        }

        list.forEach(l -> {
            Integer[] temp = new Integer[l.size()];
            getArrayLeader(l.toArray(temp));
        });

        //getArrayLeader(new Integer[]{16, 17, 4, 3, 5, 2});

    }
}
