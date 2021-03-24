package org.learn.preparation.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneNumberCombination {

    String inputDigits;
    Map<Character, String> mapping = new HashMap<Character, String>() {{
        mapping.put('2', "abc");
        mapping.put('3', "def");
        mapping.put('4', "ghi");
        mapping.put('5', "jkl");
        mapping.put('6', "mno");
        mapping.put('7', "pqrs");
        mapping.put('8', "tuv");
        mapping.put('9', "wxyz");
    }};
    List<String> out = new ArrayList<>();

    public List<String> letterCombinations(String digits) {

        if (digits.length() == 0) {
            return new ArrayList<>();
        }
        //mapping = new HashMap<>();
        this.inputDigits = digits;

        // get first no's mapping
        String first = mapping.get(digits.charAt(0));
        for (char digit : first.toCharArray()) {
            buildLetterCombination(digit + "", 0);
        }

        return out;
    }

    private void buildLetterCombination(String combination, int index) {
        // 123
        if (index >= inputDigits.length() - 1) {
            out.add(combination);
            return;
        }

        //combine next letter
        String digits = mapping.get(inputDigits.charAt(index + 1));
        for (char digit : digits.toCharArray()) {
            buildLetterCombination(combination + digit + "", index + 1);
        }
    }

    public static void main(String[] args) {
        PhoneNumberCombination phoneNumberCombination = new PhoneNumberCombination();
        System.out.println();
        System.out.println(phoneNumberCombination.letterCombinations("234"));
        System.out.println();
    }
}
