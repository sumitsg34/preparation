package org.learn.preparation.hackerrank;

/**
 * https://www.hackerrank.com/challenges/crush/problem?h_r=next-challenge&h_v=zen
 */
public class ArrayManipulation {

    // Complete the arrayManipulation function below.
    static long arrayManipulation(int n, int[][] queries) {
        long[] arr = new long[n];
        long max=0;
        for(int i=0;i<queries.length;i++){
            int x=queries[i][0]-1;
            int y=queries[i][1]-1;
            int addition = queries[i][2];
            for(int j=x;j<=y; j++){
                long sum= Long.sum(arr[j],addition);
                arr[j]=sum;
                if(sum>max){
                    max=sum;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] queries = {
                {2, 6, 8},
                {3, 5, 7},
                {1, 8, 1},
                {5, 9, 15}
        };

        arrayManipulation(10, queries);


    }


}
