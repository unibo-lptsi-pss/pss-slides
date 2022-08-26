package it.unibo.apice.oop.p10collections.iterator;

public class Range implements Iterable<Integer>{
    
    private final int start;
    private final int stop;
    
    public Range(final int start, final int stop){
    	this.start = start;
    	this.stop = stop;
    }
    
    public java.util.Iterator<Integer> iterator(){
    	return new RangeIterator(this.start,this.stop);
    }
}
