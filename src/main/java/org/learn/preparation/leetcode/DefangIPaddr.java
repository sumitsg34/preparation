package org.learn.preparation.leetcode;

import java.util.Date;

public class DefangIPaddr {

    public static String defangIPaddr(String address) {
        long start = new Date().toInstant().toEpochMilli();
        String o1 = address.replaceAll("\\.", "[\\.]");
        System.out.println("o1: " + o1 + " time take by replaceAll :" + (new Date().toInstant().toEpochMilli() - start));

        long start2 = new Date().toInstant().toEpochMilli();
        String o2 = address.replace(".", "[.]");
        System.out.println("o2: " + o2 + " time take by replaceAll :" + (new Date().toInstant().toEpochMilli() - start2));


        long start3 = new Date().toInstant().toEpochMilli();
        char[] updated = new char[address.length() + 6];
        int c = 0;
        for (int i = 0; i < address.length(); i++) {
            if (Character.isDigit(address.charAt(i))) {
                updated[c] = address.charAt(i);
            } else {
                updated[c] = '[';
                c++;
                updated[c] = '.';
                c++;
                updated[c] = ']';
            }
            c++;
        }

        System.out.println("o3: " + new String(updated) + " time take by replaceAll :" + (new Date().toInstant().toEpochMilli() - start3));
        return address;
    }

    public static void main(String[] args) {
        defangIPaddr("1.1.1.1");
    }
}
