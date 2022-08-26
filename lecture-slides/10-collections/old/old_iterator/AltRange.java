public class AltRange implements Iterable<Integer>,
				 java.util.Iterator<Integer>{
    
    private int current;
    private int stop;
    
    public AltRange(int start, int stop){
    	this.current = start;
    	this.stop = stop;
    }
    
    public java.util.Iterator<Integer> iterator(){
    	return this;
    }
    
    public Integer next(){
    	return this.current++;
    }
    
    public boolean hasNext(){
    	return this.current <= this.stop;
    }
    
    public void remove(){}
}
