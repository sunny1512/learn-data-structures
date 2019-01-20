package com.datastructures.heap;
import java.util.ArrayList; 
/*
 *   @author : Ashwani Tiwari
 *   @date    : 20-01-2019
 */
public class Heap < T extends Comparable<T> > {	
	private ArrayList<T> heap;
	int size ;
	public Heap() { 
			heap = new ArrayList<T>();
			size = 0;
	}
	private int getParent(int i ) {
		return i/2;
	}
	private void swap (int i,int j) {
		T temp = heap.get(i);
		heap.set(i, heap.get(j));
		heap.set(j, temp);
	}
	public void insert(T element) {
		size = size +1 ;
		heap.add(element);
		int i = size -1;
		while(i!=0 && heap.get(getParent(i)).compareTo(element)>0) {
				swap(getParent(i),i);
				i=getParent(i);
		}
	}
	public boolean isEmpty() {
			if(size>0) {
				return false;
			}
			return true;
	}
	public void removeTop() throws Exception{
			if(size == 0) {
				throw new Exception("No Element to remove");
			}
			size = size - 1;
			T last  = heap.get(size);
			heap.set(0, last);
			heap.remove(size);
			minHeapify(0);
	}
	private T getLeftChild(int parent) {
		return heap.get(2*parent+1);
	}
	private T getRightChild(int parent) {
		return heap.get(2*parent+2);
	}
	private void minHeapify(int current ) {	
		int minindex = current ;
		if(2*current+1< size && heap.get(minindex).compareTo(getLeftChild(current))>0) {
			minindex = 2*current + 1;
		}
		if(2*current+2<size && heap.get(minindex).compareTo(getRightChild(current))>0) {
			minindex = 2*current +2;
		}
		if(minindex != current ) {
			swap(current ,minindex);
			minHeapify(minindex);
		}
	}
	public T getTop() {
		return heap.get(0);
	}
}
