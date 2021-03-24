package org.learn.preparation.leetcode;

import java.util.*;

public class LeastRecentlyUsedCache {

    private Map<Integer, Integer> cache;
    private List<Integer> keys;
    int capacity;

    public LeastRecentlyUsedCache(int capacity) {
        cache = new HashMap(capacity);
        keys = new ArrayList<>(capacity);
        this.capacity = capacity;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            if (keys.size() > 0)
                keys.remove(new Integer(key));
            keys.add(0,key);
            return cache.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        if (capacity == cache.size()) {
            int leastRecentlyUsedKey = keys.remove(capacity - 1);
            cache.remove(leastRecentlyUsedKey);
        }
        keys.add(0, key);
        cache.put(key, value);
    }

    public static void main(String[] args) {
        LeastRecentlyUsedCache cache = new LeastRecentlyUsedCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println("value:" + cache.get(1));       // returns 1
        cache.put(3, 3);    // evicts key 2
        System.out.println("value:" + cache.get(2));       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        System.out.println("value:" + cache.get(1));       // returns -1 (not found)
        System.out.println("value:" + cache.get(3));       // returns 3
        System.out.println("value:" + cache.get(4));       // returns 4
    }

}
