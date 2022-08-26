public class RangeIterator implements java.util.Iterator<Integer>{
    
    private int current;
    private int stop;
    
    public RangeIterator(int start, int stop){
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
