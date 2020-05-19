package org.learn.preparation.leetcode;

public class StraightLine {

    public boolean checkStraightLine(int[][] coordinates) {

        if (coordinates.length < 2)
            return false;

        if (coordinates.length == 2)
            return true;

        double slope = 0;
        double xD = coordinates[1][0] - coordinates[0][0];
        if (xD > 0) {
            slope = ((coordinates[1][1] - coordinates[0][1]) / xD);
        }
        for (int i = 2; i < coordinates.length; i++) {
            double currSlope = 0;
            double xDiff = coordinates[i][0] - coordinates[i - 1][0];
            if (xDiff > 0) {
                currSlope =
                        (coordinates[i][1] - coordinates[i - 1][1]) / xDiff;
            }
            if (currSlope != slope) {
                return false;
            } else {
                slope = currSlope;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] coordinates = {{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}};
        //int[][] coordinates = {{1, 1}, {2, 2}, {3, 4}, {4, 5}, {5, 6}, {7, 7}};

        //int[][] coordinates = {{0, 1}, {2,4}, {3,3}};
        StraightLine straightLine = new StraightLine();
        System.out.println("this is a straight line : " + straightLine.checkStraightLine(coordinates));

    }


}
