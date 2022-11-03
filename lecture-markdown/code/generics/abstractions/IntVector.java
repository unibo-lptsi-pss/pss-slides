public class IntVector {

	private final static int INITIAL_SIZE = 10;

	private int[] elements; // Deposito elementi
	private int size; // Numero di elementi

	public IntVector() { // Inizialmente vuoto
		this.elements = new int[INITIAL_SIZE];
		this.size = 0;
	}

	public void addElement(int e) {
		if (this.size == elements.length) {
			this.expand(); // Se non c'è spazio
		}
		this.elements[this.size] = e;
		this.size++;
	}

	public int getElementAt(int position) {
		// Non controlla a dovere i limiti!
		return this.elements[position];
	}

	public int getLength() {
		return this.size;
	}

	private void expand() { // Raddoppio lo spazio..
		int[] newElements = new int[this.elements.length * 2];
		for (int i = 0; i < this.elements.length; i++) {
			newElements[i] = this.elements[i];
		}
		this.elements = newElements;
	}

	public String toString() { // Soluzione performante!
		StringBuilder s = new StringBuilder("|");
		for (int i = 0; i < size; i++) {
			s.append(this.elements[i] + "|");
		}
		return s.toString();
	}
}
