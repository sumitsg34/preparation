package org.learn.preparation.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pathForP = new ArrayList<>();
        findNodeUsingBackTrack(root, p, pathForP);

        for (int i = pathForP.size() - 1; i >= 0; i++) {
            TreeNode curr = pathForP.remove(i);
            if (isNodeReachable(curr, q)) {
                return curr;
            }
        }
        return null;
    }

    private boolean isNodeReachable(TreeNode root, TreeNode q) {
        if (root == null)
            return false;

        if (root == q) {
            return true;
        }

        boolean left = false;
        if (root.left != null) {
            left = isNodeReachable(root.left, q);
        }
        boolean right = false;
        if (root.right != null) {
            right = isNodeReachable(root.right, q);
        }

        if (!left && !right)
            return false;

        return left || right;

    }

    private boolean findNodeUsingBackTrack(TreeNode root, TreeNode target, List<TreeNode> path) {

        if (root == null)
            return false;

        path.add(root);

        if (root == target) {
            return true;
        }

        boolean left = false;
        if (root.left != null) {
            left = findNodeUsingBackTrack(root.left, target, path);
        }
        boolean right = false;
        if (root.right != null) {
            right = findNodeUsingBackTrack(root.right, target, path);
        }

        if (!left && !right)
            path.remove(root);

        return left || right;
    }

    public static void main(String[] args) {


        TreeNode node7 = new TreeNode(7);
        TreeNode node4 = new TreeNode(4);

        TreeNode node6 = new TreeNode(6);
        TreeNode node2 = new TreeNode(2);
        node2.left = node7;
        node2.right = node4;


        TreeNode node5 = new TreeNode(5);
        node5.left = node6;
        node5.right = node2;

        TreeNode node0 = new TreeNode(0);
        TreeNode node8 = new TreeNode(8);
        TreeNode node1 = new TreeNode(1);
        node1.right = node8;
        node1.left = node0;


        TreeNode root = new TreeNode(3);
        root.left = node5;
        root.right = node1;

        LowestCommonAncestor lowestCommonAncestor = new LowestCommonAncestor();

        lowestCommonAncestor.lowestCommonAncestor(root, node5, node4);


    }

}
