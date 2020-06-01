package org.learn.preparation.leetcode;

public class StrStr {

    public static int strStr(String haystack, String needle) {
        if(needle == null || needle=="" )
            return 0;
        int k =0 ;
        int start =0;
        for(int i=0;i<haystack.length();i++){
            if(haystack.charAt(i) == needle.charAt(k)){
                if(k==0){
                    start = i;
                }
                k++;
            }
            if(k==needle.length()){
                return start;
            }
        }
        return -1;

    }

    public static void main(String[] args) {
        System.out.println("out:"+strStr("hello" , "ll"));
        System.out.println("out:"+strStr("" , ""));
    }
}
