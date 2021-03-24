package org.learn.preparation.leetcode;

public class DungeonGame {

    int row = 0;
    int col = 0;

    public int calculateMinimumHP(int[][] dungeon) {
        return 0;
    }

    private Integer findYourQueen(int[][] dungeon, int x, int y) {
        if (x == row - 1 && y == col - 1) {
            System.out.println("find my Queen !!! But I spend this much health: " + dungeon[row - 1][col - 1]);
            return dungeon[row - 1][col - 1];
        }

        if (x >= row || y >= col) {
            return null;
        }

        // go to right and down
        Integer healthFromBottom = findYourQueen(dungeon, x + 1, y);
        Integer healthFromRight = findYourQueen(dungeon, x, y + 1);
        if (healthFromBottom == null && healthFromRight != null)
            return dungeon[x][y] + healthFromRight;

        if (healthFromBottom != null && healthFromRight == null)
            return dungeon[x][y] + healthFromBottom;

        if (healthFromBottom < healthFromRight)
            return dungeon[x][y] + healthFromBottom;
        else
            return dungeon[x][y] + healthFromRight;

    }

    public static void main(String[] args) {
        int[][] dungeon = {{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}};
        DungeonGame dungeonGame = new DungeonGame();
        System.out.println(dungeonGame.calculateMinimumHP(dungeon));
    }


}
