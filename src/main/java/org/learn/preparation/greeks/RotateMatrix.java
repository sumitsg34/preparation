package org.learn.preparation.greeks;

public class RotateMatrix {

    static void rotate(int[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " |");
            }
            System.out.println();
        }


        //1. find tranform
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[i].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        System.out.println("transpose matrix");

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " |");
            }
            System.out.println();
        }


        // 2. reverse each row

        for (int i = 0; i < matrix.length; i++) {
            int p = 0;
            int q = matrix[i].length - 1;
            while (p < q) {
                int temp = matrix[i][p];
                matrix[i][p] = matrix[i][q];
                matrix[i][q] = temp;
                p++;
                q--;
            }
        }

        System.out.println("Transformed matrix");

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " |");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        rotate(
                new int[][]{
                        {1, 2, 3}, {4, 5, 6}, {7, 8, 9}
                }
        );
    }
}
