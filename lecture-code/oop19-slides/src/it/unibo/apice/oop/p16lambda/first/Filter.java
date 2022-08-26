package it.unibo.apice.oop.p16lambda.first;

public interface Filter<X> {
	
	// Does element x pass the filter?
	boolean applyFilter(X x);
	
}
