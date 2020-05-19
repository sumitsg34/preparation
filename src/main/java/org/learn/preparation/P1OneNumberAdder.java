package org.learn.preparation;

import java.util.Arrays;

/**
 * https://www.tuturself.com/posts/view?menuId=82&postId=1539
 *
 * Given a non-empty array of digits representing a non-negative
 * integer, add 1 to the number (increment the number represented
 * by the digits ).
 * The digits are stored such that the most significant digit is at
 * the head of the list, and each element in the array contain a single
 * digit.
 * We may assume the integer does not contain any leading zero,
 * except the number 0 itself.
 *
 *
 * Input  : [1,2,3]
 * Output : [1,2,4]
 * Explanation: The input array represents the integer 123. So, (123+1) =124
 */
public class P1OneNumberAdder {

    public static int[] addOneToInput(int[] input) {

        int initialAddition = input[input.length - 1] + 1;
        int carry = initialAddition >= 10 ? 1 : 0;

        if (carry == 0) {
            input[input.length - 1] = initialAddition;
            return input;
        } else {
            int[] output = new int[input.length];
            output[input.length - 1] = initialAddition%10;
            for (int i = input.length - 2; i >= 0; i--) {
                int addition = input[i] + carry;
                carry = addition >= 10 ? 1 : 0;
                output[i] = addition % 10;
            }
            if (carry == 1) {
                int[] finalOutput = new int[input.length+1];
                finalOutput[0]=carry;
                for(int i=1;i<input.length;i++){
                    finalOutput[i]=output[i-1];
                }
                return finalOutput;
            }
            return output;
        }

    }

    public static void main(String[] args) {
        int[] input = {1, 2, 0};
        System.out.println("Input is " + Arrays.toString(input));
        int[] output = addOneToInput(input);
        System.out.println("Output is " + Arrays.toString(output));

        int[] input1 = {1, 5, 9};
        System.out.println("Input is " + Arrays.toString(input1));
        output = addOneToInput(input1);
        System.out.println("Output is " + Arrays.toString(output));

        int[] input2 = {1, 9, 9};
        System.out.println("Input is " + Arrays.toString(input2));
        output = addOneToInput(input2);
        System.out.println("Output is " + Arrays.toString(output));

        int[] input3 = {8, 9, 9};
        System.out.println("Input is " + Arrays.toString(input3));
        output = addOneToInput(input3);
        System.out.println("Output is " + Arrays.toString(output));

        int[] input4 = {9, 9, 9};
        System.out.println("Input is " + Arrays.toString(input4));
        output = addOneToInput(input4);
        System.out.println("Output is " + Arrays.toString(output));

    }

}
