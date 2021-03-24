package org.learn.preparation.interviewbit;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PickFromBothSides {

    public static int solve(ArrayList<Integer> A, int B) {

        int left = 0;
        int right = A.size() - 1;
        int sum = 0;
        int i = 0;
        List<Integer> list = new ArrayList<>();
        //list.add(1.2);
        while (i < B && left < A.size() - 1 && right > 0) {
            if (A.get(left) <= A.get(right)) {
                System.out.println(A.get(right));
                sum += A.get(right);
                list.add(right);
                right--;
            } else {
                System.out.println(A.get(left));
                sum += A.get(left);
                list.add(left);
                left++;
            }

            i++;
        }

        String s = null;
        System.out.println(s);
        return sum;

    }

    public static void main(String[] args) {

//        int[] A = {5, -2, 3 , 1, 2};
//        ArrayList<Integer> integers = new ArrayList<>();
//        IntStream.of(A).forEach(a -> integers.add(a));

    }

}
