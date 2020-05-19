package org.learn.preparation.hackerrank;

import java.util.Scanner;
import java.util.Stack;

public class QueueUsing2Stack {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Stack<Integer> inbox = new Stack<>();
        Stack<Integer> outbox = new Stack<>();
        while (n > 0) {
            int query = sc.nextInt();
            if (query == 1) {
                inbox.push(sc.nextInt());
            } else {
                if (outbox.empty()) {
                    while (!inbox.empty()) {
                        outbox.push(inbox.pop());
                    }
                }
                if (query == 2) {
                    outbox.pop();
                } else {
                    System.out.println(outbox.peek());
                }
            }
            n--;
        }
        sc.close();
    }
}
