package org.learn.preparation.hackerrank;

public class CircularArray {

    static int[] circularArrayRotation(int[] a, int k, int[] queries) {
        int[] temp = new int[a.length];

        for (int i = 0; i < a.length; i++) {
            int j = (i + k) % a.length;
            temp[j] = a[i];
        }

        int[] out = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            out[i] = temp[queries[i]];
        }

        return out;

    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        int[] q = {0, 1, 2};

        circularArrayRotation(a,2,q);

    }

}
