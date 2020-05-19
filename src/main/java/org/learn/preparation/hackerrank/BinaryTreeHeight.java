package org.learn.preparation.hackerrank;

/**
 * https://www.hackerrank.com/challenges/tree-height-of-a-binary-tree/problem
 */
public class BinaryTreeHeight {

    static Node head;

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }


    public static int findHeight(Node root) {
        int hLeft = 1;
        if (root.left != null)
            hLeft += findHeight(root.left);

        int hRight = 1;
        if (root.right != null)
            hRight += findHeight(root.right);

        if (hLeft > hRight)
            return hLeft;
        return hRight;
    }


    public static int height(Node root) {
        int hLeft = 0;
        if (root.left != null)
            hLeft += findHeight(root.left);

        int hRight = 0;
        if (root.right != null)
            hRight += findHeight(root.right);

        if (hLeft > hRight)
            return hLeft;
        return hRight;
    }


    public void add(int newValue) {
        Node current = head;
        if (current == null) {
            head = new Node(newValue);
        } else {
            do {
                if (current.data > newValue) {
                    if (current.left == null) {
                        Node leftNode = new Node(newValue);
                        current.left = leftNode;
                        break;
                    } else {
                        current = current.left;
                    }
                } else {
                    if (current.right == null) {
                        Node rightNode = new Node(newValue);
                        current.right = rightNode;
                        break;
                    } else {
                        current = current.right;
                    }
                }
            } while (true);
        }
    }

    public void inOrder() {
        inOrder(head);
    }

    private void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.data + " ");
            inOrder(node.right);
        }
    }

    public static void main(String[] args) {

        BinaryTreeHeight b = new BinaryTreeHeight();
        //3 5 2 1 4 6 7
        b.add(3);
        b.add(5);
        b.add(2);

        b.add(1);
        b.add(4);
        b.add(6);
        b.add(7);
//        b.add(25);
//        b.add(12);
//        b.add(26);
//        b.add(33);
//
//        b.add(52);
//        b.add(58);
        b.inOrder();

        System.out.println("heigh: " + b.height(b.head));


    }


}
