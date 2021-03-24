package org.learn.preparation;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.*;

public class Test {

    public static Integer add() {
//        OffsetDateTime utc = OffsetDateTime.now(ZoneOffset.UTC);
//        System.out.println(Date.from(utc.toInstant()));

        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);
        map.put(2, 1);
        map.put(3, 1);
        map.put(4, 1);
        map.put(5, 1);
        map.put(6, 1);

        Set<Integer> set = new HashSet<>();
        for (Integer i : set) {
            System.out.println(i);
        }

        Set<Integer> set2 = new HashSet<>();
        for (Integer i : set2) {
            System.out.println(i);
        }

        Set<Integer> set3 = new HashSet<>();
        for (Integer i : set3) {
            System.out.println(i);
        }

        return 0;
    }

    public static void main(String[] args) {
        System.out.println(add());
    }
}
