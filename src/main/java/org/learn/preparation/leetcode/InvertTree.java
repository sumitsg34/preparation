package org.learn.preparation.leetcode;

public class InvertTree {

    public TreeNode invertTree(TreeNode root) {

        if (root == null)
            return root;
        return invert(root);

    }

    /**
     * 4
     * /   \
     * 2     7
     * / \   / \
     * 1   3 6   9
     */
    private TreeNode invert(TreeNode root) {
        if (root.right == null && root.left == null) {
            return root;
        }
        if (root.left != null) {
            invertTree(root.left);
        }
        if (root.right != null) {
            invertTree(root.right);
        }
        //interchange nodes
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = right;
        root.right = left;
        return root;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(4);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(7);

        treeNode.left.left = new TreeNode(1);
        treeNode.left.right = new TreeNode(3);

        treeNode.right.left = new TreeNode(6);
        treeNode.right.right = new TreeNode(9);

        InvertTree invertTree = new InvertTree();
        TreeNode invertedd = invertTree.invertTree(treeNode);
        System.out.println("done");
    }
}
