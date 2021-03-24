package org.learn.preparation.sample;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Sample2 {

//    class Base {
//        protected void abc() {
//
//        }
//    }
//
//    class Der extends Base {
//        private void abc() {
//
//        }
//    }

    public void something1(long a) {

    }

    public void something1(Integer a) {
        System.out.println("long" + a);
    }

    public int abc() {
        try {
            return 1;
        } catch (Exception e) {
            return 2;
        } finally {
            return 3;
        }

    }

    interface base extends Base {

        static int sum() {
            return 0;
        }

    }

    class X implements base {

    }


    public static void main(String[] args) {

        StringBuilder v = new StringBuilder();
        v.append("aaa").insert(1, "bb").insert(4, "ccc");
        System.out.println(v);

        //Thread


    }

}
