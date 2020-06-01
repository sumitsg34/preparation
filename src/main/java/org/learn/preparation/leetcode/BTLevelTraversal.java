package org.learn.preparation.leetcode;

import java.util.ArrayList;
import java.util.List;

public class BTLevelTraversal {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        bfs(root, 0);
        return list;
    }

    private void bfs(TreeNode root, int level) {
        if (root.left != null)
            bfs(root.left, level + 1);
        if (root.right != null)
            bfs(root.right, level + 1);
        if (list.size() <= level) {
            int temp = level + 1;
            int size = list.size();
            while (temp > size) {
                list.add(new ArrayList<>());
                temp--;
            }
        }
        list.get(level).add(root.val);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);

        BTLevelTraversal btLevelTraversal = new BTLevelTraversal();
        System.out.println(btLevelTraversal.levelOrder(treeNode));
    }

}
