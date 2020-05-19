package org.learn.preparation.greeks;

import java.util.Scanner;

public class MergeTwoArrays {

    public static void mergeTwoArrays(int[] a, int[] b) {
        int n1 = a.length;
        int n2 = b.length;
        int[] mergedArray = new int[n1 + n2];
        int k = 0;
        int i = 0, j = 0;
        while (i < n1 && j < n2) {
            if (a[i] < b[j]) {
                mergedArray[k] = a[i];
                i++;
            } else {
                mergedArray[k] = b[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            mergedArray[k] = a[i];
            i++;
            k++;
        }

        while (j < n2) {
            mergedArray[k] = b[j];
            j++;
            k++;
        }

        k = 0;
        while (k < mergedArray.length) {
            System.out.print(mergedArray[k] + " ");
            k++;
        }
    }

    public static void main(String[] args) {
//        int[] a = {1, 3, 5, 7};
//        int[] b = {0, 2, 4, 6};
//        mergeTwoArrays(a, b);

        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test > 0) {
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();

            int[] nums1 = new int[n1];
            for (int i = 0; i < n1; i++) {
                nums1[i] = sc.nextInt();
            }

            int[] nums2 = new int[n2];
            for (int j = 0; j < n2; j++) {
                nums2[j] = sc.nextInt();
            }

            mergeTwoArrays(nums1, nums2);
            test--;
        }
        sc.close();

    }


}
