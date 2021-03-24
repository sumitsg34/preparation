package org.learn.preparation.leetcode;

public class LongestPalindrome {

    private boolean isPalindrome(String s) {
        //if (s.length() < 2) return false;
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public String longestPalindrome(String s) {

        if (s == null || s.length() < 2) return s;

        String longestPalindrome = "";

        for (int i = 0; i < s.length() - 1; i++)
            for (int j = i + longestPalindrome.length() + 1; j <= s.length(); j++) {
                String curr = s.substring(i, j);
                if (isPalindrome(curr)) {
                    longestPalindrome = curr;
                }
            }
        return longestPalindrome;
    }

    public String longestPalindromeDP(String s) {
        if (s == null || s.length() <= 1)
            return s;

        int len = s.length();
        int maxLen = 1;
        boolean[][] dp = new boolean[len][len];

        String longest = null;

        for (int l = 0; l < s.length(); l++) {  // length of palindrome which starts from 0 till max length
            // each substring of length l
            for (int i = 0; i < s.length()-l; i++) {
                // here check if start and end matches

                int j = i + l; // we need calculate end -- it will curr + length of substring
                if (s.charAt(i) == s.charAt(j)
                        && (j - i <= 2 || dp[i + 1][j - 1])) {
                    // first check if start and end are equal
                    // if length of substring is 1, it is palindrome
                    // if length of substring is 2, first and second char should be matching to be an palindrome
                    // if length of substring is greater than 2, check if substring:(start+1 & end-1) is already a palindrome
                    dp[i][j] = true;
                    if ((j - i + 1) > maxLen) {
                        maxLen = j - i + 1;
                        longest = s.substring(i, j + 1);
                    }
                }
            }
        }
        return longest;
    }

    public String findLongestPalindrom(String s) {
        if (s == null || s.length() <= 1)
            return s;

        int len = s.length();
        int maxLen = 1;
        boolean[][] dp = new boolean[len][len];

        String longest = null;
        for (int l = 0; l < len; l++) {
            for (int i = 0; i < len - l; i++) { //aabbaaba 8
                int j = i + l;
                if (s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;

                    if (j - i + 1 > maxLen) {
                        maxLen = j - i + 1;
                        longest = s.substring(i, j + 1);
                    }
                }
            }
        }

        return longest;
    }

    public static void main(String[] args) {
        LongestPalindrome longestPalindrome = new LongestPalindrome();
        System.out.println(longestPalindrome.findLongestPalindrom("ac"));
        //aabbaa ba
    }
}
