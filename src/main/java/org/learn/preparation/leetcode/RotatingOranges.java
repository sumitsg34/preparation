package org.learn.preparation.leetcode;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/rotting-oranges/
public class RotatingOranges {

    //

    static class Orange {
        int i;
        int j;
        int minutes;

        Orange(int i, int j, int minutes) {
            this.i = i;
            this.j = j;
            this.minutes = minutes;
        }
    }

    //[0] --> 0
    //[[0,2]] --> no good oranges = return 0
    //[[0,1]] --> no rotten oranges = return -1
    //[[2,1,1],[0,1,1],[1,0,1]] = -1
    public int orangesRotting(int[][] grid) {

        List<Orange> queue = new ArrayList<>();
        int goodOranges = 0;
        int rottenOrangeX = 0;
        int rottenOrangeY = 0;
        int xlength = grid.length;
        int ylength = grid[0].length;
        boolean[][] visited = new boolean[xlength][ylength];
        boolean rottenPresent = false;

        for (int i = 0; i < xlength; i++) {
            for (int j = 0; j < ylength; j++) {
                if (grid[i][j] == 0) {
                    visited[i][j] = true;
                } else {
                    if (grid[i][j] == 1) {
                        goodOranges++;
                    } else if (!rottenPresent && grid[i][j] == 2) {
                        rottenOrangeX = i;
                        rottenOrangeY = j;
                        rottenPresent = true;
                        visited[i][j] = true;
                    }
                }
            }
        }

        if (rottenPresent) {
            if (goodOranges == 0) {
                return 0;
            }
            int minute = -1;
            queue.add(new Orange(rottenOrangeX, rottenOrangeY, 0));


            int rottenCount = 0;

            while (queue.size() != 0) {

                Orange curr = queue.remove(0);

                //top
                int x = curr.i - 1;
                int y = curr.j;
                if (x >= 0) {
                    // checking if not visited and orange present
                    if (!visited[x][y] && grid[x][y] > 0) {
                        if (grid[x][y] == 1) {
                            rottenCount++;
                            queue.add(new Orange(x, y, curr.minutes + 1));
                        } else {
                            // this is another rotten orange
                            queue.add(new Orange(x, y, 0));
                        }
                    }
                    visited[x][y] = true;
                }
                //right
                x = curr.i;
                y = curr.j + 1;
                if (y < ylength) {
                    // checking if not visited and orange present
                    if (!visited[x][y] && grid[x][y] > 0) {
                        if (grid[x][y] == 1) {
                            rottenCount++;
                            queue.add(new Orange(x, y, curr.minutes + 1));
                        } else {
                            // this is another rotten orange
                            queue.add(new Orange(x, y, 0));
                        }
                    }
                    visited[x][y] = true;
                }
                //bottom
                x = curr.i + 1;
                y = curr.j;
                if (x < xlength) {
                    // checking if not visited and orange present
                    if (!visited[x][y] && grid[x][y] > 0) {
                        if (grid[x][y] == 1) {
                            rottenCount++;
                            queue.add(new Orange(x, y, curr.minutes + 1));
                        } else {
                            // this is another rotten orange
                            queue.add(new Orange(x, y, 0));
                        }
                    }
                    visited[x][y] = true;
                }
                //left
                x = curr.i;
                y = curr.j - 1;
                if (y >= 0) {
                    // checking if not visited and orange present
                    if (!visited[x][y] && grid[x][y] > 0) {
                        if (grid[x][y] == 1) {
                            rottenCount++;
                            queue.add(new Orange(x, y, curr.minutes + 1));
                        } else {
                            // this is another rotten orange
                            queue.add(new Orange(x, y, 0));
                        }
                    }
                    visited[x][y] = true;
                }
                if (rottenCount == goodOranges && minute < curr.minutes) {
                    minute = curr.minutes;
                }
            }
            return minute;
        } else {
            if (goodOranges == 0) {
                return 0;
            }
            return -1;
        }
    }

    public static void main(String[] args) {
//        int grid[][] = {
//                {1}, {2}, {2}
//        };

//        int grid[][] = {
//                {2, 1, 1}, {1, 1, 0}, {0, 1, 1}
//        };

//        int grid[][] = {
//               {1}, {2}, {2} , {0}
//        };

//        int grid[][] = {
//                {2}, {2}, {2}, {1}, {1}
//        };

        int grid[][] = {
                {1},{2},{2}
        };

        //[[2,2,2,1,1]]
        // [[2,0,1,2,1,2]]

        System.out.println("out:" + new RotatingOranges().orangesRotting(grid));

    }


}
