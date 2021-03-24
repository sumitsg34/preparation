package org.learn.preparation.leetcode;

public class HammingDistance {

    public static int hammingDistance(int x, int y) {
        int distance = 0;
        boolean found = false;
        while(x>0 || y >0){
            int first = x%2;
            int second = y%2;

            // this is for first time
            if(first != second && !found) {
                found = true;
                distance++;
            }else{
                // now if found it true
                if(first != second && found)
                    break;
                if(first == second && found)
                    distance ++;
            }
            x = x/2;
            y = y/2;
        }
        return distance;

    }

    public static void main(String[] args) {
        System.out.println(hammingDistance(4,1));
    }
}
