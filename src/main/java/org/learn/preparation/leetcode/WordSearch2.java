package org.learn.preparation.leetcode;

import java.util.ArrayList;
import java.util.List;

public class WordSearch2 {
    char[][] board;
    int row;
    int col;

    public List<String> findWords(char[][] board, String[] words) {

        if (words.length == 0)
            return new ArrayList<>();

        this.board = board;
        this.row = board.length;
        this.col = board[0].length;

        List<String> found = new ArrayList<>();

        for (String word : words) {
            for (int i = 0; i < row; i++) {
                boolean matched = false;
                for (int j = 0; j < col; j++) {
                    if (board[i][j] == word.charAt(0)
                            && backtrack(word, 0, i, j)) {
                        found.add(word);
                        matched = true;
                        break;
                    }
                }
                if (matched) {
                    break;
                }
            }
        }
        return found;
    }

    private boolean backtrack(String word, int index, int x, int y) {

        if (word.length() == index)
            return true;

        if (x < 0 || x >= this.row || y < 0 || y >= this.col || board[x][y] != word.charAt(index))
            return false;

        board[x][y] = '$';

        int[][] d = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        for (int i = 0; i < 4; i++) {
            if (backtrack(word, index + 1, x + d[i][0], y + d[i][1])) {
                board[x][y] = word.charAt(index);
                return true;
            }
        }

        board[x][y] = word.charAt(index);
        return false;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}};

        String[] in = {"oath"};

        WordSearch2 wordSearch2 = new WordSearch2();
        System.out.println("out:" + wordSearch2.findWords(board, in));
    }
}
