package org.learn.preparation.hackerrank;

/*
 * https://www.hackerrank.com/challenges/equal-stacks/problem
 */
public class EqualStacks {

    private static int getSum(int[] stack, int start) {
        int sum = 0;
        for (; start < stack.length; start++) {
            sum += stack[start];
        }
        return sum;
    }

    private static boolean canBeEqual(int[] stack, int requiredSum) {

        for (int i = 0; i < stack.length; i++) {
            int sum = getSum(stack, i);
            if (sum < requiredSum)
                return false;
            if (sum == requiredSum)
                return true;
        }
        return false;
    }

    /*
     * Complete the equalStacks function below.
     */
    static int equalStacks(int[] h1, int[] h2, int[] h3) {

        for (int i = 0; i < h1.length; i++) {
            int requiredSum = getSum(h1, i);
            if (requiredSum > 0
                    && canBeEqual(h2, requiredSum)
                    && canBeEqual(h3, requiredSum)) {
                return requiredSum;
            }
        }

        for (int i = 0; i < h2.length; i++) {
            int requiredSum = getSum(h2, i);
            if (requiredSum > 0
                    && canBeEqual(h1, requiredSum)
                    && canBeEqual(h3, requiredSum)) {
                return requiredSum;
            }
        }

        for (int i = 0; i < h3.length; i++) {
            int requiredSum = getSum(h3, i);
            if (requiredSum > 0
                    && canBeEqual(h2, requiredSum)
                    && canBeEqual(h1, requiredSum)) {
                return requiredSum;
            }
        }

        return 0;

    }

    public static void main(String[] args) {
        int[] a = {3, 2, 1, 1, 1};
        int[] b = {4, 3, 2};
        int[] c = {1, 1, 4, 1};
        System.out.println(EqualStacks.equalStacks(a, b, c));
    }


}
