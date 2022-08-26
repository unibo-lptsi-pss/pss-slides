package it.unibo.apice.oop.p10collections.iterator;

class RangeIterator implements java.util.Iterator<Integer>{
    
    private int current;
    private final int stop;
    
    public RangeIterator(final int start, final int stop){
    	this.current = start;
    	this.stop = stop;
    }
    
    public Integer next(){
    	return this.current++;
    }
    
    public boolean hasNext(){
    	return this.current <= this.stop;
    }
    
    public void remove(){}
}
