package org.learn.preparation.leetcode;

import java.math.BigInteger;

public class MultiplyStrings {
    public static String multiply(String num1, String num2) {
        BigInteger bigInteger = new BigInteger(num1);
        bigInteger.multiply(new BigInteger(num2)).toString();
        return String.valueOf(Long.valueOf(num1)*Long.valueOf(num2));
    }
}
