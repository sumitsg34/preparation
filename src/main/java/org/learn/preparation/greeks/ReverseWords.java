package org.learn.preparation.greeks;

import java.util.Scanner;

public class ReverseWords {

    public static String reverseWords(String input) {
        // I was the best goalKeeper?
        String[] words = input.split("\\.");
        String str = "";
        for (int i = words.length - 1; i >= 0; i--) {
            str += words[i];
            if (i > 0)
                str += ".";
        }
        return str;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test > 0) {
            String input = sc.nextLine();
            reverseWords(input);
            test--;
        }
        sc.close();
    }

}
