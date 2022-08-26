package it.unibo.apice.oop.p18concurrency2;

import java.util.LinkedList;
import java.util.concurrent.Semaphore;

public class BoundedBuffer<Item> {

	private LinkedList<Item> buffer;
	private Semaphore availItems;
	private Semaphore availPlaces;
	private Semaphore mutex;
	
	public BoundedBuffer(int size){
		buffer = new LinkedList<Item>();
		availItems = new Semaphore(0);
		availPlaces = new Semaphore(size);
		mutex= new Semaphore(1);
	}
	
	public void put(Item el) throws InterruptedException {
		availPlaces.acquire();
		mutex.acquire();
		buffer.add(el);
		mutex.release();
		availItems.release();
	}
	
	public Item take() throws InterruptedException  {
		availItems.acquire();
		mutex.acquire();
		Item el = buffer.removeFirst();
		mutex.release();
		availPlaces.release();
		return el;		
	}	
}
