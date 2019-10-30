package edu.northeastern.ashish;

public class Main {

    public static void main(String[] args){

        MinHeap minHeap = new MinHeap();
        minHeap.insert(5);
        minHeap.insert(7);
        minHeap.insert(1);
        minHeap.insert(9);
        minHeap.insert(3);
        minHeap.insert(11);
        minHeap.insert(-1);
        minHeap.insert(12);

        System.out.println("Smallest " + minHeap.getMin());
        minHeap.deleteMin();
        minHeap.deleteMin();
        System.out.println("Smallest " + minHeap.getMin());

    }
}
