package it.unibo.apice.oop.p09generics.abstractions;

public class ObjectVector {

	private final static int INITIAL_SIZE = 10;

	private Object[] elements; // Deposito elementi
	private int size; // Numero di elementi

	public ObjectVector() { // Inizialmente vuoto
		this.elements = new Object[INITIAL_SIZE];
		this.size = 0;
	}

	public void addElement(final Object e) {
		if (this.size == elements.length) {
			this.expand(); // Se non c'è spazio
		}
		this.elements[this.size] = e;
		this.size++;
	}

	public Object getElementAt(final int position) {
		return this.elements[position];
	}

	public int getLength() {
		return this.size;
	}

	private void expand() { // Raddoppio lo spazio..
		final Object[] newElements = new Object[this.elements.length * 2];
		for (int i = 0; i < this.elements.length; i++) {
			newElements[i] = this.elements[i];
		}
		this.elements = newElements;
	}

	public String toString() {
		String s = "|";
		for (int i = 0; i < size; i++) {
			s = s + this.elements[i] + "|";
		}
		return s;
	}
}
