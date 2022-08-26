package it.unibo.apice.oop.p19reflection.annotations;

public class RangeIterator implements java.util.Iterator<Integer>{

    private int current;
    final private int stop;
    
    public RangeIterator(final int start, final int stop){
    	if (start>stop){
    		throw new IllegalArgumentException();
    	}
    	this.current = start;
    	this.stop = stop;
    }
    
    public Integer next(){
    	if (this.current >= this.stop){  // next() oltre i limiti
    	    throw new java.util.NoSuchElementException(); 
    	}
    	return this.current++;
    }
    
    public boolean hasNext(){
    	return this.current <= this.stop;
    }
    
    public void remove(){
    	throw new UnsupportedOperationException();
    }
}
