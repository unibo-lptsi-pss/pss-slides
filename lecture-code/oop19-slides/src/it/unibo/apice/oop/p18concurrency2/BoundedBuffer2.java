package it.unibo.apice.oop.p18concurrency2;

import java.util.*;

public class BoundedBuffer2<Item> {

	private LinkedList<Item> buffer;
	private int max;
	
    public BoundedBuffer2(int size){
        buffer = new LinkedList<Item>();
        max = size;
    }
    
    public synchronized void put(Item item) throws InterruptedException {
    	while (buffer.size() == max){
    		wait();
    	}
    	buffer.add(item);
        notifyAll();
    }
    
    public synchronized Item get() throws InterruptedException {
    	while (buffer.isEmpty()){
    		wait();
    	}
        Item item = buffer.removeFirst();
        notifyAll();
        return item;
    }
}
