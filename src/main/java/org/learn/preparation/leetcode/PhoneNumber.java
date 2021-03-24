package org.learn.preparation.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneNumber {

    public List<String> letterCombinations(String digits) {

        Map<Character, String> mapping = new HashMap<>();
        mapping.put('2', "abc");
        mapping.put('3', "def");
        mapping.put('4', "ghi");
        mapping.put('5', "jkl");
        mapping.put('6', "mno");
        mapping.put('7', "pqrs");
        mapping.put('8', "tuv");
        mapping.put('9', "wxyz");

        List<String> out = new ArrayList<>();
        List<String> inputs = new ArrayList<>();
        for (int i = 0; i < digits.length(); i++)
            inputs.add(mapping.get(digits.charAt(i)));

        if (inputs.size() == 1) {
            String first = inputs.get(0);
            for (int i = 0; i < first.length(); i++) {
                out.add(first.charAt(i) + "");
            }
        }

        for (int i = 0; i < inputs.size() - 1; i++) {
            String first = inputs.get(i);
            for (int j = 1; j < inputs.size(); j++) {
                String second = inputs.get(j);
                for (int p = 0; p < first.length(); p++)
                    for (int q = 0; q < second.length(); q++) {
                        String s = first.charAt(p) + "" + second.charAt(q) + "";
                        out.add(s);
                    }
            }
        }

        return out;

    }

    public static void main(String[] args) {
        PhoneNumber phoneNumber = new PhoneNumber();
        System.out.println(phoneNumber.letterCombinations("23"));
    }


}
