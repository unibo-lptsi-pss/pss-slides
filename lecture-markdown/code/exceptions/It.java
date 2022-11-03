public class RangeIterator implements Iterator<Integer>{
    private int current;
    private int stop;
    
    public Integer next(){
    	if (current > stop) { throw ???} // lancio eccezione
    	return this.current++;
    }
    ..
