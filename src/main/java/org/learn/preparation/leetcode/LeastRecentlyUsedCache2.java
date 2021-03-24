package org.learn.preparation.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LeastRecentlyUsedCache2 {

    Node head;
    Node tail;
    int capacity;
    Map<Integer, Node> cache;

    class Node {
        Node prev;
        Node next;
        int value;
        int key;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public LeastRecentlyUsedCache2(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>(capacity);
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            delete(node);
            offer(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (capacity <= cache.size()) {
            // we should the least used node
            cache.remove(head.key);
            delete(head);
        }
        Node node = new Node(key, value);
        offer(node);
        cache.put(key, node);
    }

    private void delete(Node node) {
        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            head = node.next;
        }

        if (node.next != null) {
            node.next.prev = node.prev;
        } else {
            tail = node.prev;
        }
    }

    private void offer(Node node) {
        if (tail != null) {
            tail.next = node;
        }
        node.prev = tail;
        node.next = null; // we dont need this
        tail = node;
        if (head == null) {
            head = tail;
        }
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LeastRecentlyUsedCache2 cache = new LeastRecentlyUsedCache2(2);
        cache.put(1, 1);
        cache.display();
        cache.put(2, 2);
        cache.display();
        System.out.println("value:" + cache.get(1));       // returns 1
        cache.display();
        cache.put(3, 3);
        cache.display();// evicts key 2
        System.out.println("value:" + cache.get(2));       // returns -1 (not found)
        cache.display();
        cache.put(4, 4);    // evicts key 1
        cache.display();
        System.out.println("value:" + cache.get(1));       // returns -1 (not found)
        cache.display();
        System.out.println("value:" + cache.get(3));       // returns 3
        cache.display();
        System.out.println("value:" + cache.get(4));       // returns 4
        cache.display();
    }

}
