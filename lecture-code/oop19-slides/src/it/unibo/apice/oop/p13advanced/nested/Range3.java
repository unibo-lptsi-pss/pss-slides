package it.unibo.apice.oop.p13advanced.nested;

public class Range3 implements Iterable<Integer>{
    
    private final int start;
    private final int stop;
    
    public Range3(final int start, final int stop){
    	this.start = start;
    	this.stop = stop;
    }
    
    public java.util.Iterator<Integer> iterator(){
    	class Iterator implements java.util.Iterator<Integer>{
            
            private int current;
            
            public Iterator(){
            	this.current = Range3.this.start;
            }
            
            public Integer next(){
            	return this.current++;
            }
            
            public boolean hasNext(){
            	return this.current <= Range3.this.stop;
            }
            
            public void remove(){}
        }
    	return new Iterator();
    }
}
