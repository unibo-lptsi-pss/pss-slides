package it.unibo.apice.oop.p09generics.generics;

public class List<X> {

	final private X head;
	final private List<X> tail;

	public List(X head, List<X> tail) {
		this.head = head;
		this.tail = tail;
	}

	public X getHead() { // Testa della lista
		return this.head;
	}

	public List<X> getTail() { // Coda della lista
		return this.tail;
	}

	public int getLength() { // Dimensione della lista
		return (this.tail == null) ? 1 : 1 + this.tail.getLength();
	}

	public String toString() { // Rappr. a stringa
		return "|" + this.head
				+ ((this.tail == null) ? "|" : this.tail.toString());
	}
}
