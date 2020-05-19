package org.learn.preparation.greeks;

import org.learn.preparation.Node;

public class BinaryTreeHeight {

    public int height(Node root) {
        int result = 1;
        if (root.left == null && root.right == null) {
            System.out.println(" h for " + root.value + " " + result);
            return result;
        } else {
            int lh = 0;
            if (root.left != null) {
                lh = height(root.left);
            }
            int rh = 0;
            if (root.right != null) {
                rh = height(root.right);
            }
            if (lh < rh) {
                result += rh;
            } else {
                result += lh;
            }
        }
        System.out.println(" h for " + root.value + " " + result);
        return result;
    }

    public static void main(String[] args) {
        Node root = new Node(30);
        root.left = new Node(28);
        root.right = new Node(31);

        root.right.right = new Node(35);

        root.left.left = new Node(21);
        root.left.right = new Node(22);
        root.left.right.left = new Node(25);

        System.out.println(" height: " + new BinaryTreeHeight().height(root));
    }
}
