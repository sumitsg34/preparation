package org.learn.preparation.hackerrank;

/**
 * https://www.hackerrank.com/challenges/bigger-is-greater/problem
 */
public class BiggerIsGreater {

    // Complete the biggerIsGreater function below.
    static String biggerIsGreater(String w) {
        char[] input = w.toCharArray();
        int pivot = w.length() - 1;
        while (pivot > 0) {
            //dkhc
            if (w.charAt(pivot) > w.charAt(pivot - 1)) {
                pivot--;
                break;
            }
            pivot--;
        }

        // find the lowest higher than pivot
        int higher = pivot + 1;
        while (higher <= w.length() - 1) {
            if (w.charAt(pivot) <= w.charAt(higher)) {
                higher++;
            } else {
                higher--;
                break;
            }
        }
        char temp = input[pivot];
        input[pivot] = input[higher];
        input[higher] = temp;

        String out = "";
        if (pivot == 0) {
            out = String.valueOf(input[pivot]);
        } else {
            out = w.substring(0, pivot - 1) + input[pivot];
        }

        for (int i = w.length() - 1; i > pivot; i--) {
            out += input[i];
        }

        return out;
    }

    public static void main(String[] args) {
        biggerIsGreater("dkhc");
    }
}
