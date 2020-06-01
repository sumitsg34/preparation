package org.learn.preparation.datastructures;

import java.util.PriorityQueue;

public class PriorityQueueImpl {

    static class Student implements Comparable {
        int id;

        Student(int id) {
            this.id = id;
        }

        @Override
        public int compareTo(Object o) {
            if (this.id < ((Student) o).id)
                return -1;
            if (this.id == ((Student) o).id)
                return 0;
            return 1;
        }
    }

    public static void main(String[] args) {
        PriorityQueue<Student> queue = new PriorityQueue<>();

        queue.add(new Student(5));
        queue.add(new Student(1));
        queue.add(new Student(2));

        System.out.println("out:" + queue.poll().id);
        System.out.println("out:" + queue.poll().id);
        System.out.println("out:" + queue.poll().id);

    }

}
