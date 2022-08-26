package it.unibo.apice.oop.p18concurrency2;

public class SafeCounter implements CounterInterface {
	
	private long cont;
	
	public SafeCounter(){
	    cont = 0;
	}
	
	public synchronized void inc(){
		cont++;
	}
	
	public synchronized void dec(){
	    cont--;
	}
	
	public synchronized long getValue(){
	    return cont;
	}
}
