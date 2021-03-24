package org.learn.preparation.leetcode;

public class RotateLinkedList {

    public ListNode rotateRight(ListNode head, int k) {
        ListNode oldHead = head;
        ListNode newHead = null;
        findNextNodes(oldHead, newHead, head, k);
        return newHead;
    }

    //[1,2,3,4,5]  k=1
    private int findNextNodes(ListNode curr, ListNode updatedHead, ListNode oldHead, int k) {

        if (curr.next == null) {
            curr.next = oldHead;
            return k - 1;
        }

        int n = findNextNodes(curr.next, updatedHead, oldHead, k);
        if (n == 0) {
            updatedHead = curr;
            curr.next = null;
            return -1;
        }
        return n == -1 ? -1 : n - 1;
    }


}
