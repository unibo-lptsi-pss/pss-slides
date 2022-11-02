public class Range implements Iterable<Integer>{
    
    final private int start;
    final private int stop;
    
    public Range(int start, int stop){
    	this.start = start;
    	this.stop = stop;
    }
    
    public java.util.Iterator<Integer> iterator(){
    	return new RangeIterator(this.start,this.stop);
    }
}
