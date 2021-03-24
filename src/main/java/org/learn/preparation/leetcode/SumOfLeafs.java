package org.learn.preparation.leetcode;

public class SumOfLeafs {

    int sum = 0;

    public int sumNumbers(TreeNode root) {
        findSum(root, root.val);
        return sum;
    }

    private void findSum(TreeNode root, int currentSum) {
        if (root.left == null && root.right == null)
            sum += currentSum;
        if (root.left != null) {
            findSum(root.left, currentSum * 10 + root.left.val);
        }
        if (root.right != null) {
            findSum(root.right, currentSum * 10 + root.right.val);
        }
    }


}
