public class RangeIterator implements java.util.Iterator<Integer>{

    final private static String MSG = "start can't be bigger than stop";    
    private int current;
    private int stop;
    
    public RangeIterator(int start, int stop){
    	if (start > stop){	// parametri errati
    	    throw new java.lang.IllegalArgumentException(MSG); 
    	}
    	this.current = start;
    	this.stop = stop;
    }
    
    public Integer next(){
    	if (this.current > this.stop){  // next() oltre i limiti
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
