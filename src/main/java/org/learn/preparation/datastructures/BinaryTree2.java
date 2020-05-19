package org.learn.preparation.datastructures;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTree2 {

    Node head;

    class Node {
        int value;
        Node right;
        Node left;

        Node(int a) {
            this.value = a;
        }
    }

    public void add(int num) {
        if (head == null) {
            head = new Node(num);
        } else {
            Node current = head;
            while (current != null) {
                if (num < current.value) {
                    // left
                    Node left = current.left;
                    if (left == null) {
                        left = new Node(num);
                        current.left = left;
                        break;
                    } else {
                        current = left;
                    }
                } else {
                    Node right = current.right;
                    if (right == null) {
                        right = new Node(num);
                        current.right = right;
                        break;
                    } else {
                        current = current.right;
                    }
                }
            }
        }
    }

    public void inOrder() {
        inOrder(head);
    }

    private void inOrder(Node n) {
        if (n != null) {
            inOrder(n.left);
            System.out.print(n.value + " ");
            inOrder(n.right);
        }
    }

    public void preOrder() {
        preOrder(head);
    }

    private void preOrder(Node n) {
        if (n != null) {
            System.out.print(n.value + " ");
            preOrder(n.left);
            preOrder(n.right);
        }
    }

    public void bfs() {
        List<Node> stack = new ArrayList<>();
        stack.add(head);
        while (!stack.isEmpty()) {
            Node curr = stack.remove(0);
            System.out.print(curr.value + " ");
            if (curr.left != null)
                stack.add(curr.left);
            if (curr.right != null)
                stack.add(curr.right);
        }
    }

    public static void main(String[] args) {
        BinaryTree2 bst = new BinaryTree2();
//        bst.add(15);
//        bst.add(10);
//        bst.add(5);
//        bst.add(8);
//        bst.add(17);
//        bst.add(25);
//        bst.add(30);
//        bst.add(55);
//        bst.add(21);
//        bst.add(19);

        bst.add(100);
        bst.add(20);
        bst.add(200);
        bst.add(10);
        bst.add(30);
        bst.add(150);
        bst.add(300);

        bst.inOrder();
        System.out.println();

        bst.inOrder();
        System.out.println();
//
//        bst.bfs();
//        System.out.println();

    }


}
