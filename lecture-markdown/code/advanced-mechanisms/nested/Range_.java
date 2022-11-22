public class Range implements Iterable<Integer> {

    final private int start;
    final private int stop;

    public Range(final int start, final int stop) {
        this.start = start;
        this.stop = stop;
    }

    public java.util.Iterator<Integer> iterator() {
        return new Iterator(this.start, this.stop);
    }

    private static class Iterator 
              implements java.util.Iterator<Integer>{
        ...
    }
}
