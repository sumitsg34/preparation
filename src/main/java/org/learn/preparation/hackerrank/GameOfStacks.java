package org.learn.preparation.hackerrank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class GameOfStacks {

    /*
     * Complete the twoStacks function below.
     */
    static int twoStacks(int x, int[] a, int[] b) {
        Stack<Integer> first = new Stack<>();

        for (int i = a.length - 1; i >= 0; i--) {
            first.push(a[i]);
        }

        Stack<Integer> second = new Stack<>();
        for (int i = b.length - 1; i >= 0; i--) {
            second.push(b[i]);
        }

        int sum = 0;
        int moves = 0;

        boolean added = true;
        while (added) {
            added = false;

            if (!first.empty() && !second.empty()) {
                int n1 = first.peek();
                int n2 = second.peek();
                if (n1 < n2) {
                    if (n1 + sum < x) {
                        sum = sum + n1;
                        first.pop();
                        added = true;
                        moves++;
                    }
                } else {
                    if (n2 + sum < x) {
                        sum = sum + n2;
                        second.pop();
                        added = true;
                        moves++;
                    }
                }
            } else {
                if (first.empty()) {
                    int n2 = second.peek();
                    if (n2 + sum < x) {
                        sum = sum + n2;
                        second.pop();
                        added = true;
                        moves++;
                    }
                } else {
                    int n2 = first.peek();
                    if (n2 + sum < x) {
                        sum = sum + n2;
                        first.pop();
                        added = true;
                        moves++;
                    }
                }
            }
        }
        return moves;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output.txt"));


        int g = Integer.parseInt(scanner.nextLine().trim());

        for (int gItr = 0; gItr < g; gItr++) {
            String[] nmx = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nmx[0].trim());

            int m = Integer.parseInt(nmx[1].trim());

            int x = Integer.parseInt(nmx[2].trim());

            int[] a = new int[n];

            String[] aItems = scanner.nextLine().split(" ");

            for (int aItr = 0; aItr < n; aItr++) {
                int aItem = Integer.parseInt(aItems[aItr].trim());
                a[aItr] = aItem;
            }

            int[] b = new int[m];

            String[] bItems = scanner.nextLine().split(" ");

            for (int bItr = 0; bItr < m; bItr++) {
                int bItem = Integer.parseInt(bItems[bItr].trim());
                b[bItr] = bItem;
            }

            int result = twoStacks(x, a, b);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();
    }
}
