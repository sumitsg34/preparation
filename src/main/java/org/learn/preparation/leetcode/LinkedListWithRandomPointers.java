package org.learn.preparation.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LinkedListWithRandomPointers {

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        // each node
        if (head == null) {
            return null;
        }

        Map<Node, Node> mapping = new HashMap<>();
        Node temp = head;
        while (temp != null) {
            Node cloned = new Node(temp.val);
            mapping.put(temp, cloned);
            temp = temp.next;
        }

        temp = head;
        while (temp != null) {
            Node cloned = mapping.get(temp);
            if (temp.next != null)
                cloned.next = mapping.get(temp.next);
            if (temp.random != null)
                cloned.random = mapping.get(temp.random);

            temp = temp.next;
        }
        return mapping.get(head);
    }

    public Node copyRandomList2(Node head) {
        // each node
        if (head == null) {
            return null;
        }

        Node temp = head;
        while (temp != null) {
            Node node = new Node(temp.val);
            Node next = temp.next;
            temp.next = node;
            node.next = next;
            temp = next;
        }

        Node curr = head.next;
        Node original = head; // original
        // origial -> clone -> original -> clone--> original...
        while (curr != null) {
            if (original.random != null)
                curr.random = original.random.next; // random's clone
            original = curr.next;
            if (original != null)
                curr.next = original.next;
            curr = curr.next;
        }
        return head.next;
    }
}
