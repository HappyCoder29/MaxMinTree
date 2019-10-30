package edu.northeastern.ashish;

import java.util.LinkedList;
import java.util.List;

public class MinHeap {

    private List<Integer> list;
    private int heapSize;

    public MinHeap(){
        list = new LinkedList<Integer>();
        heapSize = 0;
    }

    public int getMin(){

        if(isEmpty())
            return  Integer.MAX_VALUE;

        return  list.get(0);

    }

    public boolean isEmpty(){
        return  heapSize == 0;
    }

    private int getLeftChild(int i){
        return  2*i + 1;
    }
    private int getRightChild(int i){
        return  2*i + 2;
    }

    private int getParent(int i){
        return  (i-1)/2;
    }

    public void insert(int value){

        heapSize ++;
        list.add(value);
        siftUp(heapSize -1);
    }

    private void siftUp(int index){
        int parent, temp;
        if(index == 0){
            return;
        }
        parent = getParent(index);

        if(list.get(parent) >list.get(index)){
            // swap values and call sift again
            temp = list.get(parent);
            list.set(parent, list.get(index));
            list.set(index, temp);

            siftUp(parent);
        }
    }

    public void deleteMin(){
        if(isEmpty())
            return;
        list.set(0, list.get(heapSize-1));

        heapSize --;
        if(heapSize > 0)
            siftDown(0);
    }

    private void siftDown(int index){
        int leftChild, rightChild, minIndex, temp;
        leftChild = getLeftChild(index);
        rightChild = getRightChild(index);

        if(rightChild >= heapSize){
            //either there is no child for this node
            // or there is just one child i.e. left child
            if(leftChild >= heapSize)
                return; // this node does not have any child
            else{
                minIndex = leftChild;
            }
        }
        else{
            // we have both left as well as right child
            if( list.get(leftChild) < list.get(rightChild) ){
                minIndex = leftChild;
            }else{
                minIndex = rightChild;
            }
        }
        // we know which one is the min index and we will copmpare this with our current index
        if(list.get(index) > list.get(minIndex) ){
            // swap values and call siftDown

            temp = list.get(index);
            list.set(index, list.get(minIndex));
            list.set(minIndex, temp);

            siftDown(minIndex);
        }

    }// end of sift down

}// end of class Minheap
