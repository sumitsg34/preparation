package org.learn.preparation.amazon;

public class Test2 {

    private int[][] getReservedSeats(int N, String s) {
        int[][] reservedSeats = new int[N][10];
        if (s == null || s.length() == 0) {
            return reservedSeats;
        } else {
            String[] seats = s.split(" ");
            for (String seat : seats) {
                int row = Integer.parseInt(String.valueOf(seat.charAt(0))) - 1;
                switch (seat.charAt(1)) {
                    case 'A':
                        reservedSeats[row][0] = 1;
                        break;
                    case 'B':
                        reservedSeats[row][1] = 1;
                        break;
                    case 'C':
                        reservedSeats[row][2] = 1;
                        break;
                    case 'D':
                        reservedSeats[row][3] = 1;
                        break;
                    case 'E':
                        reservedSeats[row][4] = 1;
                        break;
                    case 'F':
                        reservedSeats[row][5] = 1;
                        break;
                    case 'G':
                        reservedSeats[row][6] = 1;
                        break;
                    case 'H':
                        reservedSeats[row][7] = 1;
                        break;
                    case 'J':
                        reservedSeats[row][8] = 1;
                        break;
                    case 'K':
                        reservedSeats[row][9] = 1;
                        break;
                }
            }
        }
        return reservedSeats;
    }

    public int solution(int N, String S) {
        // write your code in Java SE 8
        int[][] reservedSeats = getReservedSeats(N, S);

        int families = 0;
        for (int i = 0; i < N; i++) {
            // case 1:
            if (reservedSeats[i][1] == 0
                    && reservedSeats[i][2] == 0
                    && reservedSeats[i][3] == 0
                    && reservedSeats[i][4] == 0) {
                // first aisle
                families++;

                // second aisle
                if (reservedSeats[i][5] == 0
                        && reservedSeats[i][6] == 0
                        && reservedSeats[i][7] == 0
                        && reservedSeats[i][8] == 0) {
                    families++;
                }
            } else {
                // middle seats
                if (reservedSeats[i][3] == 0
                        && reservedSeats[i][4] == 0
                        && reservedSeats[i][5] == 0
                        && reservedSeats[i][6] == 0) {
                    families++;
                } else {
                    // second aisle
                    if (reservedSeats[i][5] == 0
                            && reservedSeats[i][6] == 0
                            && reservedSeats[i][7] == 0
                            && reservedSeats[i][8] == 0) {
                        families++;
                    }
                }

            }
        }
        return families;
    }

    public static void main(String[] args) {
        System.out.println("count: " + new Test2().solution(1, ""));
    }

}
