package org.learn.preparation.leetcode;

public class NodesInCompleteBinaryTree {

    /**
     * @param root
     * @return
     */
    public int countNodes(TreeNode root) {
        /**
         *  In a complete binary tree, left most node will decide the height of
         *  the tree
         */
        int heightOfTheTree = findHeightOfCompleteBST(root);

        /**
         * 2^h -1
         */
        if (heightOfTheTree > 0) {
            Double d = Math.pow(2, heightOfTheTree - 1);
            return (d.intValue()) - 1;
        }
        return 0;
    }

    /**
     * a
     * b   c
     * e  f
     */
    private int findHeightOfCompleteBST(TreeNode root) {
        if (root.left == null)
            return 1;
        return findHeightOfCompleteBST(root.left) + 1;
    }
}
