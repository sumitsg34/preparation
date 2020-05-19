package org.learn.preparation.greeks;

import java.util.Scanner;

public class RearrangeSortedArray {

    static void rearrangeArray(int[] arr) {

        int i = 0;
        while (i < arr.length - 1) {
            rightShift(arr, i);
            i += 2;
        }
        for (int j = 0; j < arr.length; j++) {
            System.out.print(arr[j] + " ");
        }
        System.out.println();
    }

    private static void rightShift(int[] arr, int i) {
        //
        int last = arr[arr.length - 1];
        while (i < arr.length) {
            int temp = arr[i];
            arr[i] = last;
            last = temp;
            i++;
        }
    }

    public static void main(String[] args) {
        rearrangeArray(new int[]{10, 20, 30, 40, 50, 60,70});
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test > 0) {
            int n = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }
            rearrangeArray(nums);
            test--;
        }
        sc.close();
    }
}
