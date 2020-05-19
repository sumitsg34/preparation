package org.learn.preparation.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * https://leetcode.com/problems/reorder-data-in-log-files/
 */
public class ReorderLogs {

    class LogComparator implements Comparator<String> {

        @Override
        public int compare(String o1, String o2) {
            String[] token1 = o1.split(" ");

            String firstLog = o1.substring(token1[0].length() + 1);

            String[] token2 = o2.split(" ");
            String secondLog = o2.substring(token2[0].length() + 1);

            int result = firstLog.compareTo(secondLog);
            if (result == 0) {
                return token1[0].compareTo(token2[0]);
            }
            return result;
        }

    }

    public String[] reorderLogFiles(String[] logs) {

        List<String> digitLogs = new ArrayList<>();
        List<String> dataLogs = new ArrayList<>();

        for (int i = 0; i < logs.length; i++) {
            String[] tokens = logs[i].split(" ");
            try {
                int num = Integer.parseInt(String.valueOf(tokens[1].charAt(0)));
                digitLogs.add(logs[i]);
            } catch (Exception ex) {
                dataLogs.add(logs[i]);
            }
        }

        Collections.sort(dataLogs, new LogComparator());
        dataLogs.addAll(digitLogs);
        return dataLogs.toArray(new String[logs.length]);
    }

    public static void main(String[] args) {
        String[] logs = {
                "6p tzwmh ige mc", "ns 566543603829", "ubd cujg j d yf", "ha6 1 938 376 5", "3yx 97 666 56 5", "d 84 34353 2249", "0 tllgmf qp znc", "s 1088746413789", "ys0 splqqxoflgx", "uhb rfrwt qzx r", "u lrvmdt ykmox", "ah4 4209164350", "rap 7729 8 125", "4 nivgc qo z i", "apx 814023338 8"
        };
        System.out.println(Arrays.toString(new ReorderLogs().reorderLogFiles(logs)));
    }


}
