package it.unibo.apice.oop.p18concurrency2;

public class Counter implements CounterInterface {
	
	private long cont;
	
	public Counter(){
	    cont = 0;
	}
	
	public void inc(){
		cont++;
	}
	
	public void dec(){
	    cont--;
	}
	
	public long getValue(){
	    return cont;
	}
}
