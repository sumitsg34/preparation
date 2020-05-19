package org.learn.preparation;

public class P3RotateMatrix {

    public static void display(int[][] input) {
        int n = input.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("| " + input[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static int[][] rotateMatrix(int[][] input) {
        int n = input.length;
        int output[][] = new int[n][n];
        display(input);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                //System.out.println("replacing: ["+ i +","+ j+ "] with [" + (n-1-j) +"]["+i+"]");
                output[i][j] = input[n - 1 - j][i];
            }
        }
        display(output);
        return output;
    }

    public static int[][] rotateMatrixInMemory(int[][] input) {
        int n = input.length;
        int output[][] = new int[n][n];
        display(input);
        int k = n - 1;
        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                System.out.println("i=" + i + " j=" + j);
                int temp = input[i][j];
                input[i][j] = input[k - j][i];

                int temp2 = input[j][k - i];
                input[j][k - i] = temp;

                int temp3 = input[k - j][k - i];
                input[k - j][k - i] = temp2;

                input[k - j][i] = temp3;
            }
        }
        display(input);
        return output;
    }


    public static void main(String[] args) {


        int[][] input = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotateMatrixInMemory(input);

        int[][] input2 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        //rotateMatrix(input2);
    }

}
