package org.learn.preparation.leetcode;

import java.util.Arrays;

public class SurroundedRegions {
    int row;
    int col;
    char[][] board;

    public void solve(char[][] board) {

        if (board.length == 0)
            return;
        this.row = board.length;
        this.col = board[0].length;

        for (int i = 1; i < row - 1; i++) {
            for (int j = 1; j < col - 1; j++) {
                if (board[i][j] == 'O') {
                    backtrackRegion(i, j, board);
                }
            }
        }
    }

    private boolean backtrackRegion(int i, int j, char[][] board) {

        //if( (i >= row || i< 0 || j >= col || j < 0) && board[i][j] == '')
        //    return false;

        if (board[i][j] == 'O' && (i == 0 || i == row - 1 || j == 0 || j == col - 1))
            return false;

        if (board[i][j] == 'O') {

            board[i][j] = 'X';
            int[][] d = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
            for (int k = 0; k < 4; k++) {
                boolean res = backtrackRegion(i + d[k][0], j + d[k][1], board);
                if (!res) {
                    board[i][j] = 'O';
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = {{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
        SurroundedRegions surroundedRegions = new SurroundedRegions();
        surroundedRegions.solve(board);
        System.out.println(Arrays.toString(board));
    }
}
