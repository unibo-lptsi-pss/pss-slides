package it.unibo.apice.oop.p09generics.iterators;

/* Itera tutti i numeri interi fra 'start' e 'stop' inclusi */
public class IntRangeIterator implements Iterator<Integer>{
    
    private int current; 		// valore corrente
    private final int stop;     // valore finale
    
    public IntRangeIterator(final int start, final int stop){
    	this.current = start;
    	this.stop = stop;
    }
    
    public Integer next(){
    	return this.current++;
    }
    
    public boolean hasNext(){
    	return this.current <= this.stop;
    }
}
