package org.learn.preparation.theory;

import java.util.ArrayList;
import java.util.List;

class MyData {

    static List<String> names = new ArrayList<>();

    public static void add() {
        //synchronized (names) {
            try {
                System.out.println("adding...");
                names.add("summeet");
                System.out.println("added");
                names.notifyAll();
            } catch (Exception e) {
                e.printStackTrace();
            }
        //}
    }

    public static void remove() {
        //synchronized (names) {
            try {
                System.out.println("removing...");
                names.wait();
                names.remove(0);
                System.out.println("done removing...");
            } catch (Exception e) {
                e.printStackTrace();
            }
        //}
    }

}

class MyThread implements Runnable {
    @Override
    public void run() {
        MyData.add();
    }
}

class MyThread2 implements Runnable {
    @Override
    public void run() {
        MyData.remove();
    }
}

public class MultiThreading {

    public static void main(String[] args) {
        try {
            MyThread2 t2 = new MyThread2();
            t2.run();
            System.out.println("running t2");
            MyThread t1 = new MyThread();
            t1.run();
            System.out.println("executed threads");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
