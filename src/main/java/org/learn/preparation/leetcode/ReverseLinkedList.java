package org.learn.preparation.leetcode;

public class ReverseLinkedList {

    //recursion
    ListNode updatedHead = new ListNode(-1);

    // 1 2 3 4 5
    public ListNode reverseList(ListNode head) {
        reverse(head);
        head.next = null;
        return updatedHead;
    }

    private ListNode reverse(ListNode head) {
        if (head == null)
            return null;
        if (head.next != null) {
            //5 4
            ListNode node = reverse(head.next);
            node.next = head;
            return node.next;
        } else {
            updatedHead = head;
            return head;
        }
    }

    public static void main(String[] args) {

        ListNode l5 = new ListNode(5);

        ListNode l4 = new ListNode(4);
        l4.next = l5;

        ListNode l3 = new ListNode(3);
        l3.next = l4;

        ListNode l2 = new ListNode(2);
        l2.next = l3;

        ListNode l1 = new ListNode(1);
        l1.next = l2;

        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        ListNode ll = reverseLinkedList.reverseList(l1);

        while (ll != null) {
            System.out.println(ll.val + " - ");
            ll = ll.next;
        }

    }


}
