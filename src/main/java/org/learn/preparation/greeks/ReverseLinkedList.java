package org.learn.preparation.greeks;

import java.util.Stack;

public class ReverseLinkedList {

    static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    static Node reverseList(Node head) {
        // add code here
        if (head == null) {
            return head;
        }

        Stack<Node> stack = new Stack<>();
        Node curr = head;
        while (curr != null) {
            stack.push(curr);
            curr = curr.next;
        }
        Node newHead = stack.pop();
        Node currH = newHead;
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            node.next = null;

            currH.next = node;
            currH = node;
        }
        return newHead;
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(4);
        node.next.next.next.next = new Node(5);

        Node head = reverseList(node);
        while (head != null) {
            System.out.print(head.value + "->");
            head = head.next;
        }
    }
}
