package it.unibo.apice.oop.p13advanced.nested;

public class Range2 implements Iterable<Integer> {

	private final int start;
	private final int stop;

	public Range2(final int start, final int stop) {
		this.start = start;
		this.stop = stop;
	}

	public java.util.Iterator<Integer> iterator() {
		return this.new Iterator();
	}

	private class Iterator implements java.util.Iterator<Integer> {
		
		private int current;

		public Iterator() {
			this.current = Range2.this.start; // this.current = start
		}

		public Integer next() {
			return this.current++;
		}

		public boolean hasNext() {
			return this.current <= Range2.this.stop;
		}

		public void remove() {}
	}
}
