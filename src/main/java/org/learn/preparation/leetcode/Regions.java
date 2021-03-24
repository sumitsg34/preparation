package org.learn.preparation.leetcode;

public class Regions {

    public int solution(int[] A) {
        Integer count = 0;
        Integer regions = 0;
        Integer currDiff = 0;
        for (int i = 0; i < A.length - 1; i++) {
            currDiff = A[i + 1] - A[i];
            count++;
            for (int j = i + 2; j < A.length; j++) {
                if (A[j] - A[j - 1] == currDiff) {
                    count++;
                    if (count >= 2) {
                        regions++;
                    }

                } else {
                    count = 0;
                    break;
                }
            }
        }
            return 0;

    }

    public static void main(String[] args) {
        int[] A = {-1, 1, 3, 3, 3, 2, 3, 2, 1, 0};

        //int[] diff = 2,2,0,0,1,1

    }
}
