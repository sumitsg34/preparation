package org.learn.preparation.leetcode;

import java.util.HashMap;
import java.util.Map;

public class RemoveDuplicatesFromSortedList {

    // 2ms
    public ListNode deleteDuplicates1(ListNode head) {

        ListNode curr = head;
        Map<Integer, Boolean> distinctNums = new HashMap<>();

        while (curr != null) {
            if (distinctNums.containsKey(curr.val)) {
                distinctNums.put(curr.val, false);
            } else {
                distinctNums.put(curr.val, true);
            }
            curr = curr.next;
        }

        curr = head;
        ListNode newHead = head;
        ListNode prev = head;

        while (curr != null) {
            if (!distinctNums.get(curr.val)) {
                if (curr.val == newHead.val) {
                    newHead = curr.next;
                    prev = curr.next;
                    curr = curr.next;
                    continue;
                }
                prev.next = curr.next;
            } else {
                prev = curr;
            }
            curr = curr.next;
        }
        return newHead;

    }

    // 1,1,1,2,5
    public ListNode deleteDuplicates2(ListNode head) {
        Map<Integer, Boolean> distinctNums = new HashMap<>();
        // recur -> curr, prev, map
        findAndDelete(head, head, distinctNums);
        return head;
    }

    // 1,2,3,3,4,4,5
    private void findAndDelete(ListNode curr, ListNode prev, Map<Integer, Boolean> distinct) {
        System.out.println("curr is " + curr.val + " prev is " + prev.val);
        if (distinct.containsKey(curr.val)) {
            distinct.put(curr.val, false);
        } else {
            distinct.put(curr.val, true);
        }
        if (curr.next != null) {
            findAndDelete(curr.next, curr, distinct);
        }

        System.out.println("recur: " + curr.val);
        if (!distinct.get(curr.val)) {
            System.out.println("inside: " + curr.val);
            prev.next = curr.next;
        }
    }

    public static void main(String[] args) {
        ListNode _5 = new ListNode(5);
        ListNode _4 = new ListNode(4, _5);
        ListNode _3 = new ListNode(4, _4);
        ListNode _2 = new ListNode(3, _3);
        ListNode _1 = new ListNode(3, _2);
        ListNode _0 = new ListNode(2, _1);
        ListNode head = new ListNode(1, _0);

        RemoveDuplicatesFromSortedList removeDuplicatesFromSortedList = new RemoveDuplicatesFromSortedList();
        removeDuplicatesFromSortedList.deleteDuplicates2(head);


    }


}
