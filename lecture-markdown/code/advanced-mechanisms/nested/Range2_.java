public class Range2 implements Iterable<Integer> {

    final private int start;
    final private int stop; // final è essenziale in questo caso

    public Range2(int start, int stop){
    	.. // usuale implementazione
    }

    public java.util.Iterator<Integer> iterator() {
        return this.new Iterator();
    }

    private class Iterator implements java.util.Iterator<Integer> {
        private int current;

        public Iterator() {
            this.current = Range2.this.start;
        }

        public Integer next() {
            return this.current++;
        }

        public boolean hasNext() {
            return this.current <= Range2.this.stop;
        }

        public void remove() { }
    }
}
