package org.learn.preparation.leetcode;

import java.util.*;

public class RandomizedSet {
    Map<Integer, Integer> set = new HashMap<>();
    List<Integer> keys = new ArrayList<>();
    Random random = new Random();

    /**
     * Initialize your data structure here.
     */
    public RandomizedSet() {

    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (!set.containsKey(val)) {
            set.put(val, keys.size());
            keys.add(val);
            return true;
        }
        return false;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (set.containsKey(val)) {

            // key delete
            int valIndex = set.get(val);

            // swap last element with deleted key
            int lastElement = keys.get(keys.size() - 1);
            keys.set(valIndex, lastElement);
            set.put(lastElement, valIndex);
            keys.remove(keys.size() - 1);
            set.remove(val);
            return true;
        }
        return false;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        if (keys.size() == 0) {
            return 0;
        }
        return keys.get(random.nextInt(keys.size()));
    }

    public static void main(String[] args) {

        System.out.println("-" + 2 % 1);
        System.out.println("-" + 1 % 2);


        RandomizedSet randomizedSet = new RandomizedSet();
//        randomizedSet.insert(0);
//        randomizedSet.insert(1);
//        randomizedSet.remove(0);
//        randomizedSet.insert(2);
//        randomizedSet.remove(1);
//        System.out.println(randomizedSet.getRandom());  //2

        randomizedSet.remove(0);
        randomizedSet.remove(0);
        randomizedSet.insert(0);
        System.out.println(randomizedSet.getRandom());
        randomizedSet.remove(0);
        randomizedSet.insert(0);

    }
}
