package org.learn.preparation.hackerrank;

import java.util.Scanner;

public class StackImpl {

    private int[] stack = new int[10];
    private int size = 0;

    public void push(int num) {
        // check if current stack size is full,
        if (stack.length == size) {
            int[] temp = new int[stack.length + 10];
            for (int i = 0; i < stack.length; i++) {
                temp[i] = stack[i];
            }
            stack = temp;
        }
        stack[size] = num;
        size++;
    }

    public int pop() {
        if (stack.length == 0) {
            return -1;
        } else {
            int topElement = stack[size - 1];
            size--;
            return topElement;
        }
    }

    public int getMaxNum() {
        int maxNum = stack[0];
        for (int i = 1; i < size; i++) {
            if (maxNum > stack[i]) {
                maxNum = stack[i];
            }
        }
        return maxNum;
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int noOfCommands = Integer.valueOf(sc.nextLine());
        StackImpl stackImpl = new StackImpl();
        while (noOfCommands > 0) {
            String command = sc.nextLine();
            String[] subCommands = command.split(" ");
            if (subCommands.length > 1
                    && Integer.valueOf(subCommands[0]) == 1) {
                // add to stack
                stackImpl.push(Integer.valueOf(subCommands[1]));
            } else {
                if (Integer.valueOf(subCommands[0]) == 2) {
                    stackImpl.pop();
                } else {
                    //3
                    System.out.println(stackImpl.getMaxNum());
                }
            }
            noOfCommands--;
        }
    }
}
