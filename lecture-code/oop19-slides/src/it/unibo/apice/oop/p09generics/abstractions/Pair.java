package it.unibo.apice.oop.p09generics.abstractions;

public class Pair<X,Y> {
	
	final private X first;
	final private Y second;
	
	public Pair(X first,Y second){
		this.first = first;
		this.second = second;
	}

	public X getFirst() {
		return first;
	}

	public Y getSecond() {
		return second;
	}

}
