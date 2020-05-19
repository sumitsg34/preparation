package org.learn.preparation.hackerrank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PilesOfBoxes {

    public static long pilesOfBoxes(List<Integer> boxesInPiles) {
        // Write your code here

        Collections.sort(boxesInPiles);

        String s = "";


        long lastUpdatedCount =0;
        int size = boxesInPiles.size();

        for(int i = size-1; i>0;i--){
            if(boxesInPiles.get(i-1)<boxesInPiles.get(i)){
                lastUpdatedCount+= (size-i);
            }
        }

        return lastUpdatedCount;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(5);
        list.add(5);
        list.add(2);
        list.add(4);
        System.out.println("out: "+pilesOfBoxes(list));

    }
}
