package it.unibo.apice.oop.p12exceptions.classes;

public class RangeIterator implements java.util.Iterator<Integer>{

    private static final String MSG = "start can't be bigger than stop";    
    private int current;
    final private int stop;
    
    public RangeIterator(final int start, final int stop){
    	if (start > stop){	// parametri errati
    	    throw new java.lang.IllegalArgumentException(MSG); 
    	}
    	this.current = start;
    	this.stop = stop;
    }
    
    public Integer next(){
    	if (!this.hasNext()){
    	    throw new java.util.NoSuchElementException(); 
    	}
    	return this.current++;
    }
    
    public boolean hasNext(){
    	return this.current <= this.stop;
    }
    
    public void remove(){	// non supportiamo remove
    	throw new UnsupportedOperationException(); 
    }
}
