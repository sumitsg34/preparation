package org.learn.preparation.leetcode;

public class Atoi {


    public int myAtoi(String str) {

        int i = 0;
        while (i < str.length() && str.charAt(i) == ' ') {
            i++;
        }  //" hii"
        String trimmed = str.substring(i);
        if (trimmed.length() < 1) {
            return 0;
        }
        boolean isPositive = true;
        i = 0;
        if (trimmed.charAt(i) == '+') {
            isPositive = true;
            i++;
        } else if (trimmed.charAt(i) == '-') {
            isPositive = false;
            i++;
        }
        int j = 0;
        char[] number = new char[trimmed.length()];
        boolean isValid = false;
        while (i < trimmed.length()
                && trimmed.charAt(i) <= '9' && trimmed.charAt(i) >= '0') {
            number[j] = trimmed.charAt(i);
            j++;
            i++;
            isValid = true;
        }
        if (!isValid)
            return 0;
        int p = 0;
        String out = "";
        if (!isPositive) {
            out += "-";
        }
        while (p < j) {
            out += number[p];
            p++;
        }
        try {
            return Integer.valueOf(out);
        } catch (Exception e) {
            if (isPositive) {
                return Integer.MAX_VALUE;
            } else {
                return Integer.MIN_VALUE;
            }
        }
    }


    public static void main(String[] args) {
        Atoi atoi = new Atoi();
        System.out.println("num:" + atoi.myAtoi(""));
    }
}
