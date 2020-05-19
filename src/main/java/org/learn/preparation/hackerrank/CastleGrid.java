package org.learn.preparation.hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CastleGrid {

    static class Cell {
        int x;
        int y;
        int depth;

        Cell(int x, int y, int depth) {
            this.x = x;
            this.y = y;
            this.depth = depth;
        }

        boolean isEqual(Cell other) {
            return this.x == other.x && this.y == other.y;
        }
    }

    static int minimumMoves(int[][] grid, int startX, int startY, int goalX, int goalY) {

        List<Cell> queue = new ArrayList<>();
        queue.add(new Cell(startX, startY, 0));

        Cell dest = new Cell(goalX, goalY, 0);
        int upper = grid[0].length;
        boolean[][] visitedNode = new boolean[upper][upper];

        while (queue.size() > 0) {

            // is it destination
            Cell curr = queue.remove(0);
            if (dest.isEqual(curr)) {
                return curr.depth;
            }

            int x = curr.x;
            int y = curr.y + 1;
            //find all horizontal to right
            while (y < upper && grid[x][y] != -1) {
                if (!visitedNode[x][y]) {
                    visitedNode[x][y] = true;
                    queue.add(new Cell(x, y, curr.depth + 1));
                }
                y++;
            }

            //find all horizontal to left
            y = curr.y - 1;
            while (y >= 0 && grid[x][y] != -1) {
                if (!visitedNode[x][y]) {
                    visitedNode[x][y] = true;
                    queue.add(new Cell(x, y, curr.depth + 1));
                }
                y--;
            }

            //find all vertical to down
            x = curr.x + 1;
            y = curr.y;
            while (x < upper && grid[x][y] != -1) {
                if (!visitedNode[x][y]) {
                    visitedNode[x][y] = true;
                    queue.add(new Cell(x, y, curr.depth + 1));
                }
                x++;
            }

            //find all vertical to down
            x = curr.x - 1;
            while (x >= 0 && grid[x][y] != -1) {
                if (!visitedNode[x][y]) {
                    visitedNode[x][y] = true;
                    queue.add(new Cell(x, y, curr.depth + 1));
                }
                x--;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[][] grid = null;
        int j = 0;
        // reading grid
        while (n > 0) {
            String row = sc.nextLine();
            if (grid == null)
                grid = new int[n][row.length()];
            for (int i = 0; i < row.length(); i++) {
                grid[j][i] = row.charAt(i) == 'X' ? -1 : 0;
            }
            j++;
            n--;
        }

        // reading source
        int x = sc.nextInt();
        int y = sc.nextInt();
        // reading destination
        int p = sc.nextInt();
        int q = sc.nextInt();
        sc.close();

//        int[][] grid = {
//                {0, 0, -1},
//                {0, -1, 0},
//                {0, 0, 0}
//        };
//
        int depth = minimumMoves(grid, 0, 0, 1, 2);
        System.out.println("depth is " + depth);
    }

}
