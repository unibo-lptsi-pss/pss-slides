package it.unibo.apice.oop.p18patterns.combined;

import java.util.NoSuchElementException;

// Un decoratore che usa lo strategy
public class FilteredEIterator<X> implements EIterator<X>{
	private EIterator<X> iterator;
	private Predicate<X> predicate;
		
	public FilteredEIterator(EIterator<X> it, Predicate<X> predicate){
		this.iterator = it;
		this.predicate = predicate;
	}
	
	@Override
	public X next() throws NoSuchElementException {
		X x = this.iterator.next();
		return predicate.holds(x) ? x : next();
	}
}
