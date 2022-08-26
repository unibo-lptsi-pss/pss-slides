package it.unibo.apice.oop.p16lambda.interfaces;

import java.util.*;

@FunctionalInterface
public interface SimpleIterator2<X> {
	
	X getNext();
	
	default List<X> getListOfNext(int n){ // template method
		final List<X> l = new LinkedList<>();
		for (int i = 0; i < n; i++){
			l.add(getNext());
		}
		return l;
	}
	
}
