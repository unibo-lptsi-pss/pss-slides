package it.unibo.apice.oop.p10collections.collection;

import java.util.*;

/* Permette di definire un set di valori integer incrementali,
 senza doverli esplicitamente inserire in memoria, e quindi
 prediligendo l'occupazione in memoria al tempo d'accesso */

public class RangeSet extends AbstractSet<Integer> {

	private final int start;
	private final int stop;

	public RangeSet(final int start, final int stop) {
		this.start = start;
		this.stop = stop;
	}

	public int size() {
		return (this.stop >= this.start) ? this.start - this.stop + 1 : 0;
	}

	public Iterator<Integer> iterator() {
		// Il RangeIterator già visto...
		return new RangeIterator(this.start, this.stop);
	}
}
