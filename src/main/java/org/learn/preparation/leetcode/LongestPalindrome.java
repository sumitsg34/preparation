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
        if (s == null || s.length() < 2) return s;

        int len = s.length();
        int[][] dp = new int[len][len];

        String longestPalindrome = s.substring(0, 1);
        //length=1 strings: they are always palindrome
        for (int i = 0; i < len; i++) {
            dp[i][i] = 1;
        }

        //length=2 strings: if start and end are equal, it is a palindrome
        for (int i = 0; i < len - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = 1;
                longestPalindrome = s.substring(i, i + 2);
            }
        }


        //  aabbaabb
        for (int i = 0; i < s.length() - 1; i++) {
            for (int j = i + 2; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)
                        && (j - i <= 2 || dp[i + 1][j - 1] == 1)) {
                    dp[i][j] = 1;
                    if ((j - i + 1) > longestPalindrome.length()) {
                        longestPalindrome = s.substring(i, j + 1);
                    }
                }
            }
        }
        return longestPalindrome;
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
        System.out.println(longestPalindrome.findLongestPalindrom("aabbaaba"));
        //aabbaa ba
    }
}
