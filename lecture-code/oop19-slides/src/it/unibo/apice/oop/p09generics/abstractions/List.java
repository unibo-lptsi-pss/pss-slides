package it.unibo.apice.oop.p09generics.abstractions;

/* Lista linkata di oggetti, con soli metodi getter */
public class List<X> {

	private final X head;
	private final List<X> tail;

	public List(final X head, final List<X> tail) {
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
