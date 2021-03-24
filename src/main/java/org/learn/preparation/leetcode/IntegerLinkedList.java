package org.learn.preparation.leetcode;

class Node {
    int val;
    Node next;

    public Node(int x) {
        this.val = x;
    }
}

public class IntegerLinkedList {

    private Node head;


    /**
     * 1-5-9-14     6
     * 3-6-8-10     1
     * 1-3-5-6      7
     */
    public void insert(int x) {
        if (head == null) {
            head = new Node(x);
        } else {
            // reach till a point where x is less than curr
            Node prev = null;
            Node curr = head;
            while (curr != null) {
                if (curr.val > x) {
                    break;
                }
                prev = curr;
                curr = curr.next;
            }
            // so here, prev < x < curr
            Node nodeToBeInserted = new Node(x);
            nodeToBeInserted.next = curr;

            // this is for handling case where new value is added at beginning
            if (head == curr) {
                head = nodeToBeInserted;
            } else {
                prev.next = nodeToBeInserted;
            }
        }
    }


    public void display() {
        Node node = head;
        while (node != null) {
            System.out.print(node.val + "->");
            node = node.next;
        }
        System.out.println();

    }

    public static void main(String[] args) {
        IntegerLinkedList list = new IntegerLinkedList();
        list.insert(10);
        list.display();
        list.insert(20);
        list.display();
        list.insert(30);
        list.display();
        list.insert(40); // insert at the end
        list.display();
        list.insert(25); // insert anywhere but not at the start or the end
        list.display();
        list.insert(5);  // insert at the start
        list.display();
    }
}
