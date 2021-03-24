package org.learn.preparation.leetcode;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    ListNode(int x, ListNode next) {
        val = x;
        this.next = next;
    }
}


/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {

    private void addRemaining(ListNode l, int carry, ListNode result) {
        do {
            int temp = l.val + carry;
            carry = temp / 10;
            ListNode x = new ListNode(temp % 10);
            result.next = x;
            result = x;
            l = l.next;
            if (l == null && carry != 0) {
                ListNode y = new ListNode(carry);
                result.next = y;
            }
        } while (l != null);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode first = l1;
        ListNode second = l2;
        int carry = 0;
        ListNode result = new ListNode(0);
        ListNode re = result;
        //99 1
        while (first != null && second != null) {
            int temp = first.val + second.val + carry;
            carry = temp / 10;

            ListNode x = new ListNode(temp % 10);
            result.next = x;
            result = x;

            if (first.next == null
                    && second.next == null) {
                if (carry != 0) {
                    ListNode y = new ListNode(carry);
                    result.next = y;
                }
                break;
            }

            if (second.next == null) {
                addRemaining(first.next, carry, result);
                break;
            }
            if (first.next == null) {
                addRemaining(second.next, carry, result);
                break;
            }
            first = first.next;
            second = second.next;
        }

        return re.next;
    }

    public static void main(String[] args) {

        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(4);
        n1.next = n2;
        ListNode n3 = new ListNode(3);
        n2.next = n3;

        ListNode m1 = new ListNode(9);
        ListNode m2 = new ListNode(9);
        m1.next = m2;
        ListNode m3 = new ListNode(4);
        m2.next = m3; //111  --> 321+918 = 1239

        ListNode re = new Solution().addTwoNumbers(n1, m1);
        do {
            System.out.print(re.val + " --> ");
            re = re.next;
        } while (re != null);


    }
}

