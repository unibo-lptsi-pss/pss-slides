package it.unibo.apice.oop.p11gencoll2.abstractions;

public class Pair<X, Y> {

	final private X first;
	final private Y second;

	public Pair(X first, Y second) {
		this.first = first;
		this.second = second;
	}

	public X getFirst() {
		return this.first;
	}

	public Y getSecond() {
		return this.second;
	}

	public String toString() {
		return "<" + this.first + "," + this.second + ">";
	}
}
