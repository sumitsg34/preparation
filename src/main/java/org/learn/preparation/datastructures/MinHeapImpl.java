package org.learn.preparation.datastructures;

public class MinHeapImpl {

    //initial capacity
    int[] data = new int[10];
    int head = -1; // always point at the end and will hold least element

    //list element at the start


    void display() {
        for (int i = 0; i <= head; i++) {
            System.out.print(data[i] + " ");
        }
    }

    // delete -- delete and shift element



    public static void main(String[] args) {
        MinHeapImpl minHeap = new MinHeapImpl();
//        minHeap.add(50);
//        minHeap.add(60);
//        minHeap.add(34);
//        minHeap.display();
//        System.out.println("removed: " + minHeap.poll());
//        minHeap.display();
//        minHeap.add(12);
//        minHeap.add(90);
//        minHeap.display();
//        System.out.println("removed: " + minHeap.poll());
//        minHeap.display();
//        System.out.println("removed: " + minHeap.poll());
//        minHeap.display();
//        System.out.println("removed: " + minHeap.poll());
//        minHeap.display();
    }

}
