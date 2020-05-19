package org.learn.preparation.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode.com/problems/number-of-islands/
 */
public class NumberOfIslands {

    class Land {
        int x;
        int y;

        Land(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int numIslands(char[][] grid) {

        // first find all 1s
        List<Land> lands = new ArrayList<>();
        int length = grid.length;
        int width = grid[0].length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                if (grid[i][j] == '1') {
                    lands.add(new Land(i, j));
                }
            }
        }

        // iterate over a list of 1s
        int islands = 0;
        boolean[][] visited = new boolean[length][width];
        for (Land land : lands) {
            if (!visited[land.x][land.y]) {
                visited[land.x][land.y] = true;
                islands++;
                List<Land> connectedLands = new ArrayList<>();
                connectedLands.add(land);
                while (connectedLands.size() > 0) {
                    //top
                    Land currLand = connectedLands.remove(0);
                    int currX = currLand.x;
                    int currY = currLand.y;

                    int x = currX - 1;
                    int y = currY;
                    if (x >= 0 && grid[x][y] == '1' && !visited[x][y]) {
                        visited[x][y] = true;
                        connectedLands.add(new Land(x, y));
                    }
                    //right
                    x = currX;
                    y = currY + 1;
                    if (y < width && grid[x][y] == '1' && !visited[x][y]) {
                        visited[x][y] = true;
                        connectedLands.add(new Land(x, y));
                    }
                    //bottom
                    x = currX + 1;
                    y = currY;
                    if (x < length && grid[x][y] == '1' && !visited[x][y]) {
                        visited[x][y] = true;
                        connectedLands.add(new Land(x, y));
                    }
                    //left
                    x = currX;
                    y = currY - 1;
                    if (y >= 0 && grid[x][y] == '1' && !visited[x][y]) {
                        visited[x][y] = true;
                        connectedLands.add(new Land(x, y));
                    }
                }
            }
        }
        return islands;
    }

    public static void main(String[] args) {

        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };

        System.out.println("Out:" + new NumberOfIslands().numIslands(grid));
    }


}
