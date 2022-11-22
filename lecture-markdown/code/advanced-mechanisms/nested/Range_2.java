public class Range implements Iterable<Integer> {
    ...
    private static class Iterator 
              implements java.util.Iterator<Integer> {
        private int current;
        private final int stop;
        
        public Iterator(final int start, final int stop) {
        	this.current = start;
        	this.stop = stop;
        }
        
        public Integer next() {
        	return this.current++;
        }
        
        public boolean hasNext() {
        	return this.current <= this.stop;
        }
        
        public void remove() { }
    }
}
