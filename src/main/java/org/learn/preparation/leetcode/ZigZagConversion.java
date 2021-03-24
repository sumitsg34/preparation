package org.learn.preparation.leetcode;

import com.sun.xml.internal.ws.policy.privateutil.LocalizationMessages;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/zigzag-conversion/
public class ZigZagConversion {

    public static String convert(String s, int numRows) {

        Map<Integer, StringBuilder> rows = new HashMap<>();

        int row = 0; // this is a shifter
        int i = 0; // this is a iterator
        boolean incremental = true;

        while (i < s.length()) {

            StringBuilder rowBuilder = rows.getOrDefault(row, new StringBuilder());
            rowBuilder.append(s.charAt(i));
            rows.put(row, rowBuilder);

            if (row == numRows - 1)
                incremental = false;
            else if (row == 0)
                incremental = true;

            if (incremental) {
                row++;
            } else if (row > 0) {
                row--;
            }
            i++;
        }

        StringBuilder out = new StringBuilder();
        for (i = 0; i < numRows; i++) {
            out.append(rows.getOrDefault(i, new StringBuilder()));
        }
        return out.toString();
    }

    public static void main(String[] args) {
//        String out = ;
        System.out.println("PINALSIGYAHRPI".equals(convert("PAYPALISHIRING", 4)));

        String out = convert("AB", 1);
        System.out.println("AB".equals(out));

    }
}
