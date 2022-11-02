public class Range4 implements Iterable<Integer>{
    
    final private int start;
    final private int stop;
    
    public Range4(int start, int stop){
    	this.start = start;
    	this.stop = stop;
    }
    
    public java.util.Iterator<Integer> iterator(){
    	return new java.util.Iterator<Integer>(){
            // Non ci può essere costruttore!
            private int current = start; // o anche Range.this.start
            
            public Integer next(){
            	return this.current++;
            }
            public boolean hasNext(){
            	return this.current <= stop; // o anche Range.this.stop
            }
            public void remove(){}
        };
    }
}
