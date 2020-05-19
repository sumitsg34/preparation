package org.learn.preparation.greeks;

import java.util.Scanner;

/**
 *
 */
public class LinkedListMiddle {

    static class LinkedListNode {
        int value;
        LinkedListNode next;

        public LinkedListNode(int value) {
            this.value = value;
        }

        public LinkedListNode(int value, LinkedListNode next) {
            this.value = value;
            this.next = next;
        }

    }

    public static void getMiddleNode(LinkedListNode head) {
        LinkedListNode slow = head;
        LinkedListNode fast = head;
        // until fast reaches end
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        System.out.println("middle is :" + slow.value);
    }

    public static void add(int value, LinkedListNode head) {
        if (head == null) {
            head = new LinkedListNode(value);
        } else {
            LinkedListNode curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = new LinkedListNode(value);
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            LinkedListNode head = null;
            int n = sc.nextInt();
            System.out.println("reading next:" + n);
            while (n > 0) {
                int temp = sc.nextInt();
                add(temp, head);
                n--;
                System.out.println("read: " + temp);
            }
            getMiddleNode(head);
            t--;
        }

    }
}
