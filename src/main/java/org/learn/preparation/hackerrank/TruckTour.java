package org.learn.preparation.hackerrank;

/*
 * https://www.hackerrank.com/challenges/truck-tour/problem
 */
public class TruckTour {

    static int truckTour(int[][] petrolpumps) {
        /*
         * Write your code here.
         */
        int length = petrolpumps.length;
        boolean hasReachedEnd = false;
        int i = 0;
        for (; i < length; i++) {
            int petrol = 0;
            int start = i;
            while (true) {
                //i need a breaking pt
                petrol = petrol + (petrolpumps[start][0] - petrolpumps[start][1]);
                if (petrol < 0) {
                    hasReachedEnd = false;
                    break;
                }
                if (start == ((i - 1) % length)) {
                    hasReachedEnd = true;
                    break;
                }
                start = (start + 1) % length;
            }
            if (hasReachedEnd) {
                break;
            }
        }
        return i;
    }

    public static void main(String[] args) {

        int[][] petrolPumps = {
                {1, 5},
                {10, 3},
                {3, 4}
        };
        truckTour(petrolPumps);

    }


}
