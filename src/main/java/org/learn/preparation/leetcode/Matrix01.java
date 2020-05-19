package org.learn.preparation.leetcode;

import java.util.Objects;
import java.util.Stack;

/**
 * https://leetcode.com/problems/01-matrix/
 */
public class Matrix01 {

    class node {
        int i;
        int j;

        node(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass())
                return false;
            node node = (node) o;
            return i == node.i &&
                    j == node.j;
        }

        @Override
        public int hashCode() {
            return Objects.hash(i, j);
        }
    }

    private int nearestZero(int i, int j, int[][] input, int currentDistance, node prev) {
        //System.out.println(" i: " + i + " j: " + j);
        if (input[i][j] == 0) {
            return currentDistance;
        }
        Stack<node> nodes = new Stack<>();

        int row = input[0].length;
        int col = input[1].length;

        //top
        if ((i - 1 >= 0) && input[i - 1][j] == 0) {
            return currentDistance + 1;
        } else {
            //push top
            node top = new node(i - 1, j);
            if (i - 1 >= 0 && !top.equals(prev))
                nodes.push(top);
            //right
            if ((j + 1 < col) && input[i][j + 1] == 0) {
                return currentDistance + 1;
            } else {
                //push right
                node right = new node(i, j + 1);
                if (j + 1 < col && !right.equals(prev))
                    nodes.push(new node(i, j + 1));
                //bottom
                if ((i + 1 < row) && input[i + 1][j] == 0) {
                    return currentDistance + 1;
                } else {
                    //push bottom
                    node bottom = new node(i + 1, j);
                    if (i + 1 < row && !bottom.equals(prev))
                        nodes.push(new node(i + 1, j));
                    //left
                    if ((j - 1 >= 0) && input[i][j - 1] == 0) {
                        return currentDistance + 1;
                    } else {
                        //push left
                        node left = new node(i, j - 1);
                        if (j - 1 >= 0 && !left.equals(prev))
                            nodes.push(new node(i, j - 1));
                    }
                }
            }
        }
        while (!nodes.empty()) {
            node node = nodes.pop();
            int distance = nearestZero(node.i, node.j, input, currentDistance, new node(i, j));
            if (distance != -1) {
                return currentDistance + distance + 1;
            }
        }
        return -1;
    }

    public int[][] updateMatrix(int[][] matrix) {
        int[][] output = new int[matrix[0].length][matrix[1].length];

        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix[1].length; j++) {
                output[i][j] = nearestZero(i, j, matrix, 0, new node(-1, -1));
//                for (int k = 0; k < output[0].length; k++) {
//                    for (int l = 0; l < output[1].length; l++) {
//                        System.out.print(" " + output[k][l]);
//                    }
//                    System.out.println();
//                }
            }
        }
        return output;
    }

    public static void main(String[] args) {
        int[][] input = {
                {1, 1, 0},
                {1, 1, 1},
                {1, 1, 1}
        };

        int[][] output = new Matrix01().updateMatrix(input);
        System.out.println("Final output:");
        for (int i = 0; i < output[0].length; i++) {
            for (int j = 0; j < output[1].length; j++) {
                System.out.print(" " + output[i][j]);
            }
            System.out.println();
        }
    }

}
