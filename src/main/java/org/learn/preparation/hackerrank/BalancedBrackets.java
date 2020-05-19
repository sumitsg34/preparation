package org.learn.preparation.hackerrank;

import java.io.IOException;
import java.util.Map;

public class BalancedBrackets {

    static String isBalanced(String s) {

        char stack[] = new char[s.length()];
        int size = 0;
        for (int i = 0; i < s.length(); i++) {
            char brace = s.charAt(i);
            if (brace == '[' || brace == '(' || brace == '{') {
                stack[size] = brace;
                size++;
            } else {
                char lastBrace = stack[size - 1];
                if (brace == ']' && lastBrace == '[') {
                    size--;
                } else {
                    if (brace == ')' && lastBrace == '(') {
                        size--;
                    } else {
                        if (brace == '}' && lastBrace == '{') {
                            size--;
                        } else {
                            return "NO";
                        }
                    }
                }
            }
        }

        return "YES";

    }

    public static void main(String[] args) throws IOException {
        System.out.println(BalancedBrackets.isBalanced("{[()]}"));
    }


}
