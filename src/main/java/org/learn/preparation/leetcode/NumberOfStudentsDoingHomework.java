package org.learn.preparation.leetcode;

public class NumberOfStudentsDoingHomework {

    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int noOfStudent = 0;
        for (int i = 0; i < endTime.length; i++) {
            if (endTime[i] >= queryTime && startTime[i] <= queryTime) {
                noOfStudent++;
            }
        }
        return noOfStudent;
    }

    public static void main(String[] args) {
        NumberOfStudentsDoingHomework numberOfStudentsDoingHomework = new NumberOfStudentsDoingHomework();
//        int[] startTime = {1, 2, 3};
//        int[] endTime = {3, 2, 7};
//        int queryTime = 4;

        int[] startTime = {4};
        int[] endTime = {4};
        int queryTime = 4;

        System.out.println("out:" +
                numberOfStudentsDoingHomework.busyStudent(startTime, endTime, queryTime));
    }


}
