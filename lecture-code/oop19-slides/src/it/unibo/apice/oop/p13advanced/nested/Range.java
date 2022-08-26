package it.unibo.apice.oop.p13advanced.nested;

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
    
    private static class RangeIterator implements java.util.Iterator<Integer>{
        
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
}
