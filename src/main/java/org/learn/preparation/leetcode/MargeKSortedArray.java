package org.learn.preparation.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MargeKSortedArray {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    class ListNodeComparator implements Comparator<ListNode> {
        @Override
        public int compare(ListNode o1, ListNode o2) {
            if (o1.val < o2.val)
                return -1;
            if (o1.val > o2.val)
                return 1;
            return 0;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> queue = new PriorityQueue<>(new ListNodeComparator());

        for (ListNode node : lists) {
            queue.add(node);
        }

        ListNode mergedList = new ListNode(-1);
        ListNode temp = mergedList;
        while (!queue.isEmpty()) {
            ListNode smallestNode = queue.poll();
            ListNode cloned = new ListNode(smallestNode.val);
            temp.next = cloned;
            if (smallestNode.next != null)
                queue.add(smallestNode.next);
        }
        return mergedList.next;
    }

}

