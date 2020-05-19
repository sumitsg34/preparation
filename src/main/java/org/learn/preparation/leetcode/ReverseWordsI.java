package org.learn.preparation.leetcode;

public class ReverseWordsI {
    public String reverseWords(String s) {
        s = s.replaceAll("\\s+", " ").trim();
        String arr[] = s.split(" ");
        String out = "";
        for (int i = arr.length - 1; i >= 0; i--) {
            out += arr[i];
            if (0 != i) {
                out += " ";
            }
        }
        return out;
    }

    public static void main(String[] args) {
        String arr[] = "  hello world!  ".split(" ");
        System.out.println(new ReverseWordsI().reverseWords("  hello world!  "));
    }

}
