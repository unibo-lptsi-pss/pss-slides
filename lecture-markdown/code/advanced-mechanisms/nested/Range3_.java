public class Range3 implements Iterable<Integer>{
    
    final private int start;
    final private int stop;
    public Range3(int start, int stop){
    	//.. usuale implementazione
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
