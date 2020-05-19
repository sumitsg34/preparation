package org.learn.preparation;

import java.util.*;

public class P2FindTripletSum {

    public static HashSet<List<Integer>> findTripletWithSumZero(int[] input){
        HashSet<List<Integer>> triplets = new HashSet<List<Integer>>();
        for(int i=0;i<input.length;i++){
            for(int j=i+1;j<input.length;j++){
                for(int k=j+1; k<input.length;k++){
                    if((input[i]+input[j]+input[k])==0){
                        List<Integer> triplet = new ArrayList<Integer>();
                        triplet.add(input[i]);
                        triplet.add(input[j]);
                        triplet.add(input[k]);
                        triplets.add(triplet);
                    }
                }
            }
        }
        return triplets;
    }


    public static HashSet<List<Integer>> findTripletWithSumZero2(int[] input){
        HashSet<List<Integer>> triplets = new HashSet<List<Integer>>();
        HashMap<Integer,Object> map = new HashMap<Integer, Object>();
        Object dummy = new Object();

        for(int k=0;k<input.length;k++){
            map.put(input[k],dummy);
        }

        for(int i=0;i<input.length;i++){
            for(int j=i+1;j<input.length;j++){
                int key = input[i]+input[j];
                    if(map.containsKey((key*-1))){
                        List<Integer> triplet = new ArrayList<Integer>();
                        triplet.add(input[i]);
                        triplet.add(input[j]);
                        triplet.add((key*-1));
                        triplets.add(triplet);
                    }
                }
            }
        return triplets;
    }

    public static void main(String[] args) {

        int[] input= {-1, 0, 1, 2, -1, -4};
        System.out.println("inout is "+ Arrays.toString(input));
        System.out.println("triplets are "+ findTripletWithSumZero2(input));

        int[] input2= { 3,-1,-7,-4,-5,9,10};
        System.out.println("inout is "+ Arrays.toString(input2));
        System.out.println("triplets are "+ findTripletWithSumZero2(input2));

        int[] input3= {3, -1, -7, -4, -5, 9, 10,-2};
        System.out.println("inout is "+ Arrays.toString(input3));
        System.out.println("triplets are "+ findTripletWithSumZero2(input3));

    }

}
