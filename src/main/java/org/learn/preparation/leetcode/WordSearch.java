package org.learn.preparation.leetcode;

public class WordSearch {

    char[][] board;
    int columns;
    int rows;
    String word;

    public boolean exist(char[][] board, String word) {
        //lets use backtrack: this is nothing but recursion and we can do it
        this.board = board;
        this.rows = board.length;
        this.columns = board[0].length;
        this.word = word;

        // now lets invoke each cell, as any one of them can be a solution
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (searchWord(i, j, 0)) {
                    // if any of cell return true, that means we found the word and hence return true;
                    return true;
                }
            }
        }
        return false;
    }

    // inputs
    // current cell's row and column
    // word's index to be matched
    private boolean searchWord(int row, int col, int index) {

        // first we ll check if index has gone behind the word
        if (index >= word.length()) {
            return true; // word found !!!
        }

        //check boundaries
        if (row < 0 || row >= this.rows || col < 0 || col >= this.columns)
            return false; // invalid cell

        // then check if current index and current cells character matches
        if (board[row][col] == word.charAt(index)) {
            // lets mark current char as visited
            board[row][col] = '#';

            // now if current char matches, lets go in search for next char in all four directions
            int[] xOffsets = {-1, 0, 1, 0};
            int[] yOffsets = {0, 1, 0, -1};

            for (int i = 0; i < 4; i++) {
                boolean res = searchWord(row + xOffsets[i], col + yOffsets[i], index + 1);
                if (res) {
                    System.out.println("found at final path: " + row + " : " + col);
                    board[row][col] = word.charAt(index);
                    return res;
                }
            }
            // replacing character back to normal if
            board[row][col] = word.charAt(index);
        }
        // incorrect path
        return false;
    }


    public static void main(String[] args) {
        char[][] board =
                {
                        {'A', 'B', 'C', 'E'},
                        {'S', 'F', 'C', 'S'},
                        {'A', 'D', 'E', 'E'}};
        WordSearch wordSearch = new WordSearch();
        System.out.println(wordSearch.exist(board, "SEE"));
        System.out.println(wordSearch.exist(board, "ABCCE"));
        System.out.println(wordSearch.exist(board, "ABCCX"));
    }
}

